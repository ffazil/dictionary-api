package com.tracebucket.dictionary.api.geo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author nidhintony
 * @since 13/03/16
 */
public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
    /**
     *
     * @param key
     * @return
     */
    public List<Province> findByNameContainingIgnoreCase(@Param("key") String key);


    public List<Province> findByCountry(@Param("country") Country country);

    public Province findByAdmin1Code(Integer admin1Code);

    /**
     *
     * @param featureCode
     * @param admin1Code
     * @return
     */
    public Province findByFeatureCodeAndAdmin1Code(String featureCode, Integer admin1Code);
}
