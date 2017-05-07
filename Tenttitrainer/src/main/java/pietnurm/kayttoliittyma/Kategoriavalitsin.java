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
    private String[] kategoriaArray2;
    private JTextField valittuKategoria = new JTextField(15);
    private JTextField valittuKategoria2 = new JTextField(15);
    private JTextArea uusiKategoria = new JTextArea("");
    private JComboBox valikko = new JComboBox();
    private JComboBox valikko2 = new JComboBox();
    private JButton lisaaKategoria = new JButton("Lisää uusi kategoria");
    private int laskuri = 0;
    private int laskuri2 = 0;
    private JPanel valitsinpaneeli;
    private JPanel pelkistettyValitsin;
    

    public void init() throws IOException {
        Kysymysvarasto kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        ArrayList<Kategoria> kategoriat = new ArrayList<>();
        kategoriat = kysymysvarasto.palautaKategoriat();
        this.kategoriaArray = new String[kategoriat.size()];
        this.kategoriaArray2 = new String[kategoriat.size()];
        for (int i = 0; i < kategoriat.size(); i++) {
            kategoriaArray[i] = kategoriat.get(i).palautaKategorianNimi();
            kategoriaArray2[i] = kategoriat.get(i).palautaKategorianNimi();
        }
        lisaaKategoria.setBackground(new Color(0xffffdd));
        valikko.setBackground(new Color(0xffffff));
        valittuKategoria.setBackground(new Color(0xffffff));
        valikko2.setBackground(new Color(0xffffff));
        valittuKategoria2.setBackground(new Color(0xffffff));
        uusiKategoria.setBackground(new Color(0xffffdd));
        
        
        
        for (int i = 0; i < kategoriat.size(); i++)
            
            valikko.addItem(kategoriaArray[laskuri++]);
            valikko2.addItem(kategoriaArray2[laskuri2++]);
            valittuKategoria.setEditable(false);
            valittuKategoria2.setEditable(false);
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
        valikko2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valittuKategoria2.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        this.valitsinpaneeli = new JPanel(new GridLayout(2, 2));
        valitsinpaneeli.add(valittuKategoria);
        valitsinpaneeli.add(valikko);
        valitsinpaneeli.add(uusiKategoria);
        valitsinpaneeli.add(lisaaKategoria);
        
//        this.valittuKategoria2 = valittuKategoria;
//        this.valikko2 = valikko;
        
        this.pelkistettyValitsin = new JPanel(new GridLayout(1, 1));
        pelkistettyValitsin.add(valittuKategoria2);
        pelkistettyValitsin.add(valikko2);

    }
    public void initPelkistetty() throws IOException {
        Kysymysvarasto kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        ArrayList<Kategoria> kategoriat = new ArrayList<>();
        kategoriat = kysymysvarasto.palautaKategoriat();
        this.kategoriaArray = new String[kategoriat.size()];
        this.kategoriaArray2 = new String[kategoriat.size()];
        for (int i = 0; i < kategoriat.size(); i++) {
            kategoriaArray[i] = kategoriat.get(i).palautaKategorianNimi();
            kategoriaArray2[i] = kategoriat.get(i).palautaKategorianNimi();
        }
        lisaaKategoria.setBackground(new Color(0xffffdd));
        valikko.setBackground(new Color(0xffffff));
        valittuKategoria.setBackground(new Color(0xffffff));
        valikko2.setBackground(new Color(0xffffff));
        valittuKategoria2.setBackground(new Color(0xffffff));
        uusiKategoria.setBackground(new Color(0xffffdd));
        
        
        
        for (int i = 0; i < kategoriat.size(); i++)
            
            valikko.addItem(kategoriaArray[laskuri++]);
            valikko2.addItem(kategoriaArray2[laskuri2++]);
            valittuKategoria.setEditable(false);
            valittuKategoria2.setEditable(false);
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
        valikko2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valittuKategoria2.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });

        this.valitsinpaneeli = new JPanel(new GridLayout(2, 2));
        valitsinpaneeli.add(valittuKategoria);
        valitsinpaneeli.add(valikko);
//        valitsinpaneeli.add(uusiKategoria);
//        valitsinpaneeli.add(lisaaKategoria);
        
//        this.valittuKategoria2 = valittuKategoria;
//        this.valikko2 = valikko;
        
        this.pelkistettyValitsin = new JPanel(new GridLayout(1, 1));
        pelkistettyValitsin.add(valittuKategoria2);
        pelkistettyValitsin.add(valikko2);

    }
    public JPanel palautaValitsin() {
        return valitsinpaneeli;
    }
    public JPanel palautaPelkistettyValitsin() {
        return pelkistettyValitsin;
    }
    public String palautaKategoria() {
        return valittuKategoria.getText();
    }

}
