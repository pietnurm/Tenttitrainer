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
    
    public Testi (Kysymysvarasto kysymysvarasto, Kategoria kategoria, ArrayList<Alakategoria> alakategoriat) {
        this.kysymysvarasto = kysymysvarasto;
        this.kategoria = kategoria;
        this.kategoria = kategoria;
        this.alakategoriat = new ArrayList<>();
    } 
    public Testi (Kategoria kategoria) {
        this.kategoria = kategoria;
        this.alakategoriat = null;
    }
    public Testi () {
        this.kategoria = null;
        this.alakategoriat = null;
    }
    public void testaa() {
        if (this.kategoria == null && this.alakategoriat == null) {
            // testaa kaikkia kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = kysymysvarasto.palautaKaikkiKysymykset();
            esitaKysymykset(valitutKysymykset);
        }
        if (this.alakategoriat == null) {
            // testaa kaikkia kategorian kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = kategoria.palautaKysymykset();
            esitaKysymykset(valitutKysymykset);
        }
        else {
            // testaa alakategorialistassa listattujen alakategorioiden kysymyksiä
            ArrayList<Kysymys> valitutKysymykset = new ArrayList<>();
            for (int i = 0; i < this.alakategoriat.size(); i++) {
                String alakategorianNimi = this.alakategoriat.get(i).palautaNimi();
                for (int j = 0; j < kategoria.palautaAlakategorianKysymykset(alakategorianNimi).size(); j++) {
                    valitutKysymykset.add(kategoria.palautaAlakategorianKysymykset(alakategorianNimi).get(j));
                }
            }
            esitaKysymykset(valitutKysymykset);
        }
    }
    public void esitaKysymykset(ArrayList<Kysymys> kysymyslista) {
        Collections.shuffle(kysymyslista);
        for (int i = 0; i < kysymyslista.size(); i++) {
            System.out.println(kysymyslista.get(i).haeKysymys());
        }
    }
}
