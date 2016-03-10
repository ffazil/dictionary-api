package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.CountryRepository;
import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import com.tracebucket.dictionary.api.sample.geonames.GeonamesRepository;
import com.tracebucket.dictionary.api.sample.geonames.ProvinceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author nidhintony
 * @since 08/03/16
 */
@Slf4j
@Component
@StepScope
public class ProvinceReader implements ItemReader<ProvinceInfo> {

    @Autowired
    private GeonamesRepository geonamesRepository;

    private List<ProvinceInfo> provinces;

    private List<CountryInfo> countries;

    @BeforeStep
    public void readData(final StepExecution stepExecution) {
        countries = geonamesRepository.getCountries();
        provinces = new LinkedList<>();
        countries.parallelStream().forEach(c -> {
            List<ProvinceInfo> p = geonamesRepository.getProvincesForCountry(c.getGeonameId());
            provinces.addAll(p);
        });
    }

    @Override
    public ProvinceInfo read() {
        if(!provinces.isEmpty()){
            return provinces.remove(0);
        }
        log.info("No more provinces {}", provinces.size());
        return null;
    }
}
