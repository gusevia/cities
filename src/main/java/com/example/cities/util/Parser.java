package com.example.cities.util;

import com.example.cities.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public static List<City> parseCityFromFile(String path) {

        List<City> cities = new ArrayList<>();
        File file = new File(path);


        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] cityData = scanner.nextLine().split(";");
                String name=cityData[0];
                String region=cityData[1];
                String district=cityData[2];
                int population=Integer.parseInt(cityData[3]);
                String foundation=cityData[4];

                City city=new City(name,region,district,population,foundation);
                cities.add(city);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

}
