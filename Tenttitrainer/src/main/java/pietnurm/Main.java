/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import pietnurm.kayttoliittyma.Kayttoliittyma;
import pietnurm.logiikka.Alakategoria;
import pietnurm.logiikka.Kategoria;
import pietnurm.logiikka.Kysymys;
import pietnurm.logiikka.Testi;
import pietnurm.logiikka.Kysymysvarasto;

/**
 *
 * @author pieta
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Kysymysvarasto kysymysvarasto = new Kysymysvarasto();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        Kysymys kysymys1 = new Kysymys("Kumpi voitti?", "No Kampi tietysti.");
        Kysymys kysymys2 = new Kysymys("Kumpi hävisi?", "No Kumpi tietysti.");
        Kysymys kysymys3 = new Kysymys("Ovatko esimerkkikysymykset tyhmiä?", "No ovathan ne.");
        
//        System.out.println(kysymys1.haeKysymys());
//        System.out.println(kysymys1.haeMallivastaus());
        
        Kategoria kategoria = new Kategoria("kurssi1");
        
        kategoria.haeTallennetutKysymykset();
        
//        kategoria.lisaaKysymys(kysymys3);
//        kategoria.lisaaKysymys(kysymys2);
//        
//        Kategoria kategoria2 = new Kategoria("kurssi2");
//        kategoria.lisaaKysymys(kysymys1);
//        
        kysymysvarasto.lisaaKategoria(kategoria);
        
//        kysymysvarasto.lisaaKategoria(kategoria2);
//        
//        Alakategoria alakategoria = new Alakategoria("alakategoria1");
//        Alakategoria alakategoria2 = new Alakategoria("alakategoria2");
//        
//        alakategoria.lisaaKysymys(kysymys3);
//        alakategoria.lisaaKysymys(kysymys2);
//        alakategoria2.lisaaKysymys(kysymys1);
//        
//        ArrayList<Alakategoria> alakategoriat = new ArrayList<>();
//        alakategoriat.add(alakategoria);
//        alakategoriat.add(alakategoria2);
        
        ArrayList<Kysymys> lista = kysymysvarasto.palautaKaikkiKysymykset();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).haeKysymys());
            System.out.println(lista.get(i).haeMallivastaus());
        }    
//        
//        kysymys1.annaAlakategoria("alakategoria1");
//        kysymys2.annaAlakategoria("alakategoria1");
//        
//        }
        
//        kategoria.luoAlakategoria("alakategoooria"); 
//        for (int i = 0; i < kategoria.palautaAlakategoriat().size(); i++) {
//            System.out.println(kategoria.palautaAlakategoriat().get(i).palautaNimi());
//        }
//        Testi testi = new Testi(kysymysvarasto);
//        Testi testi2 = new Testi(kysymysvarasto, kategoria);
//        Testi testi3 = new Testi(kysymysvarasto, kategoria, alakategoriat);
        

//        testi.testaa();

//        for (int i = 0; i < kysymysvarasto.palautaKategoriat().size(); i++) {
//            System.out.println(kysymysvarasto.palautaKategoriat().get(i).palautaKategorianNimi());
//        }
//        for (int i = 0; i < kysymysvarasto.palautaKaikkiKysymykset().size(); i++) {
//            System.out.println(kysymysvarasto.palautaKaikkiKysymykset().get(i).haeKysymys());
//        }
        
        
//        for (int i = 0; i < kategoria.palautaAlakategorianKysymykset("alakategoria1").size(); i++) {
//            System.out.println(kategoria.palautaAlakategorianKysymykset("alakategoriat1").get(i));
//        }
        
        
    }
    
}
