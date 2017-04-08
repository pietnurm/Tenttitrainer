/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/**
 *
 * @author pieta
 */
public class Kayttoliittyma implements Runnable {
    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("TenttiTrainer");
        frame.setPreferredSize(new Dimension(500, 600));
        frame.getContentPane().setBackground(new Color(0xFFFFFF));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(6, 2);
        container.setLayout(layout);
        
        JLabel otsikko = new JLabel("TENTTITRAINER", SwingConstants.CENTER);
        otsikko.setFont(new Font("Rockwell", Font.PLAIN, 36));
//        otsikko.setForeground(new Color(0xffffdd));
        
        container.add(otsikko);
    }

    public JFrame getFrame() {
        return frame;
    }
}
