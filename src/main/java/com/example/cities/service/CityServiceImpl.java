package com.example.cities.service;

import com.example.cities.model.City;
import com.example.cities.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void saveCities(List<City> cities) {
        if (cities != null && !cities.isEmpty()) {
            for (City city : cities) {
                cityRepository.save(city);
            }
        }
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> findAllSortedByName() {
        return cityRepository.findAllIgnoreCaseByOrderByName();
    }

    @Override
    public List<City> findAllSortedByDistrictAndName() {
        return cityRepository.findAllOrderedByDistrictAndName();
    }

    @Override
    public String findMaxPopulationCity() {
        City[] cities = cityRepository.findAll().toArray(new City[0]);
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

    @Override
    public void numberCitiesInRegions() {

        Map<String, Long> map = cityRepository.findAll().stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        System.out.println(map);
    }


}
