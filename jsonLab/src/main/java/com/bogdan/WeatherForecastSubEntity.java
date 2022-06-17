package com.bogdan;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecastSubEntity{
    @JsonProperty("day")
    public int day;

    @JsonProperty("temperature")
    public String temperature;

    @JsonProperty("wind")
    public String wind;

    @Override
    public String toString() {
        return "Forecast{" +
                "day=" + day +
                ", temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }
}
