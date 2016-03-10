package com.tracebucket.dictionary.api;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author nidhintony
 * @since 08/03/16
 */
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
    /**
     *
     * @param country
     * @return
     */
    List<Province> findByCountry(Country country);

    /**
     *
     * @param adminCode1
     * @return
     */
    Province findByadminCode1(String adminCode1);
}
