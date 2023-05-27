package main;

import java.util.Arrays;

public class start {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Orders newOrder = new Orders();
        String[] order = newOrder.getNextOrder();
        System.out.println("Order: " + Arrays.toString(order));

        Produkt newProdukt = Produkt.neuesProdukt();
        System.out.println(newProdukt.getClass().getName());
        System.out.println("Produkt: " + newProdukt.name);
        System.out.println("Farbe: " + newProdukt.getFarbe());

    }
}
