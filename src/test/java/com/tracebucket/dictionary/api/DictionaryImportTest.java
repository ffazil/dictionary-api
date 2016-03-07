package com.tracebucket.dictionary.api;

import com.tracebucket.dictionary.api.sample.geonames.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author ffazil
 * @since 06/03/16
 */
@Slf4j
public class DictionaryImportTest{
    private static String geoNameGetCountriesListUrl = "http://api.geonames.org/countryInfoJSON?username=demo";
    private static String geoNameGetProvincesForCountryListUrl = "http://api.geonames.org/childrenJSON?username=demo";
    private static String geoNameGetZipforLocation = "http://api.geonames.org/findNearbyPostalCodesJSON?username=demo";


    private RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void countryImports(){
        List<CountryInfo> countries = getCountries();
        countries.forEach(c -> {
            List<ProvinceInfo> provinces = getProvincesForCountry(c.getGeonameId());
            provinces.forEach(p -> {
                List<CountyInfo> counties = getCountiesForProvince(p.getGeonameId());
                System.out.println(counties.size());
            });
        });
    }

    @Test
    public void getDetailsForIndia(){
        List<ProvinceInfo> provinces = getProvincesForCountry("1269750");
        provinces.forEach(p -> {
            List<CountyInfo> counties = getCountiesForProvince(p.getGeonameId());
            System.out.println(counties.size());
        });
    }

    @Test
    public void getDetailsForBangalore(){
        List<ZoneInfo> zones = getZonesForCounty("1277331");
        zones.forEach(z -> {
            System.out.println(z.toString());
        });
    }
    @Test
    public void getZipsforPlace(){
        List<ZipInfo> zips = getZipsForPlace("edava");
        zips.forEach(z -> {
            System.out.println(z.toString());
        });
    }

    private List<CountryInfo> getCountries() {
        ResponseEntity<CountriesInfo> responseEntity = restTemplate.getForEntity(geoNameGetCountriesListUrl, CountriesInfo.class);
        CountriesInfo countries = responseEntity.getBody();
        List<CountryInfo> countryInfoList = Arrays.asList(countries.getGeonames());
        return countryInfoList;
    }

    private List<ProvinceInfo> getProvincesForCountry(String countryId){
        ResponseEntity<ProvincesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + countryId, ProvincesInfo.class);
        ProvincesInfo provincesInfo = responseEntity.getBody();
        List<ProvinceInfo> provinces = Arrays.asList(provincesInfo.getGeonames());
        return provinces;
    }

    private List<CountyInfo> getCountiesForProvince(String provinceId){
        ResponseEntity<CountiesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + provinceId, CountiesInfo.class);
        CountiesInfo countiesInfo = responseEntity.getBody();
        List<CountyInfo> counties = Arrays.asList(countiesInfo.getGeonames());
        return counties;
    }

    private List<ZoneInfo> getZonesForCounty(String countyId){
        ResponseEntity<ZonesInfo> responseEntity = restTemplate.getForEntity(geoNameGetProvincesForCountryListUrl + "&geonameId=" + countyId, ZonesInfo.class);
        ZonesInfo zonesInfo = responseEntity.getBody();
        List<ZoneInfo> zones = Arrays.asList(zonesInfo.getGeonames());
        return zones;
    }

    private List<ZipInfo> getZipsForPlace(String key){
        ResponseEntity<ZipsInfo> responseEntity = restTemplate.getForEntity(geoNameGetZipforLocation + "&placename=" + key, ZipsInfo.class);
        ZipsInfo zipsInfo = responseEntity.getBody();
        List<ZipInfo> zips = Arrays.asList(zipsInfo.getPostalCodes());
        return zips;
    }
}
