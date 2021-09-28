package com.example.cities;

import com.example.cities.model.City;
import com.example.cities.service.CityService;
import com.example.cities.util.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CitiesApplication {

    private final static String PATH = "/Users/a19572284/Desktop/cities.txt";

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(CitiesApplication.class, args);
        CityService cityService = applicationContext.getBean("cityService", CityService.class);

        List<City> cities = Parser.parseCityFromFile(PATH);
        cityService.saveCities(cities);

        boolean loop = true;
        while (loop) {
            System.out.println("Выберете требуемое действие");
            System.out.println("1) Список городов");
            System.out.println("2) Отсортированный список городов по имени");
            System.out.println("3) Отсортированный список городов по федеральному округу и имени");
            System.out.println("4) Город с наибольшей популяцией");
            System.out.println("5) Количество городов в регионах");
            System.out.println("6) Выход");


            Scanner scanner = new Scanner(System.in);
            switch (scanner.next()) {
                case "1":
                    List<City> allCities = cityService.findAll();
                    allCities.forEach(System.out::println);
                    break;
                case "2":
                    List<City> allCitiesSorted = cityService.findAllSortedByName();
                    allCitiesSorted.forEach(System.out::println);
                    break;
                case "3":
                    List<City> allCitiesSortedByDistrictAndName = cityService.findAllSortedByDistrictAndName();
                    allCitiesSortedByDistrictAndName.forEach(System.out::println);
                    break;
                case "4":
                    System.out.println(cityService.findMaxPopulationCity());
                    break;
                case "5":
                    cityService.numberCitiesInRegions();
                    break;
                case "6":
                    loop = false;
                    scanner.close();
                    break;
            }
        }

    }
}
