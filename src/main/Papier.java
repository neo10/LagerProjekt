package main;

public class Papier extends Produkt{
    private final String name = "Papier";
    Papier(String Eigenschaft1, String Eigenschaft2){
        super(Eigenschaft1, Eigenschaft2);
    }
    public String getName(){
        return name;
    }


}
