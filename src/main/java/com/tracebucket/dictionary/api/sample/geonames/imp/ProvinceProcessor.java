package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.geo.*;
import com.tracebucket.dictionary.api.sample.geonames.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 13/03/16
 */
@Slf4j
@Component
public class ProvinceProcessor implements ItemProcessor<SampleData, Province> {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Province process(SampleData item) throws Exception {
        if(item.getFeatureCode().equals("ADM1")){
            Country country = countryRepository.findByAlpha2Code(new Alpha2Code(item.getAlpha2Code()));

            return new Province(
                    item.getAsciiName(),
                    new Location(Double.valueOf(item.getLatitude()), Double.valueOf(item.getLongitude())),
                    new Double(item.getPopulation().toString()),
                    item.getFeatureCode(),
                    item.getAdmin1Code(),
                    country
            );
        }

        return null;
    }
}
