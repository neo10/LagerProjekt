package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Logik {
    private ActionEvent e;
    private Orders OrdersObjekt;
    private boolean verschrottenGeklickt = false;
    private boolean einlagernGeklickt = false;
    private boolean auslagernGeklickt = false;
    private Lagerist LageristObjekt;
    private Lager MeinLager;
    private Auftrag ausgewaehlterAuftrag;
    private String ausgewaehlterLagerplatz;
    private String Art;
    private String Produkt;
    private String Eigenschaft1;
    private String Eigenschaft2;
    private int Belohnung;
    private mainFrame Frame;
    private int eingang;
    private Saldo Saldo;

    public Logik(Orders ordersObjekt, Lagerist lageristObjekt, mainFrame Frame) {
        this.OrdersObjekt = ordersObjekt;
        this.LageristObjekt = lageristObjekt;
        this.MeinLager = new Lager(ordersObjekt);
        this.Frame = Frame;
        this.Saldo = new Saldo();
    }

    public void updateAusgewaehlterAuftragAttribute() {
        this.Art = ausgewaehlterAuftrag.getAuftragsArt();
        this.Produkt = ausgewaehlterAuftrag.getProdukt().getName();
        this.Eigenschaft1 = ausgewaehlterAuftrag.getProdukt().getEigenschaft1();
        this.Eigenschaft2 = ausgewaehlterAuftrag.getProdukt().getEigenschaft2();
        this.Belohnung = ausgewaehlterAuftrag.getBelohnung();
    }

    public void actionPerformed(ActionEvent e, mainFrame Frame) {
        JButton geklickterButton = (JButton) e.getSource();
        // Setzt exakt ein Attribut auf True | Operatoren:(Einlagern, Auslagern, Verschrotten)
        // Die Logik ist: Wenn auf einen Lagerplatz gedrückt wird, wird nur weitergearbeitet,
        // wenn genau ein Atttribut true ist. Das stellt sicher, dass vorher ein operator geklickt werden muss.
        this.e = e;
        updateOperatorGeklicked(geklickterButton.getActionCommand());
        switch (e.getActionCommand()) {
            case "Ablehnen":
                System.out.println(eingang);
                System.out.println(MeinLager.getAuftrag(1));
                System.out.println(MeinLager.getAuftrag(2));
                System.out.println(MeinLager.getAuftrag(3));

                // Gibt -1 bei Fehler aus. ansonsten die Kosten
                int tempErtrag = MeinLager.Ablehnen(eingang);
                if(tempErtrag != -1){
                    Saldo.addTransaktion("Auftrag abgelehnt", tempErtrag);
                }
                Frame.updateEingang(MeinLager);

                break;
            case "E1":
                System.out.println("E1");
                    eingang = 1;
                    setAktiverEingang(eingang);
                break;
            case "E2":
                System.out.println("E2");
                    eingang = 2;
                    setAktiverEingang(eingang);
                break;
            case "E3":
                System.out.println("E3");
                    eingang = 3;
                    setAktiverEingang(eingang);
                break;
            case "NeuerAuftrag":
                System.out.println("NeuerAuftrag");
                if (!MeinLager.setNeuenAuftragImEingang(Frame)) Frame.openDialog("Eingang ist voll");
                Frame.updateEingang(MeinLager);
                break;
            case "Verschrotten":
                System.out.println("Verschrotten");
                updateOperatorGeklicked(geklickterButton.getActionCommand());

                break;
            case "Auslagern":
                System.out.println("Auslagern");
                updateOperatorGeklicked(geklickterButton.getActionCommand());

                break;
            case "Einlagern":
                System.out.println("Einlagern");
                updateOperatorGeklicked(geklickterButton.getActionCommand());

                break;
            case "Saldo":
                System.out.println("Saldo");
                Saldo.openGui();
                break;
        }
        //Jetzt wird, entschieden welche Aktion ausgeführt wird...
        if(LagerPlatzGedrueckt(Frame, geklickterButton)){
            updateOperatorGeklicked("reset");
        }

    }



    public void updateOperatorGeklicked(String geklickterButton) {
        //Voreinstellung, die definiert, was passieren soll,
        // wenn ein Lagerplatz geklickt wird.
        if (geklickterButton == "Verschrotten") {
            this.verschrottenGeklickt = true;
            this.einlagernGeklickt = false;
            this.auslagernGeklickt = false;
            Frame.setOperatorFarbe(geklickterButton);
        } else if (geklickterButton == "Einlagern") {
            this.verschrottenGeklickt = false;
            this.einlagernGeklickt = true;
            this.auslagernGeklickt = false;
            Frame.setOperatorFarbe(geklickterButton);
        } else if (geklickterButton == "Auslagern") {
            this.verschrottenGeklickt = false;
            this.einlagernGeklickt = false;
            this.auslagernGeklickt = true;
            Frame.setOperatorFarbe(geklickterButton);
        }else if(geklickterButton == "reset"){
            this.verschrottenGeklickt = false;
            this.einlagernGeklickt = false;
            this.auslagernGeklickt = false;
            Frame.setOperatorFarbe(geklickterButton);
        }
    }

    public boolean LagerPlatzGedrueckt(mainFrame Frame, JButton geklickterButton) {
        int tempErtrag;
        if (Frame.getGuiLagerButtonTreemap().containsValue(geklickterButton)) {

            this.ausgewaehlterLagerplatz = geklickterButton.getActionCommand();
            //*****************Einlagern************************************
            if (einlagernGeklickt) {
                tempErtrag =MeinLager.Einlagern(ausgewaehlterAuftrag, ausgewaehlterLagerplatz, Frame);
                if(tempErtrag == -1) return true;
                einlagernGeklickt = false;
                Frame.updateEingang(MeinLager);
                Frame.updateRegal(MeinLager);
                ausgewaehlterAuftrag = null;
                Saldo.addTransaktion("Produkt eingelagert", tempErtrag);
                return true;
            }
            //*****************Auslagern************************************
            else if (auslagernGeklickt) {
                if(ausgewaehlterAuftrag == null){
                    Frame.openDialog("Auslagern ohne einen Auftrag ist nicht möglich!");
                    return true;
                }
                tempErtrag = MeinLager.Auslagern(ausgewaehlterLagerplatz,eingang,Frame);
                if(tempErtrag !=-1){
                    Saldo.addTransaktion("Produkt ausgelagert", tempErtrag);
                    auslagernGeklickt = false;
                    Frame.updateRegal(MeinLager);
                    Frame.updateEingang(MeinLager);
                    ausgewaehlterAuftrag = null;
                    Frame.openDialog("Produkt ausgelagert!");
                    return true;
                } else{
                    auslagernGeklickt = false;
                    Frame.updateEingang(MeinLager);

                    return true;
                }
            //*****************Verschrotten************************************
            } else if(verschrottenGeklickt){
                tempErtrag = MeinLager.verschrotten(geklickterButton.getActionCommand());
                System.out.println("HIEER"+tempErtrag);
                if(tempErtrag == -1){
                    verschrottenGeklickt = false;
                    return false;
                }
                verschrottenGeklickt = false;
                Frame.updateRegal(MeinLager);
                Frame.updateEingang(MeinLager);
                Saldo.addTransaktion("Produkt verschrottet", tempErtrag);
                return true;
            }else{
                Frame.updateEingang(MeinLager);
                updateOperatorGeklicked("reset");
                return true;
            }


        }
        return false;
    }




    public void setAktiverEingang(int eingang) {
        this.ausgewaehlterAuftrag = null;
        Frame.setAktiverAuftragFarbe(eingang);
        if (MeinLager.getAuftrag(eingang) != null) {
            this.ausgewaehlterAuftrag = MeinLager.getAuftrag(eingang);
            updateAusgewaehlterAuftragAttribute();
        } else return;
    }

}
