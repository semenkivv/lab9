package com.bogdan;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filter {
    public static WeatherEntity getByCity(ArrayList<WeatherEntity> list, String city){
        return list.stream().filter(x -> x.city.equals(city)).findAny().orElse(null);
    }
}
