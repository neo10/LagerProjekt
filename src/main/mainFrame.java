package main;

import com.sun.source.tree.Tree;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeMap;

public class mainFrame extends JFrame implements ActionListener {
    private Logik GameLogik;
    private int width;
    private int height;
    private String FrameName;
    private TreeMap<String, JButton> GuiLagerButtonTreemap = new TreeMap<String, JButton>();
    Container mainContainer; // der Mainframe in den alle Elemente

    private JButton buttonNeuerAuftrag = new JButton("Neuer Auftrag");

    private JButton buttonAuftragAblehnen = new JButton("Auftrag ablehnen");

    private JButton buttonE1 = new JButton("Eingang 1");
    private JButton buttonE2 = new JButton("Eingang 2");
    private JButton buttonE3 = new JButton("Eingang 3");

    private JButton buttonSaldo = new JButton("Transaktionen anzeigen");
    private JButton buttonVerschrotten = new JButton("Verschrotten");
    private JButton buttonEinlagern = new JButton("Einlagern");
    private JButton buttonAuslagern = new JButton("Auslagern");
    private JLabel Eingang1Text = new JLabel("", SwingConstants.LEFT);
    private JLabel Eingang2Text = new JLabel("", SwingConstants.LEFT);
    private JLabel Eingang3Text = new JLabel("", SwingConstants.LEFT);
    private int Saldo = 0;
    private JLabel SaldoLabel = new JLabel();
public mainFrame(String FrameName,int width, int height){
    this.width = width;
    this.height = height;
    this.FrameName = FrameName;
    mainContainer = this.getContentPane();
    mainContainer.setLayout(new BorderLayout());
    mainContainer.setBackground(Color.YELLOW);
    this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.YELLOW));

    this.setSize(this.width, this.height);
    this.setTitle(this.FrameName);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Saldo = 0;
    setSaldo(0);

}
    public void setVisible(){

        this.setVisible(true);
    }
    public void initSuedPanel(){
        buttonAuftragAblehnen.addActionListener(this);
        buttonE1.addActionListener(this);
        buttonE2.addActionListener(this);
        buttonE3.addActionListener(this);
        buttonVerschrotten.addActionListener(this);
        buttonAuslagern.addActionListener(this);
        buttonEinlagern.addActionListener(this);
        buttonAuftragAblehnen.setActionCommand("Ablehnen");
        buttonE1.setActionCommand("E1");
        buttonE2.setActionCommand("E2");
        buttonE3.setActionCommand("E3");
        buttonVerschrotten.setActionCommand("Verschrotten");
        buttonAuslagern.setActionCommand("Auslagern");
        buttonEinlagern.setActionCommand("Einlagern");

        JPanel UntenPanel = new JPanel(new BorderLayout());
        JPanel UntenRechtsPanel = new JPanel();
        JPanel MitteUntenPanel = new JPanel();
        JPanel UntenLinksPanel = new JPanel();
        JPanel MitteObenPanel = new JPanel();

        Eingang1Text.setPreferredSize(new Dimension(130, 150));
        Eingang2Text.setPreferredSize(new Dimension(130, 150));
        Eingang3Text.setPreferredSize(new Dimension(130, 150));
        Eingang1Text.setOpaque(true);
        Eingang2Text.setOpaque(true);
        Eingang3Text.setOpaque(true);
        Eingang1Text.setBackground(Color.WHITE);
        Eingang2Text.setBackground(Color.WHITE);
        Eingang3Text.setBackground(Color.WHITE);
        Eingang1Text.setBorder(new LineBorder(Color.WHITE));
        Eingang2Text.setBorder(new LineBorder(Color.WHITE));
        Eingang3Text.setBorder(new LineBorder(Color.WHITE));

        MitteObenPanel.add(this.Eingang1Text);
        MitteObenPanel.add(this.Eingang2Text);
        MitteObenPanel.add(this.Eingang3Text);


        //EingangsButtons
        MitteUntenPanel.add(buttonE1);
        MitteUntenPanel.add(buttonE2);
        MitteUntenPanel.add(buttonE3);
        UntenRechtsPanel.add(buttonAuftragAblehnen);


        MitteUntenPanel.setBorder(new EmptyBorder(50, 10, 10, 10));
        UntenRechtsPanel.setBorder(new EmptyBorder(50, 10, 10, 10));

        UntenLinksPanel.setLayout(new BoxLayout(UntenLinksPanel, BoxLayout.Y_AXIS));
        UntenLinksPanel.setBorder(new EmptyBorder(50, 10, 10, 10));
        UntenLinksPanel.add(buttonEinlagern);
        UntenLinksPanel.add(buttonAuslagern);
        UntenLinksPanel.add(buttonVerschrotten);

        UntenPanel.setLayout(new BorderLayout());
        UntenPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        UntenPanel.setBackground(Color.MAGENTA);
        UntenPanel.add(UntenRechtsPanel, BorderLayout.EAST); // Unten Rechts
        UntenPanel.add(MitteObenPanel, BorderLayout.NORTH); // Mitte Oben
        UntenPanel.add(MitteUntenPanel, BorderLayout.CENTER); // Eingang
        UntenPanel.add(UntenLinksPanel, BorderLayout.WEST); // Unten Links

        mainContainer.add(UntenPanel, BorderLayout.SOUTH);


    }
    public void initMittePanel(){
        int j=0;
        for (int i = 1; i <=4; i++) {
            for(int k = 1; k <=4; k++){
                JButton tempButton = new JButton("Viel Spaß!");
                tempButton.addActionListener(this);
                tempButton.setActionCommand("Lager "+i+ "."+ k);
                GuiLagerButtonTreemap.put("Lager "+i+ "."+ k, tempButton);
                j++;
            }
        }

        JPanel RegalPanel = new JPanel();
        RegalPanel.setLayout(new GridLayout(4,4));
        RegalPanel.setBorder(new LineBorder(Color.BLACK, 4));
        Set<String> keys = GuiLagerButtonTreemap.keySet();
        //Alle Buttons der Treemap in das Panel hinzufügen
        for (String key : keys) {
            RegalPanel.add(GuiLagerButtonTreemap.get(key));
    }

        RegalPanel.setBackground(Color.MAGENTA);

        mainContainer.add(RegalPanel, BorderLayout.CENTER);
    }
    public void initNordPanel(){
        buttonSaldo.setActionCommand("Saldo");
        buttonSaldo.addActionListener(this);

        JPanel InfoWestPanel = new JPanel();
        JPanel InfoMittePanel = new JPanel();
        JPanel InfoPanel = new JPanel();
        InfoPanel.setBorder(new LineBorder(Color.BLACK, 4));
        InfoPanel.setLayout(new BorderLayout());
        InfoPanel.setBackground(Color.BLUE);
        InfoWestPanel.add(SaldoLabel);
        InfoMittePanel.add(buttonSaldo);
        InfoPanel.add(InfoWestPanel, BorderLayout.WEST);
        InfoPanel.add(InfoMittePanel, BorderLayout.CENTER);
        InfoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainContainer.add(InfoPanel, BorderLayout.NORTH);
    }
    public void initOstPanel(){
        buttonNeuerAuftrag.addActionListener(this);
        buttonNeuerAuftrag.setActionCommand("NeuerAuftrag");


    JPanel RechteLeistePanel = new JPanel();
    RechteLeistePanel.setLayout(new FlowLayout());
    RechteLeistePanel.setBorder(new LineBorder(Color.BLACK, 4));
    RechteLeistePanel.setBackground(Color.ORANGE);
    RechteLeistePanel.add(buttonNeuerAuftrag);
    mainContainer.add(RechteLeistePanel, BorderLayout.EAST);
    }

public void Einlagern(Auftrag Auftrag,String ausgewaehlterLagerplatz){
    GuiLagerButtonTreemap.get(ausgewaehlterLagerplatz).setText(Auftrag.getProdukt().getName());
}
public void setSaldo(int neuUmsatz){
    Saldo+=neuUmsatz;
    SaldoLabel.setText("Saldo: " + Saldo + " €");
}
public void openDialog(String text){
    JOptionPane.showMessageDialog(this, text);
}


public void setAktiverAuftragFarbe(int e){
    // Ausgewählter Auftrag wird gelb markiert

    switch (e){
        case 1:
            buttonE1.setBackground(Color.GREEN);
            buttonE2.setBackground(Color.WHITE);
            buttonE3.setBackground(Color.WHITE);
            Eingang1Text.setBorder(new LineBorder(Color.BLACK));
            Eingang2Text.setBorder(new LineBorder(Color.WHITE));
            Eingang3Text.setBorder(new LineBorder(Color.WHITE));
            break;
        case 2:
            buttonE1.setBackground(Color.WHITE);
            buttonE2.setBackground(Color.GREEN);
            buttonE3.setBackground(Color.WHITE);
            Eingang1Text.setBorder(new LineBorder(Color.WHITE));
            Eingang2Text.setBorder(new LineBorder(Color.BLACK));
            Eingang3Text.setBorder(new LineBorder(Color.WHITE));

            break;
        case 3:
            buttonE1.setBackground(Color.WHITE);
            buttonE2.setBackground(Color.WHITE);
            buttonE3.setBackground(Color.GREEN);
            Eingang1Text.setBorder(new LineBorder(Color.WHITE));
            Eingang2Text.setBorder(new LineBorder(Color.WHITE));
            Eingang3Text.setBorder(new LineBorder(Color.BLACK));

            break;
    }
}
public void setOperatorFarbe(String operator){
    // Ausgewählter Operator wird grün markiert
    switch (operator){
        case "Einlagern":
            buttonEinlagern.setBackground(Color.GREEN);
            buttonAuslagern.setBackground(Color.WHITE);
            buttonVerschrotten.setBackground(Color.WHITE);
            break;
        case "Auslagern":
            buttonEinlagern.setBackground(Color.WHITE);
            buttonAuslagern.setBackground(Color.GREEN);
            buttonVerschrotten.setBackground(Color.WHITE);
            break;
        case "Verschrotten":
            buttonEinlagern.setBackground(Color.WHITE);
            buttonAuslagern.setBackground(Color.WHITE);
            buttonVerschrotten.setBackground(Color.GREEN);
            break;
        case "reset":
            buttonEinlagern.setBackground(Color.WHITE);
            buttonAuslagern.setBackground(Color.WHITE);
            buttonVerschrotten.setBackground(Color.WHITE);
            break;
    }
}
    public void setEingangText(Auftrag Auftrag, int Eingang){
        if(Auftrag == null){
            switch (Eingang){
                case 1:
                    setEingang1TextLeer();
                    break;
                case 2:
                    setEingang2TextLeer();
                    break;
                case 3:
                    setEingang3TextLeer();
                    break;
            }
            return;
        }
        // macht hier nur weiter, wenn Auftrag nicht null ist
        String Art = Auftrag.getAuftragsArt();
        String Produkt = Auftrag.getProdukt().getName();
        String Eigenschaft1 = Auftrag.getProdukt().getEigenschaft1();
        String Eigenschaft2 = Auftrag.getProdukt().getEigenschaft2();
        String Belohnung = Integer.toString(Auftrag.getBelohnung());
        JLabel EingangAktiv;
        if(Eingang==1) EingangAktiv = Eingang1Text;
        else if(Eingang==2) EingangAktiv = Eingang2Text;
        else if (Eingang==3) EingangAktiv = Eingang3Text;
        else EingangAktiv = null;

            EingangAktiv.setText(
                "<html><h3>Auftrag "+Eingang+"</h3><br>"
                        +"Art: "+Art+"<br>"
                        +"Produkt: "+Produkt+"<br>"
                        +"Eigenschaft1: "+Eigenschaft1+"<br>"
                        +"Eigenschaft2: "+Eigenschaft2+"<br>"
                        +"Belohnung: "+Belohnung+"<br>"
                        +"</html>");
    }
    public void setEingang1TextLeer(){
        Eingang1Text.setText("");
    }
    public void setEingang2TextLeer(){
        Eingang2Text.setText("");
    }
    public void setEingang3TextLeer(){
        Eingang3Text.setText("");
    }
    public void updateEingang(Lager Meinlager){
         Auftrag Auftrag1 = Meinlager.getAuftrag(1);
         Auftrag Auftrag2 = Meinlager.getAuftrag(2);
         Auftrag Auftrag3 = Meinlager.getAuftrag(3);
         setEingangText(Auftrag1,1);
       setEingangText(Auftrag2,2);
       setEingangText(Auftrag3,3);

       // Alle Buttons wieder grau machen
        buttonE1.setBackground(Color.WHITE);
        buttonE2.setBackground(Color.WHITE);
        buttonE3.setBackground(Color.WHITE);
        Eingang1Text.setBorder(new LineBorder(Color.WHITE));
        Eingang2Text.setBorder(new LineBorder(Color.WHITE));
        Eingang3Text.setBorder(new LineBorder(Color.WHITE));
    }
    public void updateRegal(Lager MeinLager){
        TreeMap <String, Auftrag> RegalBestand = MeinLager.getHochRegalBestand();
        Set<String> keys = GuiLagerButtonTreemap.keySet();
        //Alle Buttons der Treemap in das Panel hinzufügen
        for (String key : keys) {
            if(RegalBestand.get(key)==null) GuiLagerButtonTreemap.get(key).setText("");
            else GuiLagerButtonTreemap.get(key).setText(RegalBestand.get(key).getProdukt().getName());
        }
    }
public TreeMap<String, JButton> getGuiLagerButtonTreemap() {
    return GuiLagerButtonTreemap;
}
public void setGameLogik(Logik gameLogik) {
    this.GameLogik = gameLogik;
}

// Die Logik was passiert, wenn Buttons gedrückt werden
    @Override
    public void actionPerformed(ActionEvent e) {

        GameLogik.actionPerformed(e,this);

    };

}
