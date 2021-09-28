package com.example.cities.repository;

import com.example.cities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CityRepository extends JpaRepository<City, Long> {

    /**
     * Возвращает список городов, отсортированный по имени без учета регистра
     * @return  List<City>
     */
    List<City> findAllIgnoreCaseByOrderByName();

    /**
     * Возвращает список городов, отсортированный сначала по федеральному округу, затем по имени города
     * @return List<City>
     */
    @Query("SELECT c FROM City c ORDER BY c.district,c.name")
    List<City> findAllOrderedByDistrictAndName();


}
