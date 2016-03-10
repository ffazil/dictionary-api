package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.*;
import com.tracebucket.dictionary.api.sample.geonames.CountyInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 09/03/16
 */
@Slf4j
@Component
public class CountyProcessor  implements ItemProcessor<CountyInfo, County> {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    public County process(CountyInfo countyInfo) throws Exception {
        Province province = provinceRepository.findByadminCode1(countyInfo.getAdminCode1());
        return new County(countyInfo.getName(),
                Double.valueOf(countyInfo.getPopulation()),
                new Location(Double.valueOf(countyInfo.getLat()).doubleValue(), Double.valueOf(countyInfo.getLng()).doubleValue()),
                province);
    }
}
