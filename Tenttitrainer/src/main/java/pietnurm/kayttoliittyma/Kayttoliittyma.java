/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
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
            //        luoKomponentit(frame.getContentPane());
            luoKomponentit();
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.add(cards);
        
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit() throws IOException {
        
//        sisalto = new JPanel(new CardLayout());
//        
//        sisalto.add(new Kysymyseditori("editori"));
        
        
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
        
        keskiarvot.setText("sipuli");
        
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");
        keskiarvot.setText("<html>" + keskiarvot.getText() + "<br>piirakka</html>");

//        keskiarvot.setFont(new Font("Rockwell", Font.PLAIN, 150));
//        tulospaneeli.add(keskiarvot);
        JScrollPane kaLuettelo = new JScrollPane(keskiarvot, 100, 100);
//        kaLuettelo.setBackground(new Color(0xffffdd));
        tulospaneeli.add(kaLuettelo);
       
        
        // luo paapaneelin, joka pitaa sisallaan kaikki muut
        
        
        this.cards = new JPanel(new CardLayout());
        
//        Kysymyseditori editori = new Kysymyseditori();
        Tenttinakyma tenttinakyma = new Tenttinakyma();
//        JPanel editPanel = editori.luo();
        JPanel tenttivalikko = tenttinakyma.luo();
        
        cards.add(valikko, VALIKKOPANEL);
//        cards.add(editPanel, EDITPANEL);
        cards.add(tenttivalikko, TENTTIVALIKKO);
        cards.add(tulospaneeli, TULOKSET);
        
    }
    
        
        
//    private void luoKomponentit(Container container) {
//        GridLayout layout = new GridLayout(1,1);
//        container.setLayout(layout);
//       
//        container.add(luoValikko());
//        
//    }
//    private JPanel luoValikko() {
//        JPanel valikko = new JPanel(new GridLayout(5, 1));
//        
//        JLabel otsikko = new JLabel("TENTTITRAINER", SwingConstants.CENTER);
//        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
//        valikko.setBackground(new Color(0xffffff));
//        valikko.add(otsikko);
//        
//        JButton luo = new JButton("Luo kysymyksiä");
//        luo.setFont(new Font("Rockwell", Font.PLAIN, 20));
//        luo.setBackground(new Color(0xffffdd));
////        luo.addActionListener(nappikuuntelijaKysymyseditori);
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
//    private JPanel luoKysymyseditori() {
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
    

    public JFrame getFrame() {
        return frame;
    }
    public void suljeIkkuna() {
        frame.dispose();
    }
}
