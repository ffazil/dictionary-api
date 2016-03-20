package com.tracebucket.dictionary.api.geo;

import com.tracebucket.dictionary.api.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author ffazil
 * @since 01/03/16
 */
@Entity
@Getter
@AllArgsConstructor
public class County extends AbstractEntity {

    private final String name;

    private final Double population;

    private final Location location;

    private final String featureCode;

    private final Integer admin1Code;

    private final String admin2Code;

    @ManyToOne
    private final Province province;

    protected County(){
        this(null, null, null, null, null, null, null);
    }
}
