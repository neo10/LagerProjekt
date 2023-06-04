package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {
    private Logik GameLogik;

    private int width;
    private int height;
    private String FrameName;
    Container mainContainer; // der Mainframe in den alle Elemente
    private JButton buttonR11 = new JButton("Regal 1.1");
    private JButton buttonR12 = new JButton("Regal 1.2");
    private JButton buttonR13 = new JButton("Regal 1.3");
    private JButton buttonR14 = new JButton("Regal 1.4");
    private JButton buttonR21 = new JButton("Regal 2.1");
    private JButton buttonR22 = new JButton("Regal 2.2");
    private JButton buttonR23 = new JButton("Regal 2.3");
    private JButton buttonR24 = new JButton("Regal 2.4");
    private JButton buttonR31 = new JButton("Regal 3.1");
    private JButton buttonR32 = new JButton("Regal 3.2");
    private JButton buttonR33 = new JButton("Regal 3.3");
    private JButton buttonR34 = new JButton("Regal 3.4");
    private JButton buttonR41 = new JButton("Regal 4.1");
    private JButton buttonR42 = new JButton("Regal 4.2");
    private JButton buttonR43 = new JButton("Regal 4.3");
    private JButton buttonR44 = new JButton("Regal 4.4");

    private JButton buttonNeuerAuftrag = new JButton("Neuer Auftrag");

    private JButton buttonNeuStarten = new JButton("Neu Starten");
    private JButton buttonBeenden = new JButton("Beenden");
    private JButton buttonE1 = new JButton("Eingang 1");
    private JButton buttonE2 = new JButton("Eingang 2");
    private JButton buttonE3 = new JButton("Eingang 3");
public mainFrame(String FrameName,int width, int height, Logik GameLogik){
    this.width = width;
    this.height = height;
    this.FrameName = FrameName;
    this.GameLogik = GameLogik;
    mainContainer = this.getContentPane();
    mainContainer.setLayout(new BorderLayout());
    mainContainer.setBackground(Color.YELLOW);
    this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
    setUpButtonListener();

    this.setSize(this.width, this.height);
    this.setTitle(this.FrameName);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




}
    public void setVisible(){

        this.setVisible(true);
    }
    public void setUpUntenLeiste(){
        JPanel UntenPanel = new JPanel(new BorderLayout());
        JPanel UntenRechtsPanel = new JPanel();
        JPanel EingangPanel = new JPanel();


        //button1.setMargin(new Insets(0, 30, 0, 30));
        EingangPanel.add(buttonE1);
        EingangPanel.add(buttonE2);
        EingangPanel.add(buttonE3);
        EingangPanel.setBorder(new EmptyBorder(90, 10, 10, 10));
        UntenRechtsPanel.add(buttonNeuStarten);
        UntenRechtsPanel.add(buttonBeenden);
        UntenRechtsPanel.setBorder(new EmptyBorder(90, 10, 10, 10));

        UntenPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        UntenPanel.setBackground(Color.MAGENTA);
        UntenPanel.add(UntenRechtsPanel, BorderLayout.EAST); // Unten Rechts
        UntenPanel.add(EingangPanel, BorderLayout.CENTER); // Eingang

        mainContainer.add(UntenPanel, BorderLayout.SOUTH);


    }
    public void setUpRegal(){
        JPanel RegalPanel = new JPanel();
        RegalPanel.setLayout(new GridLayout(4,4));
        RegalPanel.setBorder(new LineBorder(Color.BLACK, 4));
        RegalPanel.add(buttonR11);
        RegalPanel.add(buttonR21);
        RegalPanel.add(buttonR31);
        RegalPanel.add(buttonR41);
        RegalPanel.add(buttonR12);
        RegalPanel.add(buttonR22);
        RegalPanel.add(buttonR32);
        RegalPanel.add(buttonR42);
        RegalPanel.add(buttonR13);
        RegalPanel.add(buttonR23);
        RegalPanel.add(buttonR33);
        RegalPanel.add(buttonR43);
        RegalPanel.add(buttonR14);
        RegalPanel.add(buttonR24);
        RegalPanel.add(buttonR34);
        RegalPanel.add(buttonR44);
        RegalPanel.setBackground(Color.MAGENTA);

        mainContainer.add(RegalPanel, BorderLayout.CENTER);
    }
    public void setUpInfoLeiste(){
        JLabel labelSaldo = new JLabel("Saldo: ");
        JPanel InfoPanel = new JPanel();
        InfoPanel.setBorder(new LineBorder(Color.BLACK, 4));
        InfoPanel.setLayout(new GridLayout(1,2));
        InfoPanel.setBackground(Color.MAGENTA);
        InfoPanel.add(labelSaldo);
        InfoPanel.setBorder(new EmptyBorder(10, 10, 30, 10));
        mainContainer.add(InfoPanel, BorderLayout.NORTH);
    }
    public void setUpRechteLeiste(){



    JPanel RechteLeistePanel = new JPanel();
    RechteLeistePanel.setLayout(new FlowLayout());
    RechteLeistePanel.setBorder(new LineBorder(Color.BLACK, 4));
    RechteLeistePanel.setBackground(Color.ORANGE);
    RechteLeistePanel.add(buttonNeuerAuftrag);
    mainContainer.add(RechteLeistePanel, BorderLayout.EAST);
    }

public void setUpButtonListener(){
    buttonR11.addActionListener(this);
    buttonR12.addActionListener(this);
    buttonR13.addActionListener(this);
    buttonR14.addActionListener(this);
    buttonR21.addActionListener(this);
    buttonR22.addActionListener(this);
    buttonR23.addActionListener(this);
    buttonR24.addActionListener(this);
    buttonR31.addActionListener(this);
    buttonR32.addActionListener(this);
    buttonR33.addActionListener(this);
    buttonR34.addActionListener(this);
    buttonR41.addActionListener(this);
    buttonR42.addActionListener(this);
    buttonR43.addActionListener(this);
    buttonR44.addActionListener(this);
    buttonNeuStarten.addActionListener(this);
    buttonBeenden.addActionListener(this);
    buttonE1.addActionListener(this);
    buttonE2.addActionListener(this);
    buttonE3.addActionListener(this);
    buttonNeuerAuftrag.addActionListener(this);
    buttonR11.setActionCommand("R11");
    buttonR12.setActionCommand("R12");
    buttonR13.setActionCommand("R13");
    buttonR14.setActionCommand("R14");
    buttonR21.setActionCommand("R21");
    buttonR22.setActionCommand("R22");
    buttonR23.setActionCommand("R23");
    buttonR24.setActionCommand("R24");
    buttonR31.setActionCommand("R31");
    buttonR32.setActionCommand("R32");
    buttonR33.setActionCommand("R33");
    buttonR34.setActionCommand("R34");
    buttonR41.setActionCommand("R41");
    buttonR42.setActionCommand("R42");
    buttonR43.setActionCommand("R43");
    buttonR44.setActionCommand("R44");
    buttonNeuStarten.setActionCommand("NeuStarten");
    buttonBeenden.setActionCommand("Beenden");
    buttonE1.setActionCommand("E1");
    buttonE2.setActionCommand("E2");
    buttonE3.setActionCommand("E3");
    buttonNeuerAuftrag.setActionCommand("NeuerAuftrag");
}
public void setButtonName(ActionEvent e, String name){
    JButton geklickterButton = (JButton) e.getSource();
    geklickterButton.setText(name);
}

public void setAktiverAuftragFarbe(ActionEvent e){
    // Ausgewählter Auftrag wird gelb markiert
    switch (e.getActionCommand()){
        case "E1":
            buttonE1.setBackground(Color.YELLOW);
            buttonE2.setBackground(Color.WHITE);
            buttonE3.setBackground(Color.WHITE);
            break;
        case "E2":
            buttonE1.setBackground(Color.WHITE);
            buttonE2.setBackground(Color.YELLOW);
            buttonE3.setBackground(Color.WHITE);
            break;
        case "E3":
            buttonE1.setBackground(Color.WHITE);
            buttonE2.setBackground(Color.WHITE);
            buttonE3.setBackground(Color.YELLOW);
            break;
    }
}





// Die Logik was passiert, wenn Buttons gedrückt werden
    @Override
    public void actionPerformed(ActionEvent e) {

        GameLogik.actionPerformed(e,this);

    };

}
