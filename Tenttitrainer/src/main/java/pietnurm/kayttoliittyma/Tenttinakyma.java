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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import pietnurm.logiikka.Kategoria;
import pietnurm.logiikka.Kysymysvarasto;
import pietnurm.logiikka.Testi;
//import sun.security.tools.keytool.Main;

/**
 * Luokka tenttinakyman luomiseen ja paivittamiseen.
 * @author pieta
 */
public class Tenttinakyma {
//    private JPanel kayttoliittymaLayout;
    private Kayttoliittyma kayttoliittyma;
    private Kysymysvarasto kysymysvarasto;
    private Testi tenttaa;
    private JPanel cards;
    private JPanel tentti;
    private JPanel tenttivalikko;
    private JPanel mallivastaus;
    private JPanel lopetusruutu;
    private final static String TENTTIVALIKKO = "tenttivalikko";
    private final static String TENTTI = "tentti";
    private final static String MALLIVASTAUS = "mallivastaus";
    private final static String LOPETUSRUUTU = "lopetusruutu";
    
    public Tenttinakyma(Kayttoliittyma kayttoliittyma) throws IOException {
        this.kayttoliittyma = kayttoliittyma;
        this.kysymysvarasto = new Kysymysvarasto();
        kysymysvarasto.haeTallennetutKategoriat();
        tenttaa = new Testi(kysymysvarasto);
        tenttaa.luoKysymyslista();

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
    public void luoKomponentit() throws IOException {
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
                tenttaa = new Testi(kysymysvarasto);
                tenttaa.luoKysymyslista();
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TENTTI);
            }
        });
        
        JPanel keskipaneeli = new JPanel(new GridLayout(2, 1));
        keskipaneeli.setBackground(new Color(0xffffff));
        
        Kategoriavalitsin kategoriavalitsin = new Kategoriavalitsin();
        kategoriavalitsin.initPelkistetty();
        JPanel valitsin = kategoriavalitsin.palautaValitsin();
        
        JButton tentiKategoria = new JButton("Tenttaa valitsemastasi kategoriasta");
        tentiKategoria.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tentiKategoria.setBackground(new Color(0xffffff));
        tentiKategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kategorianNimi = kategoriavalitsin.palautaKategoria();
                Kategoria valittuKategoria;
                try {
                    valittuKategoria = new Kategoria(kategorianNimi);
                    valittuKategoria.haeTallennetutKysymykset();
                    tenttaa = new Testi(kysymysvarasto, valittuKategoria);
                    tenttaa.luoKysymyslista();
                    CardLayout cl = (CardLayout) (cards.getLayout());
                    cl.show(cards, TENTTI);
                } catch (IOException ex) {
                    Logger.getLogger(Tenttinakyma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        keskipaneeli.add(tentiKategoria);
        keskipaneeli.add(valitsin);   
        tenttivalikko.add(keskipaneeli);
        
        JButton palaaValikkoon = new JButton("Takaisin valikkoon");
        palaaValikkoon.setFont(new Font("Rockwell", Font.PLAIN, 20));
        palaaValikkoon.setBackground(new Color(0xffffdd));
        tenttivalikko.add(palaaValikkoon);
        palaaValikkoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (kayttoliittyma.cards.getLayout());
                cl.show(kayttoliittyma.cards, kayttoliittyma.VALIKKOPANEL);
            }
        });
        
// TENTTI        
        
        this.tentti = new JPanel(new GridLayout(4, 1));
        tentti.setBackground(new Color(0xffffff));
        JLabel otsikkoTentti = new JLabel("Tentti", SwingConstants.CENTER);
        otsikkoTentti.setFont(new Font("Rockwell", Font.PLAIN, 36));
        tentti.add(otsikkoTentti);
        
        JLabel kysymys = new JLabel("", SwingConstants.CENTER);
        kysymys.setText(tenttaa.esitaKysymys());
        kysymys.setBackground(new Color(0xffffdd));
        kysymys.setFont(new Font("Calibri", Font.PLAIN, 16));
        tentti.add(kysymys);
        
        // luodaan mallivastaus-cardia varten
        JLabel kysymysUudestaan = new JLabel(tenttaa.esitaKysymys(), SwingConstants.CENTER);
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
        
        JPanel nappipaneeli = new JPanel();
        nappipaneeli.setBackground(new Color(0xffffff));
        tentti.add(nappipaneeli);
        
        JButton tarkistaVastaus = new JButton("Tarkista vastaus");
        tarkistaVastaus.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tarkistaVastaus.setBackground(new Color(0xffffdd));
        tarkistaVastaus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                vastauksesi.setText(vastaus.getText());
                kysymysUudestaan.setText(tenttaa.esitaKysymys());
                mallivast.setText("<html>MALLIVASTAUS:<br>" + tenttaa.esitaMallivastaus() + "</html>");
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, MALLIVASTAUS);
            }
        });
        nappipaneeli.add(tarkistaVastaus);
        
        // luodaan keskiarvo-label lopetusruutua varten
        JLabel keskiarvo = new JLabel("", SwingConstants.CENTER);
        keskiarvo.setFont(new Font("Rockwell", Font.PLAIN, 46));
        
        
        JButton lopetaTentti = new JButton("Lopeta tentti");
        lopetaTentti.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lopetaTentti.setBackground(new Color(0xffffdd));
        tentti.add(lopetaTentti);
        lopetaTentti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                keskiarvo.setText(new String(String.format("%.1f", tenttaa.testinKeskiarvo())));
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, LOPETUSRUUTU);
            }
        });
        nappipaneeli.add(lopetaTentti);
        
        // MALLIVASTAUS/ARVIOINTI
        
        this.mallivastaus = new JPanel(new GridLayout(4, 1));
        mallivastaus.setBackground(new Color(0xffffff));
        mallivast.setBackground(new Color(0xffffdd));
        mallivastaus.add(kysymysUudestaan);
        mallivastaus.add(mallivast);
        mallivastaus.add(vastauksesi);
        
        JPanel nappipaneeli2 = new JPanel(new GridLayout(3, 1));
        nappipaneeli2.setBackground(new Color(0xffffff));
        mallivastaus.add(nappipaneeli2);
        
        JLabel arviointiteksti = new JLabel("Arvostele vastauksesi", SwingConstants.CENTER);
        arviointiteksti.setBackground(new Color(0xffffdd));
        arviointiteksti.setFont(new Font("Rockwell", Font.PLAIN, 16));
        nappipaneeli2.add(arviointiteksti);
        
        JSlider arviointiSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 1);
        arviointiSlider.setBackground(new Color(0xffffff));
        arviointiSlider.setMajorTickSpacing(1);
        arviointiSlider.setPaintTicks(true);
        arviointiSlider.setPaintLabels(true);
        arviointiSlider.setFont(new Font("Rockwell", Font.PLAIN, 16));
        
        nappipaneeli2.add(arviointiSlider);
        
        JButton seuraava = new JButton("Seuraava kysymys");
        seuraava.setFont(new Font("Rockwell", Font.PLAIN, 20));
        seuraava.setBackground(new Color(0xffffdd));
        seuraava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                if (tenttaa.esitaKysymys().equals("Testi on päättynyt.")) {
                    try {
                        tenttaa.arvostele(arviointiSlider.getValue());
                    } catch (IOException ex) {
                        Logger.getLogger(Tenttinakyma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    keskiarvo.setText(new String(String.format("%.1f", tenttaa.testinKeskiarvo())));
                    cl.show(cards, LOPETUSRUUTU);
                } else {
                    try {
                        tenttaa.arvostele(arviointiSlider.getValue());
                    } catch (IOException ex) {
                        Logger.getLogger(Tenttinakyma.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    kysymys.setText(tenttaa.esitaKysymys());
                    vastaus.setText("VASTAUKSESI: ");
                    cl.show(cards, TENTTI);
                }
            }
        });
        nappipaneeli2.add(seuraava);  
        
        // lopetusruutu
        this.lopetusruutu = new JPanel(new GridLayout(3, 1));
        lopetusruutu.setBackground(new Color(0xffffff));
        JLabel loppuviesti = new JLabel("Tentti on päättynyt.", SwingConstants.CENTER);
        loppuviesti.setFont(new Font("Rockwell", Font.PLAIN, 36));
        lopetusruutu.add(loppuviesti);
        
        JPanel keskiarvopaneeli = new JPanel(new GridLayout(2, 1));
        keskiarvopaneeli.setBackground(new Color(0xffffff));
        lopetusruutu.add(keskiarvopaneeli);
        
        JLabel keskiarvoOtsikko = new JLabel("Vastausten keskiarvo: ", SwingConstants.CENTER);
        keskiarvoOtsikko.setFont(new Font("Rockwell", Font.PLAIN, 20));
        keskiarvopaneeli.add(keskiarvoOtsikko);
//      keskiarvo-label on luotu aikaisemmin
        keskiarvopaneeli.add(keskiarvo);
        
        JPanel nappipaneeli3 = new JPanel(new GridLayout(2, 1));
        nappipaneeli3.setBackground(new Color(0xffffff));
        lopetusruutu.add(nappipaneeli3);
        
        nappipaneeli3.add(new JLabel()); //tyhja valiin
        
        JButton lopeta = new JButton("Lopeta");
        lopeta.setFont(new Font("Rockwell", Font.PLAIN, 20));
        lopeta.setBackground(new Color(0xffffdd));
        nappipaneeli3.add(lopeta);
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TENTTIVALIKKO);
            }
        });
        
    }
    
}
