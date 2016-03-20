package com.tracebucket.dictionary.api.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tracebucket.dictionary.api.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.*;

/**
 * @author ffazil
 * @since 01/03/16
 */
@Entity
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country extends AbstractEntity {

    @Column(unique = true)
    private final String name;

    private final Alpha2Code alpha2Code;

    private final Alpha3Code alpha3Code;

    private final Currency currency;

    private final Continent continent;

    private final Double area;

    private final Double population;

    private final Location location;

    protected Country(){
        this(null, null, null, null, null, null, null, null);
    }
}
