package main;

public class Auftrag {
    private final int Anzahl;
    private final String AuftragsArt;
    private final Produkt Produkt;

    public Auftrag(Orders newOrder){
        String[] order = newOrder.getNextOrder();
        this.Anzahl = Integer.parseInt(order[5]);
        this.AuftragsArt = order[1];
        switch (order[2]) {
            case "Papier" -> Produkt = new Papier(order[3], order[4]);
            case "Holz" -> Produkt = new Holz(order[3], order[4]);
            case "Stein" -> Produkt = new Stein(order[3], order[4]);
            default -> Produkt = null;
        }
    }
    public int getAnzahl(){
        return Anzahl;
    }
    public String getAuftragsArt(){
        return AuftragsArt;
    }
    public Produkt getProdukt(){
        return Produkt;
    }
    public Auftrag getAuftrag(){
        return this;
    }

}
