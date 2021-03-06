package com.tracebucket.dictionary.api.geo;

import com.tracebucket.dictionary.api.AbstractEntity;
import com.tracebucket.dictionary.api.geo.County;
import com.tracebucket.dictionary.api.geo.Location;
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
public class Zone extends AbstractEntity {

    private final String name;

    private final Double population;

    private final Location location;

    @ManyToOne(cascade = CascadeType.MERGE)
    private final County county;

    protected Zone(){
        this(null, null, null, null);
    }
}
