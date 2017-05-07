/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Luokka yksittäiselle kysymykselle ja sen mallivastaukselle.
 * @author pieta
 */
public class Kysymys {
    private String kysymys;
    private String mallivastaus;
    private String alakategoria;
    
    public Kysymys(String kysymys, String mallivastaus) {
        this.kysymys = kysymys;
        this.mallivastaus = mallivastaus;
        this.alakategoria = "";
    }
    /**
     * Metodi muuttaa kysymyksen sisällön parametrin arvon mukaiseksi.
     * @param uusiKysymys 
     */
    public void tallennaKysymys(String kategoria) throws IOException {
        String kysymystiedosto = "kysymykset_" + kategoria + ".txt";
        String mallivastaustiedosto = "mallivastaukset_" + kategoria + ".txt";
        FileWriter kysymyskirjoittaja = new FileWriter(kysymystiedosto, true);
        FileWriter mallivastauskirjoittaja = new FileWriter(mallivastaustiedosto, true);
        Scanner kysymyslukija = new Scanner(new File(kysymystiedosto));
        boolean onkoDuplikaatti = false;
        if (kysymyslukija.hasNext()) {
            while (kysymyslukija.hasNextLine()) {
                String kyssari = kysymyslukija.nextLine();
                System.out.println(kyssari);
                if (kyssari.equals(this.kysymys)) {
                    onkoDuplikaatti = true;     
                }
            }
        }
        
        if (onkoDuplikaatti == false) {
            kysymyskirjoittaja.write(this.kysymys);
            kysymyskirjoittaja.write(System.getProperty("line.separator"));
            mallivastauskirjoittaja.write(this.mallivastaus);
            mallivastauskirjoittaja.write(System.getProperty("line.separator"));
        } else {
            System.out.println("Tämä kysymys on jo tallennettu");
        }
        kysymyskirjoittaja.close();
        mallivastauskirjoittaja.close();
    }
    
    public void muokkaaKysymysta(String uusiKysymys) {
        this.kysymys = uusiKysymys;
    }
    /**
     * Metodi muokkaa kysymyksen mallivastauksen sisällön parametrin arvon mukaiseksi.
     * @param uusiMallivastaus 
     */
    public void muokkaaMallivastausta(String uusiMallivastaus) {
        this.mallivastaus = uusiMallivastaus;
    }
    /**
     * Metodilla voi asettaa kysymyksen parametrin mukaan nimettyyn alakategoriaan.
     * @param nimi 
     */
    public void annaAlakategoria(String nimi) {
        this.alakategoria = nimi;
    }
    public String haeKysymys() {
        return this.kysymys;
    }
    public String haeMallivastaus() {
        return this.mallivastaus;
    }
    public String haeAlakategoria() {
        return this.alakategoria;
    }
}
