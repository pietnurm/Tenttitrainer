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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String[] kategoriaArray;
    private JTextField valittuKategoria = new JTextField(15);
    private JTextArea uusiKategoria = new JTextArea("");
    private JComboBox valikko = new JComboBox();
    private JButton lisaaKategoria = new JButton("Lisää uusi kategoria");
    private int laskuri = 0;
    private JPanel valitsinpaneeli;
    

    public void init() throws IOException {
        Kysymysvarasto kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        ArrayList<Kategoria> kategoriat = new ArrayList<>();
        kategoriat = kysymysvarasto.palautaKategoriat();
        this.kategoriaArray = new String[kategoriat.size()];
        for (int i = 0; i < kategoriat.size(); i++) {
            kategoriaArray[i] = kategoriat.get(i).palautaKategorianNimi();
        }
        lisaaKategoria.setBackground(new Color(0xffffdd));
        valikko.setBackground(new Color(0xffffff));
        valittuKategoria.setBackground(new Color(0xffffff));
        uusiKategoria.setBackground(new Color(0xffffdd));
        
        
        
        for (int i = 0; i < kategoriat.size(); i++)
            
            valikko.addItem(kategoriaArray[laskuri++]);
            valittuKategoria.setEditable(false);
            lisaaKategoria.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Kategoria luotuKategoria = new Kategoria(uusiKategoria.getText());
                    } catch (IOException ex) {
                        Logger.getLogger(Kategoriavalitsin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    valikko.addItem(uusiKategoria.getText());
                    uusiKategoria.setText("");
                }
        });
        valikko.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valittuKategoria.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        this.valitsinpaneeli = new JPanel(new GridLayout(2, 2));
        valitsinpaneeli.add(valittuKategoria);
        valitsinpaneeli.add(valikko);
        valitsinpaneeli.add(uusiKategoria);
        valitsinpaneeli.add(lisaaKategoria);

    }
    public JPanel palautaValitsin() {
        return valitsinpaneeli;
    }
    public String palautaKategoria() {
        return valittuKategoria.getText();
    }

}
