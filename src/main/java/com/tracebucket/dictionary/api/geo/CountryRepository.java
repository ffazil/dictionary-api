package com.tracebucket.dictionary.api.geo;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ffazil
 * @since 01/03/16
 */
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>{
    /**
     * Find by {@link Alpha2Code}
     *
     * @param alpha2Code
     * @return
     */
    public Country findByAlpha2Code(Alpha2Code alpha2Code);
}
