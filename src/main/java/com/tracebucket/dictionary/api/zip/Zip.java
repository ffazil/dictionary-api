package com.tracebucket.dictionary.api.zip;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ffazil
 * @since 01/03/16
 */

@Data
@Document
public class Zip {

    @Id
    private final  String id;

    private final String postalCode;

    private final String countryCode;

    private final String placeName;

    private final String adminName1;

    private final Integer adminCode1;

    private final String adminName2;

    private final Integer adminCode2;

    private final String adminName3;

    private final Integer adminCode3;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private final Point location;

    private final Integer accuracy;

    public Zip(String postalCode,
               String countryCode,
               String placeName,
               String adminName1,
               Integer adminCode1,
               String adminName2,
               Integer adminCode2,
               String adminName3,
               Integer adminCode3,
               Point location,
               Integer accuracy){
        this.id = null;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
        this.placeName = placeName;
        this.adminName1 = adminName1;
        this.adminCode1 = adminCode1;
        this.adminName2 = adminName2;
        this.adminCode2 = adminCode2;
        this.adminName3 = adminName3;
        this.adminCode3 = adminCode3;
        this.location = location;
        this.accuracy = accuracy;


    }

}
