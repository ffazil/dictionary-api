package com.tracebucket.dictionary.api.sample.geonames.imp;

import com.tracebucket.dictionary.api.sample.geonames.SampleZipData;
import com.tracebucket.dictionary.api.zip.Zip;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

/**
 * @author nidhintony
 * @since 20/03/16
 */
@Slf4j
@Component
public class ZipProcessor implements ItemProcessor<SampleZipData, Zip> {

    @Override
    public Zip process(SampleZipData item) throws Exception {
        return new Zip(
                item.getPostalCode(),
                item.getCountryCode(),
                item.getPlaceName(),
                item.getAdminName1(),
                item.getAdminCode1(),
                item.getAdminName2(),
                item.getAdminCode2(),
                item.getAdminName3(),
                item.getAdminCode3(),
                new Point(Double.valueOf(item.getLongitude()), Double.valueOf(item.getLatitude())),
                item.getAccuracy()
        );
    }
}
