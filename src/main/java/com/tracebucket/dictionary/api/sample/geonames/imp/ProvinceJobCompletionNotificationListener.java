package com.tracebucket.dictionary.api.sample.geonames.imp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

/**
 * @author ffazil
 * @since 08/03/16
 */
@Slf4j
@Component
public class ProvinceJobCompletionNotificationListener extends JobExecutionListenerSupport{
    ProvinceJobCompletionNotificationListener(){

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! Province Import JOB FINISHED! Time to verify the results");

        }
    }
}