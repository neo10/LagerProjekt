package main;

import java.util.Arrays;
import java.util.TreeMap;

public class start {

    public static void main(String[] args) {

        Orders OrderObjekt = new Orders();
        Lagerist LageristObjekt = new Lagerist("Lagerist");

        mainFrame Frame = new mainFrame("test", 1440, 900);
        Logik GameLogik = new Logik(OrderObjekt, LageristObjekt,Frame);
        Frame.setGameLogik(GameLogik);
        Frame.initNordPanel();
        Frame.initSuedPanel();
        Frame.initMittePanel();
        Frame.initOstPanel();
        Frame.setVisible();


        System.out.println("Hello World!");


        }


    }
