package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.*;
import com.tracebucket.dictionary.api.sample.geonames.ProvinceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 08/03/16
 */
@Slf4j
@Component
public class ProvinceProcessor implements ItemProcessor<ProvinceInfo, Province>{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Province process(ProvinceInfo provinceInfo) throws Exception {
        Country country = countryRepository.findByAlpha2Code(new Alpha2Code(provinceInfo.getCountryCode()));
        Province province = new Province(provinceInfo.getName(),
                new Location(Double.valueOf(provinceInfo.getLat()).doubleValue(), Double.valueOf(provinceInfo.getLng()).doubleValue()),
                Double.valueOf(provinceInfo.getPopulation()),
                country);
        return province;
    }
}
