/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.kayttoliittyma;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pieta
 */
public class NappikuuntelijaKysymyseditori implements ActionListener {
    
    private Container container;
    
    public void NappikuuntelijaKysymyseditori (Container container) {
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        container.luoKysymyseditori();
    }
    
}