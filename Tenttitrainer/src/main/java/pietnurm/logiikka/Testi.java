/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;
import pietnurm.logiikka.Alakategoria;
import pietnurm.logiikka.Kategoria;

/**
 *
 * @author pieta
 */
public class Testi {
    
    private Kategoria kategoria;
    private ArrayList<Alakategoria> alakategoria;
    
    public Testi (Kategoria kategoria, Alakategoria alakategoria) {
        this.kategoria = kategoria;
        this.kategoria = kategoria;
        this.alakategoria = new ArrayList<Alakategoria>();
    } 
    public Testi (Kategoria kategoria) {
        this.kategoria = kategoria;
        this.alakategoria = null;
    }
    public Testi () {
        this.kategoria = null;
        this.alakategoria = null;
    }
    public void testaa() {
        if (this.kategoria == null && this.alakategoria == null) {
            // testaa kaikkia kysymyksiä
        }
        if (this.alakategoria == null) {
            // testaa kaikkia kategorian kysymyksiä
        }
        else {
            // testaa alakategorialistassa listattujen alakategorioiden kysymyksiä
        }
    }
}
