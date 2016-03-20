package com.tracebucket.dictionary.api.geo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ffazil
 * @since 01/03/16
 */
public interface CountyRepository extends PagingAndSortingRepository<County, Long>{

    /**
     *
     * @param featureCode
     * @param admin2Code
     * @return
     */
    public County findByFeatureCodeAndAdmin2Code(String featureCode, String admin2Code);

    /**
     *
     * @param key
     * @return
     */
    public List<County> findByNameContainingIgnoreCase(@Param("key") String key);

    /**
     *
     * @param key
     * @return
     */
    public List<County> findByProvinceNameContainingIgnoreCase(@Param("key") String key);
}
