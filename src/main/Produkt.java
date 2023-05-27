package main;

//Hilfsklasse, die aus der orders.java ein Stein, Holz oder Papier Objekt erstellt

public abstract class Produkt {
    public String name;
    private String Farbe = null;
    private String Größe = null;
    private String Art = null;
    private String Form = null;
    private String Gewicht = null;

    public static Produkt neuesProdukt(){
        Orders newOrder = new Orders();
        String[] order = newOrder.getNextOrder();
        if(order[2].equals("Papier")){
            return new Papier(order[3],order[4]);
        }
        else if(order[2].equals("Holz")){
            return new Holz(order[3],order[4]);
        }
        else if(order[2].equals("Stein")){
            return new Stein(order[3],order[4]);
        }
        else{
            return null;
        }
    }
    public String getFarbe(){
        return Farbe;
    }
    public String getGröße(){
        return Größe;
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