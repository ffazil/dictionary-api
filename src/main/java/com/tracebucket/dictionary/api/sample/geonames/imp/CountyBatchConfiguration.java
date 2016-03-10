package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.County;
import com.tracebucket.dictionary.api.sample.geonames.CountyInfo;
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
 * @author nidhintony
 * @since 09/03/16
 */
@Slf4j
@Configuration
@EnableBatchProcessing
public class CountyBatchConfiguration {
    @Bean
    public Job importCountyJob(JobBuilderFactory jobs, @Qualifier("countyStep1") Step s1, CountyJobCompletionNotificationListener listener) {
        return jobs.get("importCountyJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step countyStep1(StepBuilderFactory stepBuilderFactory, CountyReader countyReader,
                              CountyWriter countyWriter , CountyProcessor countyProcessor) {
        return stepBuilderFactory.get("countyStep1")
                .<CountyInfo, County> chunk(1000)
                .reader(countyReader)
                .processor(countyProcessor)
                .writer(countyWriter)
                .build();
    }
}
