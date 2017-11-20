package com.example;

import java.util.ArrayList;

/**
 * Created by Roman on 30. 04. 2016.
 */
public class MyPot {
    public static void main(String arg[]){
        System.out.println("testni izpis");
        Motor nov = new Motor("yamaha", "R1", 2007, "sport" );
        Pot p = new Pot("Celje", "Maribor", 60.0, 30.5, nov, "14.5.2016");
        System.out.println(nov.toString());
        System.out.println(p);

        DataAll a = new DataAll();
        a.dodaj(nov);
        a.dodaj(p);
        a.dodaj(new Motor("Honda", "Hornet", 2005, "Naked bike"));
        a.dodaj(new Pot("Ljubljana", "Novo mesto", 134.5, 105.3, nov, "15.5.2016" ));

        System.out.println(a);
        ArrayList<Pot> iskanje = a.isci("M");
        System.out.println(iskanje);


    }

}
