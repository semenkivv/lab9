package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherEntity {
    transient public String city;

    @JsonProperty("temperature")
    public String temperature;

    @JsonProperty("wind")
    public String wind;

    @JsonProperty("description")
    public String sky;

    @JsonProperty("forecast")
    public List<WeatherForecastSubEntity> forecastList;

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", sky='" + sky + '\'' +
                ", forecastList=" + forecastList +
                '}';
    }
}
