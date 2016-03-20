package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.geo.County;
import com.tracebucket.dictionary.api.geo.CountyRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nidhintony
 * @since 14/03/16
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CountyWriter implements ItemWriter<County> {

    @NonNull
    private final CountyRepository countyRepository;

    @Override
    public void write(List<? extends County> items) throws Exception {
        countyRepository.save(items);
    }
}
