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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static pietnurm.kayttoliittyma.Kayttoliittyma.VALIKKOPANEL;

/**
 *
 * @author pieta
 */
public class Card extends JPanel {
    public final String nimi;

    public Card(String nimi){
        this.nimi = nimi;
    }
}
