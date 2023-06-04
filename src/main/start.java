package main;

import java.util.Arrays;


public class start {

    public static void main(String[] args) {

        Orders OrderObjekt = new Orders();
        Auftrag AuftragObjekt = new Auftrag(OrderObjekt);
        Lagerist LageristObjekt = new Lagerist("Lagerist");
        Logik GameLogik = new Logik(AuftragObjekt, LageristObjekt);

        mainFrame mainFrame = new mainFrame("test", 1440, 900, GameLogik);
        mainFrame.setUpUntenLeiste();
        mainFrame.setUpRegal();
        mainFrame.setUpInfoLeiste();
        mainFrame.setUpRechteLeiste();
        mainFrame.setVisible();


        System.out.println("Hello World!");

        String[] order = OrderObjekt.getNextOrder();
        System.out.println("Order: " + Arrays.toString(order));

        System.out.println("Auftrag: " + AuftragObjekt.getAuftragsArt());
        System.out.println("Auftrag: " + AuftragObjekt.getAnzahl());
        System.out.println("Auftrag: " + AuftragObjekt.getProdukt().getName());
        //Saldo saldo = new Saldo();
        }


    }
