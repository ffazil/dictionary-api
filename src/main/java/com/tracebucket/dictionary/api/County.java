package com.tracebucket.dictionary.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author ffazil
 * @since 01/03/16
 */
@Entity
@Getter
@AllArgsConstructor
public class County extends AbstractEntity{

    private final String name;

    private final Double population;

    private final Location location;

    @ManyToOne(cascade = CascadeType.MERGE)
    private final Province province;

    protected County(){
        this(null, null, null, null);
    }
}
