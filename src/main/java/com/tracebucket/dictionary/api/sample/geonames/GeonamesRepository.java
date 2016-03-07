package com.tracebucket.dictionary.api.sample.geonames;

import java.util.List;

/**
 * @author ffazil
 * @since 07/03/16
 */
public interface GeonamesRepository {
    List<CountryInfo> getCountries();

    List<ProvinceInfo> getProvincesForCountry(String countryId);

    List<CountyInfo> getCountiesForProvince(String provinceId);

    List<ZoneInfo> getZonesForCounty(String countyId);

    List<ZipInfo> getZipsForPlace(String key);
}
