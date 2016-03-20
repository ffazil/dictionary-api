package com.tracebucket.dictionary.api.geo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author ffazil
 * @since 07/03/16
 */
@Data
@Embeddable
public class Alpha3Code {

    @Column(unique = true)
    private final String alpha3Code;

    public Alpha3Code(String code){
        this.alpha3Code = code;
    }

    protected Alpha3Code(){
        this(null);
    }
}
