package main;

public class Eingang {
    // Dieses Array enthält nur Referenzen zu Objekten, die neu erstellt wurden
    Auftrag [] ErstenDreiAuftraege = new Auftrag[3];

    public Eingang(){

    }
    public boolean leeresArrayFeld(){
        if(ErstenDreiAuftraege[0] == null || ErstenDreiAuftraege[1] == null || ErstenDreiAuftraege[2] == null){
            return true;
        }
        else return false;
    }
    public void pushAuftrag(Auftrag newAuftrag){
        if(leeresArrayFeld() == false){
            System.out.println("Eingang ist voll");
            return;
        }
        if(ErstenDreiAuftraege[0] == null){
            ErstenDreiAuftraege[0] = newAuftrag;
        }
        else if(ErstenDreiAuftraege[1] == null){
            ErstenDreiAuftraege[1] = newAuftrag;
        }
        else if(ErstenDreiAuftraege[2] == null){
            ErstenDreiAuftraege[2] = newAuftrag;
        }
    }
    public Auftrag getErstenAuftrag(){
        return ErstenDreiAuftraege[0].getAuftrag();
    }
    public Auftrag getZweitenAuftrag(){
        return ErstenDreiAuftraege[1].getAuftrag();
    }
    public Auftrag getDrittenAuftrag(){
        return ErstenDreiAuftraege[2].getAuftrag();
    }
    public void LoescheErstenAuftrag(){
        ErstenDreiAuftraege[0] = null;
    }
    public void LoescheZweitenAuftrag(){
        ErstenDreiAuftraege[1] = null;
    }
    public void LoescheDrittenAuftrag(){
        ErstenDreiAuftraege[2] = null;
    }
}
