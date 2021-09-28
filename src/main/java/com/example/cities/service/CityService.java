package com.example.cities.service;

import com.example.cities.model.City;

import java.util.List;

public interface CityService {

    /**
     * Сохранение городов в БД
     */
    void saveCities(List<City> cities);

    /**
     * Поиск в БД всех городов
     */
    List<City> findAll();

    /**
     * Возвращает список городов, отсортированный по имени без учета регистра
     * @return  List<City>
     */
    List<City> findAllSortedByName();

    /**
     * Возвращает список городов, отсортированный сначала по федеральному округу, затем по имени города
     * @return List<City>
     */
    List<City> findAllSortedByDistrictAndName();

    /**
     * Ищет город с максимальным населением
     * @return String
     */
    String findMaxPopulationCity();

    /**
     * Показывает количество городов в разбивке по регионам
     */
     void numberCitiesInRegions();
}
