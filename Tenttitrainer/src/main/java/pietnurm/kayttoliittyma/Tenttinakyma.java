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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import pietnurm.logiikka.Kysymysvarasto;
import pietnurm.logiikka.Testi;

/**
 * Luokka tenttinakyman luomiseen ja paivittamiseen.
 * @author pieta
 */
public class Tenttinakyma {
    private Kysymysvarasto kysymysvarasto;
    private Testi testaaKaikki;
    private JPanel cards;
    private JPanel tentti;
    private JPanel tenttivalikko;
    private JPanel mallivastaus;
    private JPanel lopetusruutu;
    private final static String TENTTIVALIKKO = "tenttivalikko";
    private final static String TENTTI = "tentti";
    private final static String MALLIVASTAUS = "mallivastaus";
    private final static String LOPETUSRUUTU = "lopetusruutu";
    
    public Tenttinakyma() throws IOException {
        this.kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        testaaKaikki = new Testi(kysymysvarasto);
        testaaKaikki.luoKysymyslista();
//        this.testi = new Testi(kysymysvarasto);
    }
    
    public JPanel luo() throws IOException {
//        testaaKaikki = new Testi(kysymysvarasto);
//        testaaKaikki.luoKysymyslista();
        luoKomponentit();
        
        this.cards = new JPanel(new CardLayout());
        cards.add(tenttivalikko, TENTTIVALIKKO);
        cards.add(tentti, TENTTI);
        cards.add(mallivastaus, MALLIVASTAUS);
        cards.add(lopetusruutu, LOPETUSRUUTU);
        
        return cards;
    }
    public void luoKomponentit() {
        this.tenttivalikko = new JPanel(new GridLayout(5, 1));
        
        JLabel otsikko = new JLabel("Testaa tietosi", SwingConstants.CENTER);
        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
        tenttivalikko.setBackground(new Color(0xffffff));
        tenttivalikko.add(otsikko);
        
        JButton tentiKaikki = new JButton("Tenttaa kaikkia kysymyksiä");
        tentiKaikki.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tentiKaikki.setBackground(new Color(0xffffdd));
        tenttivalikko.add(tentiKaikki);
        tentiKaikki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TENTTI);
            }
        });
        
        JButton testaa = new JButton("");
        testaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
        testaa.setBackground(new Color(0xffffff));
        tenttivalikko.add(testaa);
        
        JButton tulokset = new JButton("");
        tulokset.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tulokset.setBackground(new Color(0xffffdd));
        tenttivalikko.add(tulokset);
        
// TENTTI        
        
        this.tentti = new JPanel(new GridLayout(4, 1));
        tentti.setBackground(new Color(0xffffff));
        JLabel otsikkoTentti = new JLabel("Tentti", SwingConstants.CENTER);
        otsikkoTentti.setFont(new Font("Rockwell", Font.PLAIN, 36));
        tentti.add(otsikkoTentti);
        
        JLabel kysymys = new JLabel("", SwingConstants.CENTER);
        kysymys.setText(testaaKaikki.esitaKysymys());
        kysymys.setBackground(new Color(0xffffdd));
        kysymys.setFont(new Font("Calibri", Font.PLAIN, 16));
        tentti.add(kysymys);
        
        // luodaan mallivastaus-cardia varten
        JLabel kysymysUudestaan = new JLabel(testaaKaikki.esitaKysymys(), SwingConstants.CENTER);
        kysymys.setBackground(new Color(0xffffdd));
        kysymys.setFont(new Font("Calibri", Font.PLAIN, 16));
        
        JTextArea vastaus = new JTextArea("VASTAUKSESI: ");
        vastaus.setFont(new Font("Calibri", Font.PLAIN, 16));
        vastaus.setBackground(new Color(0xffffff));
        tentti.add(vastaus);
        
        // luodaan jlabel mallivastaus-cardia varten
        JLabel vastauksesi = new JLabel();
        vastauksesi.setFont(new Font("Calibri", Font.PLAIN, 16));
        
        JLabel mallivast = new JLabel();
        mallivast.setFont(new Font("Calibri", Font.PLAIN, 16));
        
        JButton tarkistaVastaus = new JButton("Tarkista vastaus");
        tarkistaVastaus.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tarkistaVastaus.setBackground(new Color(0xffffdd));
        tarkistaVastaus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vastauksesi.setText(vastaus.getText());
                kysymysUudestaan.setText(testaaKaikki.esitaKysymys());
                mallivast.setText("<html>MALLIVASTAUS:<br>" + testaaKaikki.esitaMallivastaus() + "</html>");
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, MALLIVASTAUS);
            }
        });
        tentti.add(tarkistaVastaus);
        
        // MALLIVASTAUS/ARVIOINTI
        
        this.mallivastaus = new JPanel(new GridLayout(4, 1));
        mallivastaus.setBackground(new Color(0xffffff));
        mallivast.setBackground(new Color(0xffffdd));
        mallivastaus.add(kysymysUudestaan);
        mallivastaus.add(mallivast);
        mallivastaus.add(vastauksesi);
        
        JButton seuraava = new JButton("Seuraava kysymys");
        seuraava.setFont(new Font("Rockwell", Font.PLAIN, 20));
        seuraava.setBackground(new Color(0xffffdd));
        seuraava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                if (testaaKaikki.esitaKysymys().equals("Testi on päättynyt.")) {
                    cl.show(cards, LOPETUSRUUTU);
                } else {
                    kysymys.setText(testaaKaikki.esitaKysymys());
                    vastaus.setText("VASTAUKSESI: ");
                    cl.show(cards, TENTTI);
                }
            }
        });
        mallivastaus.add(seuraava);  
        
        // lopetusruutu
        this.lopetusruutu = new JPanel(new GridLayout(4, 1));
        lopetusruutu.setBackground(new Color(0xffffff));
        JLabel loppuviesti = new JLabel("Tentti on päättynyt.", SwingConstants.CENTER);
        loppuviesti.setFont(new Font("Rockwell", Font.PLAIN, 36));
        lopetusruutu.add(loppuviesti);
        
        JLabel keskiarvo = new JLabel("Vastausten keskiarvo: ", SwingConstants.CENTER);
        keskiarvo.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lopetusruutu.add(keskiarvo);
        
        lopetusruutu.add(new JLabel()); // väliin tyhjä
        
        JButton lopeta = new JButton("Lopeta");
        lopeta.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lopeta.setBackground(new Color(0xffffdd));
        lopetusruutu.add(lopeta);
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TENTTIVALIKKO);
            }
        });
        
    }
    
}
