package com.company;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    class main {
        double temp;
    }
    class Weather {
        String name;
        main main;

        @Override
        public String toString() {
            double tempC = ((main.temp - 273.15) * 100)/100;
            tempC = Math.round(tempC);
            return "Город: " + name + " температура: " + tempC;
        }
    }
    public static void main(String[] args) throws IOException {

        int[] citiesID = {2023469, 4778626, 3067696, 2950159, 1609350, 1816670, 3624908, 2988507, 1497337, 360630, 2051523};

        ArrayList<Weather> cities = new ArrayList<>();
        for (int cityID : citiesID) {
            cities.add(getWeather(cityID));
        }
        cities.sort(new CityTempComparator());
        Collections.reverse(cities);

        for ( Weather city: cities) {
            System.out.println(city.toString());
        }
    }

    static Weather getWeather(int cityID) throws IOException {
        String addressAPI = "http://api.openweathermap.org/data/2.5/weather?id=";
        String apiKey = "&appid=6996730d2314bd13dd41c1edaad78ad6";

        URL url = new URL(addressAPI + Integer.toString(cityID) + apiKey);
        InputStream answer = (InputStream) url.getContent();
        Gson gson = new Gson();
        Weather weather = gson.fromJson(new InputStreamReader(answer), Weather.class);

        return weather;
    }
}