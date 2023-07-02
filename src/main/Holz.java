package main;

public class Holz  extends Produkt{
    private final String name = "Holz";
    Holz(String name,String Eigenschaft1, String Eigenschaft2){
        super(name,Eigenschaft1, Eigenschaft2);
    }
    public String getName(){
        return name;
    }
}
