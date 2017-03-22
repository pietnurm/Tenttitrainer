/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm;

import java.util.ArrayList;
import pietnurm.logiikka.Kategoria;
import pietnurm.logiikka.Kysymys;

/**
 *
 * @author pieta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kysymys kysymys1 = new Kysymys("Kumpi voitti?", "No Kampi tietysti.");
        Kysymys kysymys2 = new Kysymys("Kumpi hävisi?", "No Kumpi tietysti.");
        Kysymys kysymys3 = new Kysymys("Ovatko esimerkkikysymykset tyhmiä?", "No ovathan ne.");
        
//        System.out.println(kysymys1.haeKysymys());
//        System.out.println(kysymys1.haeMallivastaus());
        
        Kategoria kategoria = new Kategoria("kurssi1");
        kategoria.lisaaKysymys(kysymys3);
        kategoria.lisaaKysymys(kysymys2);
        ArrayList<Kysymys> lista = kategoria.palautaKysymykset();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).haeKysymys());
        }
        
    }
    
}
