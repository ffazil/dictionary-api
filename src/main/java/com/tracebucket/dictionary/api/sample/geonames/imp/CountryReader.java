package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import com.tracebucket.dictionary.api.sample.geonames.GeonamesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ffazil
 * @since 07/03/16
 */
@Slf4j
@Component
@StepScope
public class CountryReader implements ItemReader<CountryInfo>{

    @Autowired
    private GeonamesRepository geonamesRepository;

    private List<CountryInfo> countries;

    @BeforeStep
    public void readData(final StepExecution stepExecution) {
        countries = new LinkedList<>(geonamesRepository.getCountries());
    }

    @Override
    public CountryInfo read() {
        if(!countries.isEmpty()){
            return countries.remove(0);
        }
        log.info("No more countries {}", countries.size());
        return null;
    }
}
