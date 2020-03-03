package com.company;

import java.util.Comparator;

class CityTempComparator implements Comparator<Main.Weather> {

    @Override
    public int compare(Main.Weather weather1, Main.Weather weather2) {
        if( weather1.main.temp > weather2.main.temp) return 1;
        if( weather1.main.temp < weather2.main.temp) return -1;

        return 0;
    }
}
