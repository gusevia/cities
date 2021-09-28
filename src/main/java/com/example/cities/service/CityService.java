package com.example.cities.service;

import com.example.cities.model.City;
import com.example.cities.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveCities(List<City> cities) {
        if (cities != null && !cities.isEmpty()) {
            for (City city : cities) {
                cityRepository.save(city);
            }
        }
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public List<City> findAllSortedByName() {
        return cityRepository.findAllIgnoreCaseByOrderByName();
    }

    public List<City> findAllSortedByDistrictAndName() {
        return cityRepository.findAllOrderedByDistrictAndName();
    }

    public String findMaxPopulationCity() {
        City[] cities = (City[]) cityRepository.findAll().toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getPopulation() > max) {
                max = cities[i].getPopulation();
                index = i;
            }
        }
        return "[" + index + "] = " + max;

    }

    public void numberCitiesInRegions() {


        Map<String, Long> map = cityRepository.findAll().stream().collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        System.out.println(map);
    }


}
