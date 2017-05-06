/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pietnurm.logiikka.Kysymysvarasto;

/**
 * Luokka kysymyseditorinakyman luomiseen.
 * @author pieta
 */
public class Kysymyseditori {
    Kayttoliittyma kayttoliittyma;
    private JPanel cards;
    private JPanel kysymyseditori;
    private final static String KYSYMYSEDITORI = "kysymyseditori";
    private Kysymysvarasto kysymysvarasto;
    
    public Kysymyseditori(Kayttoliittyma kayttoliittyma) throws IOException {
        this.kayttoliittyma = kayttoliittyma;
        this.kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        
    }
    
    public JPanel luo() {
        luoKomponentit();
        this.cards = new JPanel(new CardLayout());
        cards.add(kysymyseditori, KYSYMYSEDITORI);
        
        return cards;
    }    
    public void luoKomponentit() {    
        this.kysymyseditori = new JPanel(new GridLayout(5, 1));
        
        JLabel otsikko = new JLabel("Luo kysymyksiä", SwingConstants.CENTER);
        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
        kysymyseditori.setBackground(new Color(0xffffff));
        kysymyseditori.add(otsikko);
        
        JPanel kysymyspaneeli = new JPanel(new GridLayout (2, 1));
        kysymyspaneeli.setBackground(new Color(0xffffdd));
        
        JLabel syotaKysymys = new JLabel("Syötä uusi kysymys");
        syotaKysymys.setFont(new Font("Rockwell", Font.PLAIN, 18));
        syotaKysymys.setBackground(new Color(0xffffdd));
        kysymyspaneeli.add(syotaKysymys);
        
        JTextArea kysymys = new JTextArea();
        kysymys.setFont(new Font("Calibri", Font.PLAIN, 16));
        kysymys.setBackground(new Color(0xffffff));
        kysymyspaneeli.add(kysymys);
        
        kysymyseditori.add(kysymyspaneeli);
        
        JPanel mallivastauspaneeli = new JPanel(new GridLayout (2, 1));
        mallivastauspaneeli.setBackground(new Color(0xffffdd));
        
        JLabel syotaMallivastaus = new JLabel("Syötä mallivastaus");
        syotaMallivastaus.setFont(new Font("Rockwell", Font.PLAIN, 18));
        syotaMallivastaus.setBackground(new Color(0xffffdd));
        mallivastauspaneeli.add(syotaMallivastaus);
        
        JTextArea mallivastaus = new JTextArea();
        mallivastaus.setFont(new Font("Calibri", Font.PLAIN, 16));
        mallivastaus.setBackground(new Color(0xffffff));
        mallivastauspaneeli.add(mallivastaus);
        
        kysymyseditori.add(mallivastauspaneeli);
        
        // kategoriavalitsin 
        Kategoriavalitsin valitsin = new Kategoriavalitsin();
        kysymyseditori.add(valitsin.palautaValitsin());
        
        JPanel alapalkki = new JPanel();
        alapalkki.setBackground(new Color(0xffffff));
        
        JButton luo = new JButton("Tallenna kysymys");
        luo.setFont(new Font("Rockwell", Font.PLAIN, 20));
        luo.setBackground(new Color(0xffffdd));
        alapalkki.add(luo);
        
        
        JButton palaaValikkoon = new JButton("Takaisin valikkoon");
        palaaValikkoon.setFont(new Font("Rockwell", Font.PLAIN, 20));
        palaaValikkoon.setBackground(new Color(0xffffdd));
        alapalkki.add(palaaValikkoon);
        palaaValikkoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (kayttoliittyma.cards.getLayout());
                cl.show(kayttoliittyma.cards, kayttoliittyma.VALIKKOPANEL);
            }
        });
        kysymyseditori.add(alapalkki);
    }
//    public JPanel luo() {
//        JPanel valikko = new JPanel(new GridLayout(5, 1));
//        
//        JLabel otsikko = new JLabel("Luo kysymyksiä", SwingConstants.CENTER);
//        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
//        valikko.setBackground(new Color(0xffffff));
//        valikko.add(otsikko);
//        
//        JButton luo = new JButton("Luo kysymyksiä");
//        luo.setFont(new Font("Rockwell", Font.PLAIN, 20));
//        luo.setBackground(new Color(0xffffdd));
//        valikko.add(luo);
//        
//        JButton testaa = new JButton("Testaa itseäsi");
//        testaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
//        testaa.setBackground(new Color(0xffffff));
//        valikko.add(testaa);
//        
//        JButton tulokset = new JButton("Tulokset");
//        tulokset.setFont(new Font("Rockwell", Font.PLAIN, 20));
//        tulokset.setBackground(new Color(0xffffdd));
//        valikko.add(tulokset);
//        
//        return valikko;
//    }
}
