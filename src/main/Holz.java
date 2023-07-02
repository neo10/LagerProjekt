package main;

public class Holz  extends Produkt{
    private final String name = "Holz";
    Holz(String Eigenschaft1, String Eigenschaft2){
        super(Eigenschaft1, Eigenschaft2);
    }
    public String getName(){
        return name;
    }
}
