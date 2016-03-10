package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import com.tracebucket.dictionary.api.sample.geonames.CountyInfo;
import com.tracebucket.dictionary.api.sample.geonames.GeonamesRepository;
import com.tracebucket.dictionary.api.sample.geonames.ProvinceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nidhintony
 * @since 09/03/16
 */
@Slf4j
@Component
@StepScope
public class CountyReader  implements ItemReader<CountyInfo> {

    @Autowired
    private GeonamesRepository geonamesRepository;

    private List<ProvinceInfo> provinces;

    private List<CountyInfo> counties;

    @BeforeStep
    public void readData(final StepExecution stepExecution) {
        List<CountryInfo> countries = geonamesRepository.getCountries();
        provinces = new LinkedList<>();
        countries.parallelStream().forEach(c -> {
            List<ProvinceInfo> p = geonamesRepository.getProvincesForCountry(c.getGeonameId());
            provinces.addAll(p);
        });
        counties = new LinkedList<>();
        provinces.parallelStream().forEach(p -> {
            List<CountyInfo> county = geonamesRepository.getCountiesForProvince(p.getGeonameId());
            counties.addAll(county);
        });
    }

    @Override
    public CountyInfo read() {
        if(!counties.isEmpty()){
            return counties.remove(0);
        }
        log.info("No more counties {}", counties.size());
        return null;
    }

}
