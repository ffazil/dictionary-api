package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.*;
import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author ffazil
 * @since 08/03/16
 */
@Slf4j
@Component
public class CountryProcessor implements ItemProcessor<SampleData, Country>{
    @Override
    public Country process(SampleData item) throws Exception {
        if(item.getFeatureCode().equals("PCLI")){
            return new Country(item.getAsciiName(),
                    new Alpha2Code(item.getAlpha2Code()),
                    new Alpha3Code(item.getAlpha2Code()),
                    Currency.getInstance(new Locale("en", item.getAlpha2Code())),
                    Continent.Asia,
                    new Double(0),
                    new Double(item.getPopulation().toString()),
                    new Location(Double.valueOf(item.getLatitude()), Double.valueOf(item.getLongitude())));
        }

        return null;
    }


}
