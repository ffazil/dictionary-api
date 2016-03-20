package com.tracebucket.dictionary.api.zip;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author ffazil
 * @since 01/03/16
 */
public interface ZipRepository extends PagingAndSortingRepository<Zip, String>, QueryDslPredicateExecutor<Zip>{
    List<Zip> findByPlaceNameContainingIgnoreCase(@Param("place") String place);
    Page<Zip> findByLocationNear(@Param("location") Point location, @Param("distance") Distance distance, Pageable pageable);

}
