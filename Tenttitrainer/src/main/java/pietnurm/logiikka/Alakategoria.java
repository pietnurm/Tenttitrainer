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
public class Alakategoria {
    private String nimi;
//    private Kategoria ylakategoria;
    
    public Alakategoria(String nimi) {  // Kategoria ylakategoria
        this.nimi = nimi;
//        this.ylakategoria = ylakategoria;
    }
    public void muokkaaNimea(String uusiNimi) {
        this.nimi = uusiNimi;
    }
    public String palautaNimi() {
        return this.nimi;
    }
    public void lisaaKysymys(Kysymys kysymys) {
        kysymys.annaAlakategoria(nimi);
    }
    public void poistaKysymys(Kysymys kysymys) {
        kysymys.annaAlakategoria("");
    }
// TÄTÄ EI TARVII, KOSKA TOTEUTETAAN KATEGORIA-LUOKASSA
//    public ArrayList<Kysymys> palautaKysymykset() {
//        ArrayList<Kysymys> kysymykset = new ArrayList();
//        ArrayList<Kysymys> ylakategorianKysymykset = ylakategoria.palautaKysymykset();
//        for (int i = 0; i < ylakategorianKysymykset.size(); i++) {
//            if (ylakategorianKysymykset.get(i).haeAlakategoria().equals(nimi)) {
//                kysymykset.add(ylakategorianKysymykset.get(i));
//            }
//        }
//        return kysymykset;
//    }
}
