package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.Province;
import com.tracebucket.dictionary.api.ProvinceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nidhintony
 * @since 08/03/16
 */
@Slf4j
@Component
public class ProvinceWriter implements ItemWriter<Province>{

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public void write(List<? extends Province> provinces) throws Exception {
        provinceRepository.save(provinces);
    }
}
