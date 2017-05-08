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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import pietnurm.logiikka.Kysymys;
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
    /**
     * Palauttaa kysymyseditorin JPanelina.
     * @return
     * @throws IOException 
     */
    public JPanel luo() throws IOException {
        luoKomponentit();
        this.cards = new JPanel(new CardLayout());
        cards.add(kysymyseditori, KYSYMYSEDITORI);
        
        return cards;
    }
/**
 * Luo kysymyseditorin komponentit.
 * @throws IOException 
 */    
    public void luoKomponentit() throws IOException {    
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
        JPanel valitsinpaneeli = new JPanel();
        valitsinpaneeli.setBackground(new Color(0xffffff));
        
        JLabel valitseKategoria = new JLabel("Valitse kysymykselle kategoria", SwingConstants.CENTER);
        valitseKategoria.setFont(new Font("Rockwell", Font.PLAIN, 18));
        valitseKategoria.setBackground(new Color(0xffffdd));
        valitsinpaneeli.add(valitseKategoria);
        
        Kategoriavalitsin valitsin = new Kategoriavalitsin();
        valitsin.init();
        valitsinpaneeli.add(valitsin.palautaValitsin());
        
        kysymyseditori.add(valitsinpaneeli);
        
        JPanel alapalkki = new JPanel();
        alapalkki.setBackground(new Color(0xffffff));
        
        JButton tallennaKysymys = new JButton("Tallenna kysymys");
        tallennaKysymys.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tallennaKysymys.setBackground(new Color(0xffffdd));
        tallennaKysymys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kysymysText = kysymys.getText();
                String mallivastausText = mallivastaus.getText();
                String kategoriaText = valitsin.palautaKategoria();
                if (!(kysymysText.equals("") || mallivastausText.equals("") || kategoriaText.equals(""))) {
                    Kysymys kyssari = new Kysymys(kysymysText, mallivastausText);
                    try {
                        kyssari.tallennaKysymys(kategoriaText);
                    } catch (IOException ex) {
                        Logger.getLogger(Kysymyseditori.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    kysymys.setText("Kysymys tallennettu.");
                    mallivastaus.setText("");
                } else {
                    kysymys.setText("Syötä kysymys ja mallivastaus ja valitse kategoria ennen tallentamista");
                }
            }
        });
        alapalkki.add(tallennaKysymys);
        
        
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
}
