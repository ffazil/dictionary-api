package com.tracebucket.dictionary.api.sample.geonames;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author ffazil
 * @since 07/03/16
 */
@Data
public class ZipInfo {

    private String adminName2;

    private String adminName3;

    private String adminCode1;

    private String distance;

    private String postalCode;

    private String countryCode;

    private String placeName;

    private String lng;

    private String lat;
    @JsonProperty("ISO3166-2")
    private String ISO3166_2;

    private String adminName1;

}
