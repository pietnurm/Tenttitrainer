/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import pietnurm.logiikka.Tulosarkisto;
/**
 * Luokka graafisen kayttoliittyman ajamiseen.
 * @author pieta
 */
public class Kayttoliittyma implements Runnable {
    public JFrame frame;
    public JPanel sisalto;
    public JPanel cards;
    public final static String VALIKKOPANEL = "valikko";
    private final static String EDITPANEL = "kysymyseditori";
    private final static String TENTTIVALIKKO = "tenttivalikko";
    private final static String TULOKSET = "tulokset";

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("TenttiTrainer");
        frame.setPreferredSize(new Dimension(500, 600));
        frame.getContentPane().setBackground(new Color(0xFFFFFF));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit();
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.add(cards);
        
        frame.pack();
        frame.setVisible(true);
    }
/**
 * Luo käyttöliittymän komponentit.
 * @throws IOException 
 */
    public void luoKomponentit() throws IOException {       
        // luo paavalikon
        JPanel valikko = new JPanel(new GridLayout(5, 1));
        valikko.setBackground(new Color(0xffffff));
        
        JLabel otsikko = new JLabel("TENTTITRAINER", SwingConstants.CENTER);
        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
        valikko.add(otsikko);
        
        JButton luo = new JButton("Luo kysymyksiä");
        luo.setFont(new Font("Rockwell", Font.PLAIN, 20));
        luo.setBackground(new Color(0xffffdd));
        luo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, EDITPANEL);
            }
        });
        valikko.add(luo);
        
        JButton testaa = new JButton("Testaa itseäsi");
        testaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
        testaa.setBackground(new Color(0xffffff));
        testaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TENTTIVALIKKO);
            }
        });
        valikko.add(testaa);
        
        JButton tulokset = new JButton("Tulokset");
        tulokset.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tulokset.setBackground(new Color(0xffffdd));
        tulokset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, TULOKSET);
            }
        });
        valikko.add(tulokset);
        
        // Tulokset-Card
        JPanel tulospaneeli = new JPanel(new GridLayout(3, 1));
        tulospaneeli.setBackground(new Color(0xffffff));
        
        JLabel tulosotsikko = new JLabel("TULOKSET", SwingConstants.CENTER);
        tulosotsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
        tulospaneeli.add(tulosotsikko);
        
        JLabel keskiarvot = new JLabel("", SwingConstants.CENTER);
        keskiarvot.setBackground(new Color(0xffffdd));
        keskiarvot.setFont(new Font("Rockwell", Font.PLAIN, 16));

        Tulosarkisto arkisto = new Tulosarkisto();
        String[] kolumnit = {"Kategoria", "Keskiarvo", "Vastattuja kysymyksiä"};
        JTable tulostaulukko = new JTable(arkisto.tulosdata(), kolumnit);
        tulostaulukko.setBackground(new Color(0xffffdd));
        tulostaulukko.setFont(new Font("Calibri", Font.PLAIN, 13));
        
        JScrollPane kaLuettelo = new JScrollPane(tulostaulukko);
        kaLuettelo.getViewport().setBackground(tulostaulukko.getBackground());
        tulospaneeli.add(kaLuettelo);
        
        JPanel alapalkki = new JPanel(new GridLayout(4,1));
        alapalkki.setBackground(new Color(0xffffff));
        
        JLabel kokonaiskeskiarvo = new JLabel("Kokonaiskeskiarvo: " + String.format("%.2f", arkisto.kokonaiskeskiarvo()), SwingConstants.CENTER);
        kokonaiskeskiarvo.setFont(new Font("Rockwell", Font.PLAIN, 17));
        alapalkki.add(kokonaiskeskiarvo);
        
//        TULOSTEN NOLLAAMISEN TOIMINNALLISUUTTA EI VIELA TUETA
//        
//        JTextArea poistettava = new JTextArea();
//        poistettava.setFont(new Font("Calibri", Font.PLAIN, 16));
//        poistettava.setBackground(new Color(0xffffff));
//        
//        
//        JButton tyhjennaKategorianTulokset = new JButton("Syötä nollattava kategoria"); 
//        tyhjennaKategorianTulokset.setFont(new Font("Rockwell", Font.PLAIN, 16));
//        tyhjennaKategorianTulokset.setBackground(new Color(0xffffdd));
//        tyhjennaKategorianTulokset.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                String poistokategoria = poistettava.getText();
//                try {
//                    arkisto.poistaTulokset(poistokategoria);
//                } catch (IOException ex) {
//                    Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                poistettava.setText("");
//                frame.dispose();
//                
//                CardLayout cl = (CardLayout) (cards.getLayout());
//                cl.show(cards, TULOKSET);
//            }
//        });
//        alapalkki.add(tyhjennaKategorianTulokset);
//        alapalkki.add(poistettava);
        
        JButton paavalikkoon = new JButton("Takaisin valikkoon");
        paavalikkoon.setFont(new Font("Rockwell", Font.PLAIN, 20));
        paavalikkoon.setBackground(new Color(0xffffdd));
        paavalikkoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, VALIKKOPANEL);
            }
        });
        alapalkki.add(paavalikkoon);
        
        tulospaneeli.add(alapalkki);
        
        // luo paapaneelin, joka pitaa sisallaan kaikki muut
        this.cards = new JPanel(new CardLayout());
        
        Kysymyseditori editori = new Kysymyseditori(this);
        Tenttinakyma tenttinakyma = new Tenttinakyma(this);
        JPanel editPanel = editori.luo();
        JPanel tenttivalikko = tenttinakyma.luo();
        
        cards.add(valikko, VALIKKOPANEL);
        cards.add(editPanel, EDITPANEL);
        cards.add(tenttivalikko, TENTTIVALIKKO);
        cards.add(tulospaneeli, TULOKSET);
        
    }

    public JFrame getFrame() {
        return frame;
    }
    /**
     * Metodi käyttöliittymäikkunan sulkemiseen (turha).
     */
    public void suljeIkkuna() {
        frame.dispose();
    }
}
