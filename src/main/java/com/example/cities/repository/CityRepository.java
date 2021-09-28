package com.example.cities.repository;

import com.example.cities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CityRepository extends JpaRepository<City, Long> {


    List<City> findAllIgnoreCaseByOrderByName();


    @Query("SELECT c FROM City c ORDER BY c.district,c.name")
    List<City> findAllOrderedByDistrictAndName();


}
