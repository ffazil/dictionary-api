package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.Zone;
import com.tracebucket.dictionary.api.ZoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nidhintony
 * @since 10/03/16
 */
@Slf4j
@Component
public class ZoneWriter implements ItemWriter<Zone> {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public void write(List<? extends Zone> zones) throws Exception {
        zoneRepository.save(zones);
    }
}
