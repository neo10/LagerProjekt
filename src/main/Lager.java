package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Lager {
    private Auftrag E1Auftrag;
    private Auftrag E2Auftrag;
    private Auftrag E3Auftrag;
    private Orders OrdersObjekt;

    TreeMap<String, Auftrag> HochRegalBestand = new TreeMap<String, Auftrag> ();

    public Lager(Orders ordersObjekt){
        E1Auftrag = null;
        E2Auftrag = null;
        E3Auftrag = null;
        this.OrdersObjekt = ordersObjekt;
    }

    public String getButtonText(String ButtonActionC){
        if(HochRegalBestand.get(ButtonActionC)!=null){
            String rButtonText = HochRegalBestand.get(ButtonActionC).getProdukt().getName();
            return rButtonText;
        }
        else return "Leer";
    }
    public int Einlagern(Auftrag Auftrag,String Lagerplatz, mainFrame Frame,int eingang){
        int tempErtrag;
        //****************Prüfungen****************
        if(Auftrag == null){
            Frame.openDialog("Fehler, Es wurde kein Auftrag ausgewählt.");
            return -1;
        }
        else if(Auftrag.getAuftragsArt()!= "Einlagerung"){
            Frame.openDialog("Fehler, Es wurde kein Einlagerungsauftrag ausgewählt.");
            return -1;
        }
        if(!LagerPlatzFrei(Lagerplatz)){
            Frame.openDialog("Fehler, Lagerplatz ist bereits belegt.");
            return -1;
        }
        //****************Stein Prüfungen****************
        if(getAuftrag(eingang).getProdukt().getName()=="Stein"&&getAuftrag(eingang).getProdukt().getEigenschaft2() == "Schwer" && !imUnterstenRegal(Lagerplatz)){
            Frame.openDialog("Fehler: Schwerer Stein darf nur in der untersten Etage eingelagert werden.");
            return -1;
        }else if(getAuftrag(eingang).getProdukt().getName()=="Stein"&&getAuftrag(eingang).getProdukt().getEigenschaft2() == "Mittel" && imOberstenRegal(Lagerplatz)){
            Frame.openDialog("Fehler: Mittelschwerer Stein darf nicht in der obersten Etage eingelagert werden.");
            return -1;
        }
        //****************Stein Prüfungen****************



        HochRegalBestand.put(Lagerplatz, Auftrag);
        if(Auftrag == E1Auftrag){
            tempErtrag = AuftragErledigt(1);
            Frame.updateEingang(this);
            return tempErtrag;
        } else if(Auftrag == E2Auftrag){
            tempErtrag = AuftragErledigt(2);
            Frame.updateEingang(this);
            return tempErtrag;
        } else if(Auftrag == E3Auftrag){
            tempErtrag = AuftragErledigt(3);
            Frame.updateEingang(this);
            return tempErtrag;
        }
        return -1;
    }
    public int Auslagern(String Lagerplatz,int eingang,mainFrame Frame){
        if(getAuftrag(eingang).getAuftragsArt()!= "Auslagerung"){
            Frame.openDialog("Fehler: Auslagern nur mit einem Auslagerungsauftrag möglich.");
            return -1;

        }else if(getAuftrag(eingang).getProdukt().getName()!=HochRegalBestand.get(Lagerplatz).getProdukt().getName()){
            Frame.openDialog("Fehler: Auftrag will anderes Produkt ausgelagert haben.");
            return -1;}


        if(!LagerPlatzFrei(Lagerplatz)){
            HochRegalBestand.remove(Lagerplatz);
            return AuftragErledigt(eingang);

        } else return -1;
    }
    public boolean setNeuenAuftragImEingang(mainFrame Frame){
        if(E1Auftrag == null){
            E1Auftrag = new Auftrag(this.OrdersObjekt);
           return true;
        }
        else if(E2Auftrag == null){
            E2Auftrag = new Auftrag(this.OrdersObjekt);
            return true;
        }
        else if(E3Auftrag == null){
            E3Auftrag = new Auftrag(this.OrdersObjekt);
            return true;
        }
        else return false;
    }
    public boolean LagerPlatzFrei(String Lagerplatz){
        if(HochRegalBestand.get(Lagerplatz)!=null){
            return false;
        } else return true;}
    public Auftrag getAuftrag(int number){
        switch (number){
            case 1: return E1Auftrag;
            case 2: return E2Auftrag;
            case 3: return E3Auftrag;
            default: return null;
        }
    }
    public int AuftragErledigt(int number){
        int temp;
        switch (number){
            case 1: {if(E1Auftrag == null)return -1;
                temp = E1Auftrag.getBelohnung();
                E1Auftrag = null;
                return temp;}
            case 2: {if(E2Auftrag == null)return -1;
                temp = E2Auftrag.getBelohnung();
                E2Auftrag = null;
                return temp;}
            case 3: {if(E3Auftrag == null)return -1;
                temp = E3Auftrag.getBelohnung();
                E3Auftrag = null;
                return temp;}
            default: return -1;
        }
    }
    public int Ablehnen(int number){
        int temp;
        switch (number){
            case 1: {if(E1Auftrag == null)return -1;
                    temp = -E1Auftrag.getBelohnung();
                    E1Auftrag = null;
                    return temp;}
            case 2: {if(E2Auftrag == null)return -1;
                temp = -E2Auftrag.getBelohnung();
                E2Auftrag = null;
                return temp;}
            case 3: {if(E3Auftrag == null)return -1;
                temp = -E3Auftrag.getBelohnung();
                E3Auftrag = null;
                return temp;}
            default: return -1;
        }
    }

    public int verschrotten(String Lagerplatz){
        if(!LagerPlatzFrei(Lagerplatz)){
            HochRegalBestand.remove(Lagerplatz);
            return -300;
        } else return -1;
    }
    public TreeMap<String, Auftrag> getHochRegalBestand(){
        return HochRegalBestand;
    }
    public boolean imOberstenRegal(String Lagerplatz){
        if(Lagerplatz.charAt(6)=='1')return true;
        else return false;
    }
    public boolean imUnterstenRegal(String Lagerplatz){
        if(Lagerplatz.charAt(6)=='4')return true;
        else return false;
    }
}
