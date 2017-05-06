/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pieta
 */
public class Kategoriavalitsin extends JComboBox {
    private String[] description = { "Ebullient", "Obtuse", "Recalcitrant", "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent" };
    private JTextField t = new JTextField(15);
    private JComboBox c = new JComboBox();
    private JButton b = new JButton("Add items");
    private int count = 0;
    private JPanel valitsinpaneeli;

    public void init() {
      for (int i = 0; i < 4; i++)
        c.addItem(description[count++]);
      t.setEditable(false);
      b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (count < description.length)
            c.addItem(description[count++]);
        }
      });
      c.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          t.setText("index: " + c.getSelectedIndex() + "   "
              + ((JComboBox) e.getSource()).getSelectedItem());
        }
      });
      
      this.valitsinpaneeli = new JPanel(new GridLayout(3, 1));
      valitsinpaneeli.add(t);
      valitsinpaneeli.add(c);
      valitsinpaneeli.add(b);
      
      
//      Container cp = getContentPane();
//      cp.setLayout(new FlowLayout());
//      cp.add(t);
//      cp.add(c);
//      cp.add(b);

    }
    public JPanel palautaValitsin() {
        return valitsinpaneeli;
    }

}
