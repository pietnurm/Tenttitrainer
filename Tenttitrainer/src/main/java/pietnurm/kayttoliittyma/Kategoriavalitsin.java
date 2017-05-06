/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pietnurm.logiikka.Kategoria;
import pietnurm.logiikka.Kysymysvarasto;

/**
 *
 * @author pieta
 */
public class Kategoriavalitsin {
    private String[] description;
    private ArrayList<String> kategorianimet;
    private JTextField t = new JTextField(15);
    private JTextArea uusiKategoria = new JTextArea("");
    private JComboBox c = new JComboBox();
    private JButton b = new JButton("Lisää uusi kategoria");
    private int count = 0;
    private JPanel valitsinpaneeli;
    

    public void init() throws IOException {
        Kysymysvarasto kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        ArrayList<Kategoria> kategoriat = new ArrayList<>();
        kategoriat = kysymysvarasto.palautaKategoriat();
        this.description = new String[kategoriat.size()];
        for (int i = 0; i < kategoriat.size(); i++) {
            description[i] = kategoriat.get(i).palautaKategorianNimi();
        }
        b.setBackground(new Color(0xffffdd));
        c.setBackground(new Color(0xffffff));
        t.setBackground(new Color(0xffffff));
        uusiKategoria.setBackground(new Color(0xffffdd));
        
        
        
        for (int i = 0; i < 4; i++)
            
            c.addItem(description[count++]);
            t.setEditable(false);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Tänne lisää kategoria -toiminnallisuus!!
//                if (count < description.length)
//                    c.addItem(description[count++]);
                }
        });
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        this.valitsinpaneeli = new JPanel(new GridLayout(2, 2));
        valitsinpaneeli.add(t);
        valitsinpaneeli.add(c);
        valitsinpaneeli.add(uusiKategoria);
        valitsinpaneeli.add(b);
      
      
//      Container cp = getContentPane();
//      cp.setLayout(new FlowLayout());
//      cp.add(t);
//      cp.add(c);
//      cp.add(b);

    }
    public JPanel palautaValitsin() {
        return valitsinpaneeli;
    }
    public String palautaKategoria() {
        return t.getText();
    }

}
