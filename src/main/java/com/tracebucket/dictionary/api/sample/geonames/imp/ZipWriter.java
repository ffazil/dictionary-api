package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.zip.Zip;
import com.tracebucket.dictionary.api.zip.ZipRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nidhintony
 * @since 20/03/16
 */
@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ZipWriter implements ItemWriter<Zip> {

    @NonNull
    private final ZipRepository zipRepository;

    @Override
    public void write(List<? extends Zip> items) throws Exception {
        zipRepository.save(items);
    }
}
