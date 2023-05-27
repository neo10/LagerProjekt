package main;

public class Papier extends Produkt{
    private String Farbe;
    private String Größe;
    Papier(String Farbe, String Größe){
        this.Farbe = Farbe;
        this.Größe = Größe;
        this.name = "Papier";
    }
    public String getFarbe(){
        return Farbe;
    }
    public String getGröße(){
        return Größe;
    }

}
