package com.tracebucket.dictionary.api.sample.geonames;

import lombok.Data;

/**
 * @author ffazil
 * @since 06/03/16
 */
@Data
public class ZonesInfo {
    private String totalResultsCount;

    private ZoneInfo[] geonames;
}
