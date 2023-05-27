package main;

public class Stein extends Produkt{
    private final String Art;
    private final String Gewicht;

    public Stein(String Art, String Gewicht){
        this.Art = Art;
        this.Gewicht = Gewicht;
        this.name = "Stein";
    }
    public String getArt(){
        return Art;
    }
    public String getGewicht(){
        return Gewicht;
    }
}
