/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Kategorialuokka pitaa sisallaan yhteen kategoriaan kuuluvia kysymyksia.
 * @author pieta
 */
public class Kategoria {
    private String nimi;
    private ArrayList<Kysymys> kysymykset;
    private ArrayList<Alakategoria> alakategoriat;
    
    public Kategoria(String nimi) {
        this.nimi = nimi;
        this.kysymykset = new ArrayList();
        this.alakategoriat = new ArrayList();
    }
    
    public String palautaKategorianNimi() {
        return this.nimi;
    }
    /**
     * Lisaa kysymyksen kategoriaan.
     * @param kysymys 
     */
    public void lisaaKysymys(Kysymys kysymys) {
        kysymykset.add(kysymys);
    }
    /**
     * Poistaa kysymyksen kategoriasta.
     * @param kysymys 
     */
    public void poistaKysymys(Kysymys kysymys) {
        for (int i = 0; i < kysymykset.size(); i++) {
            if (kysymykset.get(i).equals(kysymys)) {
                kysymykset.remove(i);
            }     
        }
    }
    /**
     * Palauttaa kaikki kategorian kysymykset.
     * @return 
     */
    public ArrayList<Kysymys> palautaKysymykset() {
        return this.kysymykset;
    }
    /**
     * Luo kategorian sisalle alakategorian.
     * @param nimi 
     */
    public void luoAlakategoria(String nimi) {
       // Alakategoria alakategoria = new Alakategoria(nimi);
        alakategoriat.add(new Alakategoria(nimi));
    }
    /**
     * Palauttaa kategorian sisaiset alakategoriat.
     * @return 
     */
    public ArrayList<Alakategoria> palautaAlakategoriat() {
        return this.alakategoriat;
    }
    /**
     * Palauttaa valitun alakategorian kysymykset.
     * @param alakategorianNimi
     * @return 
     */
    public ArrayList<Kysymys> palautaAlakategorianKysymykset(String alakategorianNimi) {
        ArrayList<Kysymys> alakategorianKysymykset = new ArrayList();
        for (int i = 0; i < kysymykset.size(); i++) {
            if (kysymykset.get(i).haeAlakategoria().equals(alakategorianNimi)) {
                alakategorianKysymykset.add(kysymykset.get(i));
            }
        }
        return alakategorianKysymykset;
    }
}
