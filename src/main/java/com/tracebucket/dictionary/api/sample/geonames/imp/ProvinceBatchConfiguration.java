package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.Country;
import com.tracebucket.dictionary.api.Province;
import com.tracebucket.dictionary.api.sample.geonames.CountryInfo;
import com.tracebucket.dictionary.api.sample.geonames.ProvinceInfo;
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
public class ProvinceBatchConfiguration {
    @Bean
    public Job importProvinceJob(JobBuilderFactory jobs, @Qualifier("provinceStep1") Step s1, ProvinceJobCompletionNotificationListener listener) {
        return jobs.get("importProvinceJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }


    @Bean
    public Step provinceStep1(StepBuilderFactory stepBuilderFactory, ProvinceReader provinceReader,
                             ProvinceWriter provinceWriter , ProvinceProcessor provinceProcessor) {
        return stepBuilderFactory.get("provinceStep1")
                .<ProvinceInfo, Province> chunk(1000)
                .reader(provinceReader)
                .processor(provinceProcessor)
                .writer(provinceWriter)
                .build();
    }

}
