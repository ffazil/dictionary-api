package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.*;
import com.tracebucket.dictionary.api.sample.geonames.ZoneInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 10/03/16
 */
@Slf4j
@Component
public class ZoneProcessor implements ItemProcessor<ZoneInfo, Zone> {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private CountyRepository countyRepository;

    @Autowired
    public Zone process(ZoneInfo zoneInfo) throws Exception {
        County county = countyRepository.findByadminCode2(zoneInfo.getAdminCode2());
        return new Zone(zoneInfo.getName(),
                Double.valueOf(zoneInfo.getPopulation()),
                new Location(Double.valueOf(zoneInfo.getLat()).doubleValue(), Double.valueOf(zoneInfo.getLng()).doubleValue()),
                county);
    }
}
