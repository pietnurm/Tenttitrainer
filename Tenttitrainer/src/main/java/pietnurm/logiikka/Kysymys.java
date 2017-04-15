/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

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
