package main;

public class Lagerist {
    private final String name;
    private Saldo saldo;

    public Lagerist(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
/*    public void Einlagern(Auftrag Auftrag){
        if (Auftrag.getAuftragsArt() == "Einlagern"){
            saldo.add(Auftrag.getProdukt(), Auftrag.getAnzahl());
        }
    }*/


}
