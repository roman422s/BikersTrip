
package com.example;

import java.util.ArrayList;

public class DataAll {
    private ArrayList<Motor> motorji;
    private ArrayList<Pot> poti;

    public  int sizePot(){return poti.size();}
    public DataAll(){
        motorji = new ArrayList<Motor>();
        poti = new ArrayList<Pot>();
    }

    public void dodaj(Motor m ){motorji.add(m);}
    public void dodaj(Pot p){poti.add(p);}

    @Override
    public String toString() {
        return "DataAll{" +
                "motorji=" + motorji +
                ", poti=" + poti +
                '}';
    }

    public Pot getPot(int i){return  poti.get(i);}
    public ArrayList<Pot> isci(String nekaj) {
        ArrayList<Pot> najdeni = new ArrayList<>();
        for (int i=0; i<poti.size(); i++) {
            if (poti.get(i).jeIzbran(nekaj)) najdeni.add(poti.get(i));
        }
        return najdeni;
    }

    public static int picture(String tip){
        if(tip.equals("Sport")) return 1;
        if(tip.equals("Chopper")) return 2;
        if(tip.equals("Tourer")) return 3;
        if(tip.equals("Naked Bike")) return 4;
        if(tip.equals("Enduro/Cross")) return 5;
        if(tip.equals("Scooter")) return 6;
        if(tip.equals("Moped")) return 7;
        if(tip.equals("ATV / UTV")) return 8;
        if(tip.equals("Supermoto")) return 9;
        if(tip.equals("Ostalo")) return 0;
        return 0;
    }

    public static DataAll getScenarijData(){
        DataAll all = new DataAll();
        all.dodaj(new Motor("Kavasaki","z800", 2009, "naked bike" ));
        all.dodaj(new Motor("Honda","hornet", 2015, "sport" ));
        all.dodaj(new Motor("BMW","s1000rr", 2015, "sport" ));
        all.dodaj(new Pot("Slovenska Bistrica", "Maribor", 115.4, 20.5, all.motorji.get(0),"14.5.2016" ));
        all.dodaj(new Pot("Slovenska Bistrica", "Celje", 95.4, 24.5, all.motorji.get(1),"20.5.2016" ));
        all.dodaj(new Pot("Trebnje", "Ljubljana", 75.4, 36.5, all.motorji.get(2),"23.5.2016" ));
        all.dodaj(new Pot("Lendava", "Ljubljana", 95.4, 130, all.motorji.get(0),"25.5.2016" ));
        all.dodaj(new Pot("Smetanova ulica 17", "Smetanova ulica 31", 0.3 ,3.5, all.motorji.get(0),"2.6.2016" ));

        return all;
    }

    public static DataAll setMyData(Pot p){
        DataAll dodano = new DataAll();

        dodano.dodaj(p);

        return  dodano;
    }

    public static DataAll dodaj(){
        DataAll dodano = new DataAll();

        dodano.dodaj();

        return  dodano;
    }


}
