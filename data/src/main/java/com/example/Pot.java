package com.example;

import java.util.ArrayList;

/**
 * Created by Roman on 30. 04. 2016.
 */
public class Pot {

    private String krajOd;
    private String krajDo;
    private double maxHitrost;
    private double casVoznje; //minute
    private Motor m;
    private String datum;

    ArrayList<Pos> pos;

    /*
    //dodatni podatki poti
    private double povprecnaHitrost; // km/h
    private double maxHitrost; // km/h
    private double prevozeniKM; //km
    private double trenutnoStPrevozenih; //km

     */



    public Pot(String krajOd, String krajDo, double maxHitrost, double casVoznje, Motor m, String datum) {
        this.krajOd = krajOd;
        this.krajDo = krajDo;
        this.maxHitrost = maxHitrost;
        this.casVoznje = casVoznje;
        this.m = m;
        this.datum=datum;

        new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Pot{" +
                "krajOd='" + krajOd + '\'' +
                ", krajDo='" + krajDo + '\'' +
                ", maxHitrost=" + maxHitrost +
                ", casVoznje=" + casVoznje +
                ", m=" + m +
                ", datum=" + datum +
                '}';
    }

    public String getKrajOd() {
        return krajOd;
    }

    public void setKrajOd(String krajOd) {
        this.krajOd = krajOd;
    }

    public String getKrajDo() {
        return krajDo;
    }

    public void setKrajDo(String krajDo) {
        this.krajDo = krajDo;
    }

    public double getMaxHitrost() {
        return maxHitrost;
    }

    public void setMaxHitrost(double maxHitrost) {
        this.maxHitrost = maxHitrost;
    }

    public double getCasVoznje() {
        return casVoznje;
    }

    public void setCasVoznje(double casVoznje) {
        this.casVoznje = casVoznje;
    }

    public Motor getM() {
        return m;
    }

    public void setM(Motor m) {
        this.m = m;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean jeIzbran(String kljuc) {
        if (krajOd.contains(kljuc)) return true;
        if (krajDo.equals(kljuc)) return true;
        return false;
    }

    public ArrayList<Pos> getPos() {
        return pos;
    }

    public void setPos(ArrayList<Pos> pos) {
        this.pos = pos;
    }
}
