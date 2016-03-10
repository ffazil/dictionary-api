package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.sample.geonames.*;
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
 * @since 10/03/16
 */
@Slf4j
@Component
@StepScope
public class ZoneReader implements ItemReader<ZoneInfo> {

    @Autowired
    private GeonamesRepository geonamesRepository;

    private List<ProvinceInfo> provinces;

    private List<CountyInfo> counties;

    private List<ZoneInfo> zones;

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
        zones = new LinkedList<>();
        counties.parallelStream().forEach(cys -> {
            List<ZoneInfo> zone = geonamesRepository.getZonesForCounty(cys.getGeonameId());
            zones.addAll(zone);
        });
    }

    @Override
    public ZoneInfo read() {
        if(!zones.isEmpty()){
            return zones.remove(0);
        }
        log.info("No more zones {}", zones.size());
        return null;
    }
}
