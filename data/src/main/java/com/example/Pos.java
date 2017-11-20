package com.example;

/**
 * Created by Roman on 8. 06. 2016.
 */
public class Pos {
    long lat, lon;

    public Pos(long lat, long lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }
}
