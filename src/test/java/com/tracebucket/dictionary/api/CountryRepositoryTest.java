package com.tracebucket.dictionary.api;

import com.tracebucket.dictionary.api.geo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ffazil
 * @since 05/03/16
 */
public class CountryRepositoryTest extends AbstractIntegrationTest{

    @Autowired
    private CountryRepository countryRepository;
}
