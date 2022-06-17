package com.bogdan;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetWeatherJsonFromUrl {
    private WeatherEntity entity;
    public void get(String url, String cityName){
        try{
            URL tUrl = new URL(url+cityName);
            HttpURLConnection http = (HttpURLConnection) tUrl.openConnection();
            http.setRequestProperty("Accept","application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String bufferJson = in.readLine();
            ObjectMapper mapper = new ObjectMapper();
            WeatherEntity weather = mapper.readValue(bufferJson,WeatherEntity.class);
            in.close();
            http.disconnect();
            weather.city = cityName;
            this.entity = weather;
            return;
        } catch (IOException e) {
            entity = null;
            e.printStackTrace();
        }
    }

    public Thread runInThread(String url, String cityName){
        Runnable task = ()->{ get(url,cityName);};
        Thread thread = new Thread(task);
        thread.start();
        return thread;
    }

    public WeatherEntity getEntity() {
        return entity;
    }
}
