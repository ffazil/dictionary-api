package com.tracebucket.dictionary.api.sample.geonames;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author ffazil
 * @since 07/03/16
 */

@Slf4j
@Component
public class DefaultGeonamesRepository implements GeonamesRepository {
    private static String geoNameGetCountriesListUrl = "http://api.geonames.org/countryInfoJSON?username=demo";
    private static String geoNameGetProvincesForCountryListUrl = "http://api.geonames.org/childrenJSON?username=demo";
    private static String geoNameGetZipforLocation = "http://api.geonames.org/findNearbyPostalCodesJSON?username=demo";


    private final RestTemplate restTemplate;

    public DefaultGeonamesRepository(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<CountryInfo> getCountries() {
        ResponseEntity<CountriesInfo> responseEntity = restTemplate.getForEntity(geoNameGetCountriesListUrl, CountriesInfo.class);
        CountriesInfo countries = responseEntity.getBody();
        List<CountryInfo> countryInfoList = Arrays.asList(countries.getGeonames());
        return countryInfoList;
    }

    @Override
    public List<ProvinceInfo> getProvincesForCountry(String countryId){
        ResponseEntity<ProvincesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + countryId, ProvincesInfo.class);
        ProvincesInfo provincesInfo = responseEntity.getBody();
        List<ProvinceInfo> provinces = Arrays.asList(provincesInfo.getGeonames());
        return provinces;
    }

    @Override
    public List<CountyInfo> getCountiesForProvince(String provinceId){
        ResponseEntity<CountiesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + provinceId, CountiesInfo.class);
        CountiesInfo countiesInfo = responseEntity.getBody();
        List<CountyInfo> counties = Arrays.asList(countiesInfo.getGeonames());
        return counties;
    }

    @Override
    public List<ZoneInfo> getZonesForCounty(String countyId){
        ResponseEntity<ZonesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + countyId, ZonesInfo.class);
        ZonesInfo zonesInfo = responseEntity.getBody();
        List<ZoneInfo> zones = Arrays.asList(zonesInfo.getGeonames());
        return zones;
    }

    @Override
    public List<ZipInfo> getZipsForPlace(String key){
        ResponseEntity<ZipsInfo> responseEntity = restTemplate.getForEntity(geoNameGetZipforLocation + "&placename=" + key, ZipsInfo.class);
        ZipsInfo zipsInfo = responseEntity.getBody();
        List<ZipInfo> zips = Arrays.asList(zipsInfo.getPostalCodes());
        return zips;
    }
}
