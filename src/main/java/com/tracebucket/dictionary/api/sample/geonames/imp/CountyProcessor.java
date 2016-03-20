package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.geo.County;
import com.tracebucket.dictionary.api.geo.Location;
import com.tracebucket.dictionary.api.geo.Province;
import com.tracebucket.dictionary.api.geo.ProvinceRepository;
import com.tracebucket.dictionary.api.sample.geonames.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 14/03/16
 */
@Slf4j
@Component
public class CountyProcessor implements ItemProcessor<SampleData, County> {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public County process(SampleData item) throws Exception {
        if(item.getFeatureCode().equals("ADM2")){
            Province province = provinceRepository.findByAdmin1Code(item.getAdmin1Code());

            return new County(
                    item.getAsciiName(),
                    new Double(item.getPopulation().toString()),
                    new Location(Double.valueOf(item.getLatitude()), Double.valueOf(item.getLongitude())),
                    item.getFeatureCode(),
                    item.getAdmin1Code(),
                    item.getAdmin2Code(),
                    province
            );
        }

        return null;
    }
}
