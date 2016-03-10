package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.County;
import com.tracebucket.dictionary.api.CountyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nidhintony
 * @since 09/03/16
 */
@Slf4j
@Component
public class CountyWriter implements ItemWriter<County> {

    @Autowired
    private CountyRepository countyRepository;

    @Override
    public void write(List<? extends County> counties) throws Exception {
        countyRepository.save(counties);
    }
}
