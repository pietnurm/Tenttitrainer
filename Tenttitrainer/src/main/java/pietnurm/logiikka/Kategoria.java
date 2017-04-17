/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kategorialuokka pitaa sisallaan yhteen kategoriaan kuuluvia kysymyksia.
 * @author pieta
 */
public class Kategoria {
    private String nimi;
    private ArrayList<Kysymys> kysymykset;
    private ArrayList<Alakategoria> alakategoriat;
    private Scanner scanner;
    private boolean onkoListalla;
    private FileWriter kysymysKirjoittaja;
    private FileWriter mallivastausKirjoittaja;
    private FileWriter kategorialistaKirjoittaja;
    
    public Kategoria(String nimi) throws IOException {
        this.nimi = nimi;
        this.kysymykset = new ArrayList();
        this.alakategoriat = new ArrayList();
        this.kysymysKirjoittaja = new FileWriter("kysymykset_" + nimi + ".txt", true);
        this.mallivastausKirjoittaja = new FileWriter("mallivastaukset_" + nimi + ".txt", true);
        this.kategorialistaKirjoittaja = new FileWriter("kategorialista.txt", true);
        File kategorialista = new File("kategorialista.txt");
// Tarkistaa, onko samannimista kategoriaa tallennettu aiemmin. Jos ei, tallentaa nimen kategorialistaan.
        try {
            this.scanner = new Scanner(kategorialista);
            this.onkoListalla = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals(nimi)) {
                    onkoListalla = true;
                }
            }
        } catch (FileNotFoundException e) {
        }
        if (onkoListalla == false) {
            kategorialistaKirjoittaja.write(nimi);
            kategorialistaKirjoittaja.write(System.getProperty("line.separator"));
            kategorialistaKirjoittaja.close();
        }
    }
    /**
     * Hakee tekstitiedostoista kategoriaan aiemmin tallennetut kysymykset ja mallivastaukset.
     */
    public void haeTallennetutKysymykset() {
        ArrayList<String> kysymyslista = new ArrayList();
        ArrayList<String> mallivastauslista = new ArrayList();       
        File kysymysFile = new File("kysymykset_" + nimi + ".txt");
        try {
            this.scanner = new Scanner(kysymysFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                kysymyslista.add(line);
            }
        } catch (FileNotFoundException e) {
        }
        File mallivastausFile = new File("mallivastaukset_" + nimi + ".txt");
        try {
            this.scanner = new Scanner(mallivastausFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                mallivastauslista.add(line);
            }
        } catch (FileNotFoundException e) {
        }
        for (int i = 0; i < kysymyslista.size(); i++) {
            String kysymys = kysymyslista.get(i);
            String mallivastaus = mallivastauslista.get(i);
            Kysymys kysymysehdokas = new Kysymys(kysymys, mallivastaus);
            boolean onkoListalla = false;
            for (int j = 0; j < kysymykset.size(); j++) {
                if (kysymykset.get(j) == kysymysehdokas) {
                    onkoListalla = true;
                }
            }
            if (onkoListalla == false) {
                kysymykset.add(kysymysehdokas);
            }
        }
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
     * HUOM!! MUISTA POISTAA MYOS KYSYMYS- JA MALLIVASTAUSLISTOILTA!!
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
