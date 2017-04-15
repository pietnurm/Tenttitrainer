/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitaa sisallaan kysymykset kaikista kategorioista ja alakategorioista.
 * @author pieta
 */
public class Kysymysvarasto {
    private ArrayList<Kategoria> kaikkiKategoriat;
    
    public Kysymysvarasto() {
        kaikkiKategoriat = new ArrayList<>();
    }
    public void lisaaKategoria(Kategoria kategoria) {
        this.kaikkiKategoriat.add(kategoria);
    }
    public void poistaKategoria(Kategoria kategoria) {
        for (int i = 0; i < kaikkiKategoriat.size(); i++) {
            if (kaikkiKategoriat.get(i).equals(kategoria)) {
                kaikkiKategoriat.remove(i);
            }     
        }
    }
    public ArrayList<Kategoria> palautaKategoriat() {
        return this.kaikkiKategoriat;
    }
    public ArrayList<Kysymys> palautaKaikkiKysymykset() {
        ArrayList<Kysymys> kaikkiKysymykset = new ArrayList<>();
        for (int i = 0; i < kaikkiKategoriat.size(); i++) {
            ArrayList<Kysymys> kategorianKysymykset = kaikkiKategoriat.get(i).palautaKysymykset();
            for (int j = 0; j < kategorianKysymykset.size(); j++) {
                kaikkiKysymykset.add(kategorianKysymykset.get(j));
            }     
        }
        return kaikkiKysymykset;
    }
}
