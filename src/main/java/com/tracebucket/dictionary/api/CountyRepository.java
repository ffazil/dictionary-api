package com.tracebucket.dictionary.api;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author ffazil
 * @since 01/03/16
 */
public interface CountyRepository extends PagingAndSortingRepository<County, Long>{
    /**
     *
     * @param adminCode2
     * @return
     */
    County findByadminCode2(String adminCode2);
}
