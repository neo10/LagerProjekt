package main;

import java.util.Arrays;


public class start {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Orders newOrder = new Orders();
        String[] order = newOrder.getNextOrder();
        System.out.println("Order: " + Arrays.toString(order));

        Auftrag newAuftrag = new Auftrag(newOrder);
        System.out.println("Auftrag: " + newAuftrag.getAuftragsArt());
        System.out.println("Auftrag: " + newAuftrag.getAnzahl());
        System.out.println("Auftrag: " + newAuftrag.getProdukt().getName());
        Saldo saldo = new Saldo();
        saldo.openGui();



        }

    }
