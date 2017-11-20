package com.example;

/**
 * Created by Roman on 30. 04. 2016.
 */
public class Motor {

    private String znamka;
    private String model;
    private int letnik;
    private String tip; // oblika motoja, naked, sport...

    public Motor(String znamka, String model, int letnik, String tip) {
        this.znamka = znamka;
        this.model = model;
        this.letnik = letnik;
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "znamka='" + znamka + '\'' +
                ", model='" + model + '\'' +
                ", letnik=" + letnik +
                ", tip='" + tip + '\'' +
                '}';
    }

    public String getZnamka() {
        return znamka;
    }

    public void setZnamka(String znamka) {
        this.znamka = znamka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLetnik() {
        return letnik;
    }

    public void setLetnik(int letnik) {
        this.letnik = letnik;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
