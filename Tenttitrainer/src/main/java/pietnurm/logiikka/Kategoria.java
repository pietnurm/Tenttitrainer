/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
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
    
    public Kategoria(String nimi) {
        this.nimi = nimi;
        this.kysymykset = new ArrayList();
        this.alakategoriat = new ArrayList();
    }
    /**
     * Hakee tekstitiedostoista kategoriaan aiemmin tallennetut kysymykset ja mallivastaukset.
     */
    public void haeTallennetutKysymykset() {
        ArrayList<String> kysymyslista = new ArrayList();
        ArrayList<String> mallivastauslista = new ArrayList();
//  MUISTA MUOKKAA FILENAMET KATEGORIAN NIMEN MUKAISEKSI! JA JOKU UUDEN FILEEN LUOMISMEKANISMI.        
        File kysymysFile = new File("kysymykset.txt");
        try {
        this.scanner = new Scanner(kysymysFile);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            kysymyslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        File mallivastausFile = new File("mallivastaukset.txt");
        try {
        this.scanner = new Scanner(mallivastausFile);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            mallivastauslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        for (int i = 0; i < kysymyslista.size(); i++) {
            String kysymys = kysymyslista.get(i);
            String mallivastaus = mallivastauslista.get(i);
            kysymykset.add(new Kysymys(kysymys, mallivastaus));
        }
        
        
//        InputStream kysymysStream = this.getClass().getResourceAsStream("/" + "kysymykset.txt");
//        this.scanner = new Scanner(kysymysStream, "UTF-8");
//        while (scanner.hasNextLine()){
//            kysymys = scanner.nextLine();
//        }
//        scanner.close();
//        InputStream mallivastausStream = this.getClass().getResourceAsStream("/" + "mallivastaukset.txt");
//        this.scanner = new Scanner(mallivastausStream, "UTF-8");
//        while (scanner.hasNextLine()){
//            mallivastaus = scanner.nextLine();
//        }
//        scanner.close();
//        lisaaKysymys(new Kysymys(kysymys, mallivastaus));
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
