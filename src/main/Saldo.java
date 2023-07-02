package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Saldo extends JFrame {
    private int saldo;
    private Container mainContainer;
    private List<String> myList;
    private final String[] jtableTitle = new String[]{
            "TransaktionsNr.","Art der Transaktion", "Ertrag in Euro"
    };
    private JLabel labelSaldo;

    public Saldo(){
        saldo = 0;
        myList = new ArrayList<>();
        labelSaldo = new JLabel();
    }

    public int getSaldo(){
        return saldo;
    }


    public void openGui(){
        String[][] jtableData = new String [myList.size()/2][3] ;
        int trNr = 1;

        // Die Daten werden von myList ausgelesen, und in das JTable geschrieben
        for(int i = 0; i < myList.size()/2; i++){
            for (int k = 1; k < 3; k++) {
                jtableData[i][k] = myList.get(i*2+(k-1));
            }
            jtableData[i][0] = Integer.toString(trNr);
            trNr++;
        }
        labelSaldo.setText("Saldo: "+saldo+"€");

        // Das JTable initialisieren
        JTable table = new JTable( jtableData, jtableTitle );
        JFrame frame = new JFrame( "Transaktionen" );
        mainContainer= frame.getContentPane();
        mainContainer.setLayout(new BorderLayout());
        mainContainer.setBackground(Color.RED);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
        mainContainer.add( new JScrollPane( table ) );
        labelSaldo = new JLabel("Saldo: "+saldo+"€");
        mainContainer.add(labelSaldo, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }
    public void addTransaktion(String Art, int Betrag){
        myList.add(Art);
        myList.add(Integer.toString(Betrag));
        saldo += Betrag;
    }



}
