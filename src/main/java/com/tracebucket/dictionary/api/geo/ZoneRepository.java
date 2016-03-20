package com.tracebucket.dictionary.api.geo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author ffazil
 * @since 01/03/16
 */
public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long>{

    /**
     *
     * @param key
     * @return
     */
    public List<Zone> findByCountyNameContainingIgnoreCase(@Param("key") String key);

    List<Zone> findByNameContainingIgnoreCase(@Param("key") String key);
}
