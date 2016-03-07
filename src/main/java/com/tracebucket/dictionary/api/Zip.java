package com.tracebucket.dictionary.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author ffazil
 * @since 01/03/16
 */
@Entity
@Getter
@AllArgsConstructor
public class Zip extends AbstractEntity{

    private final String postalCode;

    private final String placeName;

    private final Double distance;

    private final Location location;

    @ManyToOne(cascade = CascadeType.MERGE)
    private final Province province;

    protected Zip(){
        this(null, null, null, null, null);
    }
}
