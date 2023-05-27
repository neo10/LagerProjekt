package main;

public class Papier extends Produkt{
    private final String Farbe;
    private final String Groesse;
    Papier(String Farbe, String Groesse){
        this.Farbe = Farbe;
        this.Groesse = Groesse;
        this.name = "Papier";
    }
    public String getFarbe(){
        return Farbe;
    }
    public String getGröße(){
        return Groesse;
    }

}
