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
 * Luokka, joka tenttii kayttajalta taman valitsemia kysymyksia.
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
    
    /**
     * Luo testin valittujen alakategorioiden kysymysten pohjalta.
     * @param kysymysvarasto
     * @param kategoria
     * @param alakategoriat 
     */
    public Testi(Kysymysvarasto kysymysvarasto, Kategoria kategoria, ArrayList<Alakategoria> alakategoriat) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = kategoria;
        this.alakategoriat = alakategoriat;
        this.kysymyslista = new ArrayList<>();
        this.kysymysIndex = 0;
        this.omaVastaus = "";
        this.pistesaldo = 0;
    } 
    /**
     * Luo testin valitun kategorian kysymysten pohjalta.
     * @param kysymysvarasto
     * @param kategoria 
     */
    public Testi(Kysymysvarasto kysymysvarasto, Kategoria kategoria) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = kategoria;
        this.alakategoriat = null;
        this.kysymyslista = new ArrayList<>();
        this.kysymysIndex = 0;
        this.omaVastaus = "";
        this.pistesaldo = 0;
    }
    /**
     * Luo testin kaikkien kysymysvaraston kysymysten pohjalta.
     * @param kysymysvarasto 
     */
    public Testi(Kysymysvarasto kysymysvarasto) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = null;
        this.alakategoriat = null;
//        this.kysymyslista = new ArrayList<>();
        this.kysymysIndex = 0;
        this.omaVastaus = "";
        this.pistesaldo = 0;
    }
    /**
     * Metodi luo tenttaamista varten oikean laajuisen satunnaistetun kysymyslistan 
     * perustuen konstruktorin parametreihin.
     */
    public void luoKysymyslista() {
        if (this.kategoria == null && this.alakategoriat == null) {
            // testaa kaikkia kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = this.kysymysvarasto.palautaKaikkiKysymykset();
            this.kysymyslista = valitutKysymykset;
        } else if (this.alakategoriat == null) {
            // testaa kaikkia kategorian kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = this.kategoria.palautaKysymykset();
            this.kysymyslista = valitutKysymykset;
        } else {
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
        }
        Collections.shuffle(kysymyslista);
    }
    public ArrayList<Kysymys> palautaKysymyslista() {
        return this.kysymyslista;
    }

    /**
     * Metodi palauttaa kysymysIndex-muuttujan mukaisen kysymyksen kysymyslistalta.
     * @return 
     */
    public String esitaKysymys() {
        String kysymys = this.kysymyslista.get(kysymysIndex).haeKysymys();
        return kysymys;
    }
    /**
     * Metodi palauttaa edelliseen kysymykseen liittyvan mallivastauksen ja 
     * siirtyy kysymyslistalla seuraavaan kysymykseen.
     * @return 
     */
    public String esitaMallivastaus() {
        String mallivastaus = kysymyslista.get(kysymysIndex).haeMallivastaus();
        // siirtyy seuraavaan kysymykseen
        kysymysIndex++;
        return mallivastaus;
    }
    /**
     * Tallentaa parametrina annetun kayttajan vastauksen omaVastaus-muuttujaan.
     * @param omaVastaus 
     */
    public void annaOmaVastaus(String omaVastaus) {
        this.omaVastaus = omaVastaus;
    }
    /**
     * Palauttaa omaVastaus-muuttujan arvon.
     * @return 
     */
    public String palautaOmaVastaus() {
        return omaVastaus;
    }
    /**
     * Metodi lisaa testin pistesaldoon parametrina annetun kokonaisluvun.
     * @param arvostelu 
     */
    public void arvostele(int arvostelu) {
        this.pistesaldo = pistesaldo + arvostelu;
    }
    public int palautaPistesaldo() {
        return this.pistesaldo;
    }
    /**
     * Palauttaa testin kysymysten keskiarvopisteet perustuen kysyttyjen kysymysten maaraan.
     * @return 
     */
    public double testinKeskiarvo() {
        if (kysymysIndex == 0) {
            return 0.0;
        } else {
            double keskiarvo = (double) pistesaldo / (double) kysymysIndex;
            return keskiarvo;
        } 
    }
}
