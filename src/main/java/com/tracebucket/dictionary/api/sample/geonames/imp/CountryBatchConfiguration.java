package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.Country;
import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ffazil
 * @since 08/03/16
 */
@Slf4j
@Configuration
@EnableBatchProcessing
public class CountryBatchConfiguration {
    @Bean
    public Job importFlightJob(JobBuilderFactory jobs, @Qualifier("countryStep1") Step s1, CountryJobCompletionNotificationListener listener) {
        return jobs.get("importCountryJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }


    @Bean
    public Step countryStep1(StepBuilderFactory stepBuilderFactory, CountryReader countryReader,
                             CountryWriter countryWriter , CountryProcessor countryProcessor) {
        return stepBuilderFactory.get("countryStep1")
                .<CountryInfo, Country> chunk(1000)
                .reader(countryReader)
                .processor(countryProcessor)
                .writer(countryWriter)
                .build();
    }

}
