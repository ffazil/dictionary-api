package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.Zone;
import com.tracebucket.dictionary.api.sample.geonames.ZoneInfo;
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
 * @since 10/03/16
 */
@Slf4j
@Configuration
@EnableBatchProcessing
public class ZoneBatchConfiguration {
    @Bean
    public Job importZoneJob(JobBuilderFactory jobs, @Qualifier("zoneStep1") Step s1, ZoneJobCompletionNotificationListener listener) {
        return jobs.get("importZoneJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(s1)
                .end()
                .build();
    }

    @Bean
    public Step zoneStep1(StepBuilderFactory stepBuilderFactory, ZoneReader zoneReader,
                            ZoneWriter zoneWriter , ZoneProcessor zoneProcessor) {
        return stepBuilderFactory.get("zoneStep1")
                .<ZoneInfo, Zone> chunk(1000)
                .reader(zoneReader)
                .processor(zoneProcessor)
                .writer(zoneWriter)
                .build();
    }
}
