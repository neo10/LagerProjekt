package main;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.ArrayList;
import java.util.List;

public class Saldo {
    private int saldo;


    public int getSaldo(){
        return saldo;
    }
    public void openGui(){
        // Die Daten für das Table
        List<String> myList = new ArrayList<String>();
        myList.add("Auslagerung");
        myList.add("200");
        myList.add("Verschrottung");
        myList.add("-300");


        // Die Column-Titles
        final String[] jtableTitle = new String[]{
                "Art der Transaktion", "Betrag in Euro"
        };
        String[][] jtableData = new String [myList.size()/2][2] ;

        for(int i = 0; i < myList.size()/2; i++){

            for (int k = 0; k < 2; k++) {
                jtableData[i][k] = myList.get(i*2+k);
            }
        }





       /*
       String[][] data = new String[][]{
                {"a", "b", "c", "d"},
                {"e", "f", "g", "h"},
                {"i", "j", "k", "l"}
        };
        */

        // Die Column-Titles


        // Das JTable initialisieren
        JTable table = new JTable( jtableData, jtableTitle );

        JFrame frame = new JFrame( "Demo" );
        frame.getContentPane().add( new JScrollPane( table ) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }



}
