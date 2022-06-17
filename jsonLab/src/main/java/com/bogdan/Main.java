package com.bogdan;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jshell.execution.Util;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] cities = {"Lviv","Odesa","Toronto","Tokio","London"};
        GetWeatherJsonFromUrl get = new GetWeatherJsonFromUrl();
        ArrayList<WeatherEntity> wList = new ArrayList<>();
        for(var t : cities){
            var thread = get.runInThread("https://goweather.herokuapp.com/weather/",t);
            try{
                thread.join();
                if(get.getEntity()!=null)
                wList.add(get.getEntity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var tSorted = Sorter.sortBySky(wList);

        for(var t : tSorted){
            System.out.println(t);
        }
        System.out.println("----------");

        var ent = Filter.getByCity(tSorted,"Lviv");
        System.out.println(ent);

    }
}
