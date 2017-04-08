/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import pietnurm.logiikka.Alakategoria;
import pietnurm.logiikka.Kategoria;

/**
 *
 * @author pieta
 */
public class Testi {
    private Kysymysvarasto kysymysvarasto;
    private Kategoria kategoria;
    private ArrayList<Alakategoria> alakategoriat;
    private ArrayList<Kysymys> kysymyslista;
    private int kysymysIndex;
    private String omaVastaus;
    private int pistesaldo;
    
    public Testi (Kysymysvarasto kysymysvarasto, Kategoria kategoria, ArrayList<Alakategoria> alakategoriat) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = kategoria;
        this.kategoria = kategoria;
        this.alakategoriat = alakategoriat;
        this.kysymyslista = new ArrayList<>();
        this.kysymysIndex = 0;
        this.omaVastaus = "";
        this.pistesaldo = 0;
    } 
    public Testi (Kysymysvarasto kysymysvarasto, Kategoria kategoria) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = kategoria;
        this.alakategoriat = null;
    }
    public Testi (Kysymysvarasto kysymysvarasto) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = null;
        this.alakategoriat = null;
    }
    public void testaa() {
        if (this.kategoria == null && this.alakategoriat == null) {
            // testaa kaikkia kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = this.kysymysvarasto.palautaKaikkiKysymykset();
            this.kysymyslista = valitutKysymykset;
//            esitaKysymykset(valitutKysymykset);
        }
        else if (this.alakategoriat == null) {
            // testaa kaikkia kategorian kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = this.kategoria.palautaKysymykset();
            this.kysymyslista = valitutKysymykset;
//            esitaKysymykset(valitutKysymykset);
        }
        else {
            // testaa alakategorialistassa listattujen alakategorioiden kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = new ArrayList<>();
            System.out.println(this.alakategoriat.size());
            for (int i = 0; i < this.alakategoriat.size(); i++) {
                String alakategorianNimi = this.alakategoriat.get(i).palautaNimi();
                for (int j = 0; j < kategoria.palautaAlakategorianKysymykset(alakategorianNimi).size(); j++) {
                    valitutKysymykset.add(kategoria.palautaAlakategorianKysymykset(alakategorianNimi).get(j));
                }
            }
            this.kysymyslista = valitutKysymykset;
//            esitaKysymykset(valitutKysymykset);
        }
    }
//    public void esitaKysymykset(ArrayList<Kysymys> kysymyslista) {
//        Collections.shuffle(kysymyslista);
//        for (int i = 0; i < kysymyslista.size(); i++) {
//            System.out.println(kysymyslista.get(i).haeKysymys());
//        }
//    }
    public String esitaKysymys() {
        String kysymys = kysymyslista.get(kysymysIndex).haeKysymys();
        return kysymys;
    }
    public String esitaMallivastaus() {
        String mallivastaus = kysymyslista.get(kysymysIndex).haeMallivastaus();
        // siirtyy seuraavaan kysymykseen
        kysymysIndex++;
        return mallivastaus;
    }
    public void annaOmaVastaus(String omaVastaus) {
        this.omaVastaus = omaVastaus;
    }
    public String palautaOmaVastaus() {
        return omaVastaus;
    }
    public void arvostele(int arvostelu) {
        this.pistesaldo = pistesaldo + arvostelu;
    }
    public double testinKeskiarvo() {
        double keskiarvo = (double)pistesaldo/ (double)kysymyslista.size();
        return keskiarvo;
    }
}
