package main;

import java.awt.event.ActionEvent;

public class Logik {
    private ActionEvent e;
    private Auftrag AuftragObjekt;
    private Lagerist LageristObjekt;

    public Logik(Auftrag auftragObjekt, Lagerist lageristObjekt) {
        AuftragObjekt = auftragObjekt;
        LageristObjekt = lageristObjekt;
    }

    public void actionPerformed(ActionEvent e,mainFrame mainFrame){
        this.e = e;
        mainFrame.setAktiverAuftragFarbe(e);
        if (e.getActionCommand() == "R11"){
            //Lagerist.Einlagern();
            System.out.println("Einlagern----------");
            mainFrame.setButtonName(e,"YOOOOO");

        }
    }

}
