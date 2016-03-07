package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.*;
import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Currency;

/**
 * @author ffazil
 * @since 08/03/16
 */
@Slf4j
@Component
public class CountryProcessor implements ItemProcessor<CountryInfo, Country>{
    @Override
    public Country process(CountryInfo item) throws Exception {
        return new Country(item.getCountryName(),
                new Alpha2Code(item.getCountryCode()),
                new Alpha3Code(item.getIsoAlpha3()),
                Currency.getInstance(item.getCurrencyCode().isEmpty() ? "USD" : item.getCurrencyCode()),
                Continent.valueOf(item.getContinent()),
                Double.valueOf(item.getAreaInSqKm()),
                Double.valueOf(item.getPopulation()),
                new Location(0.0, 0.0));
    }
}
