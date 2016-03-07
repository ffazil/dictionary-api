package com.tracebucket.dictionary.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author ffazil
 * @since 06/03/16
 */
@Entity
@Getter
@AllArgsConstructor
public class Province extends AbstractEntity{

    private final String name;

    private final Location location;

    private final Double population;

    @ManyToOne
    private final Country country;

    protected Province(){
        this(null, null, null, null);
    }

}
