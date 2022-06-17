package com.bogdan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sorter {
    public static ArrayList<WeatherEntity> sortByTemperature(ArrayList<WeatherEntity> list){
        ArrayList<WeatherEntity> outList = new ArrayList<>(list);
        Comparator<WeatherEntity> byTemp = (WeatherEntity x, WeatherEntity y) ->{
          var xT = Integer.parseInt(x.temperature.replaceAll("\\D+",""));
          var yT = Integer.parseInt(y.temperature.replaceAll("\\D+",""));
          return Integer.compare(xT,yT);
        };
        outList.sort(byTemp);
        return outList;
    }
    public static ArrayList<WeatherEntity> sortByWind(ArrayList<WeatherEntity> list){
        ArrayList<WeatherEntity> outList = new ArrayList<>(list);
        Comparator<WeatherEntity> byWind = (WeatherEntity x, WeatherEntity y) ->{
            var xT = Integer.parseInt(x.wind.replaceAll("\\D+",""));
            var yT = Integer.parseInt(y.wind.replaceAll("\\D+",""));
            return Integer.compare(xT,yT);
        };
        outList.sort(byWind);
        return outList;
    }
    public static ArrayList<WeatherEntity> sortBySky(ArrayList<WeatherEntity> list){
        ArrayList<WeatherEntity> outList = new ArrayList<>(list);
        Comparator<WeatherEntity> bySky = Comparator.comparing((WeatherEntity x) -> x.sky);
        outList.sort(bySky);
        return outList;
    }
}
