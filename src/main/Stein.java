package main;

public class Stein extends Produkt{
    private final String name = "Stein";
    Stein(String name,String Eigenschaft1, String Eigenschaft2){
        super(name,Eigenschaft1, Eigenschaft2);
    }
    public String getName(){
        return name;
    }
}
