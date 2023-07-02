package main;

public class Auftrag {
    private final int Belohnung;
    private final String AuftragsArt;
    private final Produkt Produkt;


    public Auftrag(Orders OrderObjekt){
        String[] order = OrderObjekt.getNextOrder();
        this.Belohnung = Integer.parseInt(order[5]) ;
        this.AuftragsArt = order[1];
        switch (order[2]) {
            case "Papier" -> Produkt = new Papier("Papier",order[3], order[4]);
            case "Holz" -> Produkt = new Holz("Holz",order[3], order[4]);
            case "Stein" -> Produkt = new Stein("Stein",order[3], order[4]);
            default -> Produkt = null;
        }
    }
    public int getBelohnung(){
        return Belohnung;
    }
    public String getAuftragsArt(){
        return AuftragsArt;
    }
    public Produkt getProdukt(){
        return Produkt;
    }

}
