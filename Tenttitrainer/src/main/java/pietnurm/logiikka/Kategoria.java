/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;

/**
 *
 * @author pieta
 */
public class Kategoria {
    private String nimi;
    private ArrayList<Kysymys> kysymykset;
    private ArrayList<Alakategoria> alakategoriat;
    
    public Kategoria(String nimi) {
        this.nimi = nimi;
    }
    public void lisaaKysymys(Kysymys kysymys) {
        kysymykset.add(kysymys);
    }
    public void poistaKysymys(Kysymys kysymys) {
        for (int i = 0; i < kysymykset.size(); i++) {
            if (kysymykset.get(i).equals(kysymys)) {
                kysymykset.remove(i);
            }     
        }
    }
    public ArrayList<Kysymys> palautaKysymykset() {
        return this.kysymykset;
    }
    public void luoAlakategoria(String nimi) {
        Alakategoria alakategoria = new Alakategoria(nimi);
        alakategoriat.add(alakategoria);
    }
    public ArrayList<Alakategoria> palautaAlakategoriat() {
        return this.alakategoriat;
    }
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