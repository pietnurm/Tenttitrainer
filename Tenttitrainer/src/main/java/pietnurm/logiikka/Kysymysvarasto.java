/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka pitaa sisallaan kysymykset kaikista kategorioista ja alakategorioista.
 * @author pieta
 */
public class Kysymysvarasto {
    private File kategorialista;
    private Scanner scanner;
    private ArrayList<Kategoria> kaikkiKategoriat;
    
    public Kysymysvarasto() {
        this.kategorialista = new File("kategorialista.txt");
        kaikkiKategoriat = new ArrayList<>();
    }
    /**
     * Hakee aiemmin tallennetut kategoriat ja kategorioiden kysymykset.
     * @throws IOException 
     */
    public void haeTallennetutKategoriat() throws IOException {
        try {
            this.scanner = new Scanner(kategorialista);
            while (scanner.hasNextLine()) {
                String nimi = scanner.nextLine();
                Kategoria kategoria = new Kategoria(nimi);
                lisaaKategoria(kategoria);
            }
        } catch (FileNotFoundException e) {
        }
    }
    /**
     * Lisää kategorian kysymysvaraston kategorialistaan, mutta ei kategorialista-tiedostoon.
     * @param kategoria 
     */
    public void lisaaKategoria(Kategoria kategoria) {
        kategoria.haeTallennetutKysymykset();
        this.kaikkiKategoriat.add(kategoria);
    }
    /**
     * Poistaa kategorian kysymysvaraston kategorialistasta, mutta ei kategorialista-tiedostosta.
     * @param kategoria 
     */
    public void poistaKategoria(Kategoria kategoria) {
        for (int i = 0; i < kaikkiKategoriat.size(); i++) {
            if (kaikkiKategoriat.get(i).equals(kategoria)) {
                kaikkiKategoriat.remove(i);
            }     
        }
    }
    /**
     * Palauttaa kategorialistan.
     * @return 
     */
    public ArrayList<Kategoria> palautaKategoriat() {
        return this.kaikkiKategoriat;
    }
    /**
     * Palauttaa kysymykset kaikista kategorialistan kategorioista.
     * @return 
     */
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
