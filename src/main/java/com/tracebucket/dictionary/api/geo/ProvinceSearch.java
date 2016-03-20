package com.tracebucket.dictionary.api.geo;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author nidhintony
 * @since 20/03/16
 */
@Projection(name = "search", types = Province.class)
public interface ProvinceSearch {

    String getName();
    Location getLocation();
    Double getPopulation();
    CountrySearch getCountry();
}
