package main;

public class Holz  extends Produkt{
    private String Art;
    private String Form;

    public Holz(String Art, String Form){
        this.Art = Art;
        this.Form = Form;
        this.name = "Holz";
    }
    public String getArt(){
        return Art;
    }
    public String getForm(){
        return Form;
    }
}
