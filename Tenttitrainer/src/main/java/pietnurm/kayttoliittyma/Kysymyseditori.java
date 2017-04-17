/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Luokka kysymyseditorinakyman luomiseen.
 * @author pieta
 */
public class Kysymyseditori { // extends JPanel {
//    JPanel kysymyseditori;
    
//    public void Kysymyseditori() {
//        this.kysymyseditori = new JPanel();
//    }
    public JPanel luo() {
        JPanel valikko = new JPanel(new GridLayout(5, 1));
        
        JLabel otsikko = new JLabel("Luo kysymyksiä", SwingConstants.CENTER);
        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
        valikko.setBackground(new Color(0xffffff));
        valikko.add(otsikko);
        
        JButton luo = new JButton("Luo kysymyksiä");
        luo.setFont(new Font("Rockwell", Font.PLAIN, 20));
        luo.setBackground(new Color(0xffffdd));
        valikko.add(luo);
        
        JButton testaa = new JButton("Testaa itseäsi");
        testaa.setFont(new Font("Rockwell", Font.PLAIN, 20));
        testaa.setBackground(new Color(0xffffff));
        valikko.add(testaa);
        
        JButton tulokset = new JButton("Tulokset");
        tulokset.setFont(new Font("Rockwell", Font.PLAIN, 20));
        tulokset.setBackground(new Color(0xffffdd));
        valikko.add(tulokset);
        
        return valikko;
    }
}
