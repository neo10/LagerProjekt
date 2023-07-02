package main;

//Hilfsklasse, die aus der orders.java ein Stein, Holz oder Papier Objekt erstellt

public abstract class Produkt {
    private String Eigenschaft1;
    private String Eigenschaft2;

    private String name;

    public Produkt(String name,String Eigenschaft1, String Eigenschaft2){
        this.Eigenschaft1 = Eigenschaft1;
        this.Eigenschaft2 = Eigenschaft2;
        this.name = name;
    }
    public String getEigenschaft1(){
        return Eigenschaft1;
    }
    public String getEigenschaft2(){
        return Eigenschaft2;
    }
    public String getName(){
        return name;
    }


}
