package main;

//Hilfsklasse, die aus der orders.java ein Stein, Holz oder Papier Objekt erstellt

public abstract class Produkt {
    public String name;
    private final String Farbe = null;
    private final String Groesse = null;
    private final String Art = null;
    private final String Form = null;
    private final String Gewicht = null;

    public static Produkt neuesProdukt(){
        Orders newOrder = new Orders();
        String[] order = newOrder.getNextOrder();
        return switch (order[2]) {
            case "Papier" -> new Papier(order[3], order[4]);
            case "Holz" -> new Holz(order[3], order[4]);
            case "Stein" -> new Stein(order[3], order[4]);
            default -> null;
        };
    }
    public String getFarbe(){
        return Farbe;
    }
    public String getGroesse(){
        return Groesse;
    }
    public String getArt(){
        return Art;
    }
    public String getForm(){
        return Form;
    }
    public String getGewicht(){
        return Gewicht;
    }


}
