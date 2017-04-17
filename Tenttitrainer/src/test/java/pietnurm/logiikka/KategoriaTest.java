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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pieta
 */
public class KategoriaTest {
    Kategoria kategoria;
    Kysymys kysymys1;
    Kysymys kysymys2;
    Kysymys kysymys3;
    
    public KategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        kategoria = new Kategoria("kurssi1");
        kysymys1 = new Kysymys("Kumpi voitti?", "No Kampi tietysti.");
        kysymys2 = new Kysymys("Kumpi hävisi?", "No Kumpi tietysti.");
        kysymys3 = new Kysymys("Ovatko esimerkkikysymykset tyhmiä?", "No ovathan ne.");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void kategoriaTallentuuKategorialistaan() {
        boolean onkoListalla = false;
        try {
        Scanner scanner = new Scanner(new File("kategorialista.txt"));
        while (scanner.hasNextLine()){
            String nimi = scanner.nextLine();
            if (nimi.equals("kurssi1")) {
                onkoListalla = true;
                }
            }
        } catch (FileNotFoundException e) {
            }
        assertTrue(onkoListalla);        
    }
    @Test
    public void kategorialistaanEiTallennuDuplikaatteja() throws IOException {
        Kategoria kategoria2 = new Kategoria("kurssi1");
        Kategoria kategoria3 = new Kategoria("kurssi1");
        int laskuri = 0;
        try {
        Scanner scanner = new Scanner(new File("kategorialista.txt"));
        while (scanner.hasNextLine()){
            String nimi = scanner.nextLine();
            if (nimi.equals("kurssi1")) {
                laskuri++;
                }
            }
        } catch (FileNotFoundException e) {
            }
        assertTrue(laskuri == 1);
    }
    @Test
    public void kysymystenLisaaminenJaPalauttaminenToimii() {
        ArrayList<Kysymys> lista = new ArrayList();
        lista.add(kysymys1);
        lista.add(kysymys2);
        lista.add(kysymys3);
        kategoria.lisaaKysymys(kysymys1);
        kategoria.lisaaKysymys(kysymys2);
        kategoria.lisaaKysymys(kysymys3);
        assertEquals(lista, kategoria.palautaKysymykset());
    }
    @Test
    public void tallennettujenKysymystenHakeminenToimii() {
// NAMA VOINEE LISATA SITTEN, KUN lisaaKysymys() TALLENTAA KYSSARIN JA MALLIVASTAUKSEN MYOS TIEDOSTOIHIN        
//        kategoria.lisaaKysymys(kysymys1);
//        kategoria.lisaaKysymys(kysymys2);
//        kategoria.lisaaKysymys(kysymys3);
        
        kategoria.haeTallennetutKysymykset();
        
        ArrayList<Kysymys> testilista = new ArrayList();
        ArrayList<String> kysymyslista = new ArrayList();
        ArrayList<String> mallivastauslista = new ArrayList();       
        File kysymysFile = new File("kysymykset_kurssi1.txt");
        try {
        Scanner scanner = new Scanner(kysymysFile);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            kysymyslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        File mallivastausFile = new File("mallivastaukset_kurssi1.txt");
        try {
        Scanner scanner2 = new Scanner(mallivastausFile);

        while (scanner2.hasNextLine()){
            String line = scanner2.nextLine();
            mallivastauslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        for (int i = 0; i < kysymyslista.size(); i++) {
            String kysymys = kysymyslista.get(i);
            String mallivastaus = mallivastauslista.get(i);
            testilista.add(new Kysymys(kysymys, mallivastaus));
        }
        ArrayList<String> kysymykset = new ArrayList();
        ArrayList<String> testikysymykset = new ArrayList();
        
        for (int i = 0; i < kategoria.palautaKysymykset().size(); i++) {
            kysymykset.add(kategoria.palautaKysymykset().get(i).haeKysymys());
        }
        for (int i = 0; i < testilista.size(); i++) {
            testikysymykset.add(testilista.get(i).haeKysymys());
        }
        assertEquals(testikysymykset, kysymykset);
    }
    @Test
    public void tallennettujenMallivastaustenHakeminenToimii() {
// NAMA VOINEE LISATA SITTEN, KUN lisaaKysymys() TALLENTAA KYSSARIN JA MALLIVASTAUKSEN MYOS TIEDOSTOIHIN        
//        kategoria.lisaaKysymys(kysymys1);
//        kategoria.lisaaKysymys(kysymys2);
//        kategoria.lisaaKysymys(kysymys3);
        
        kategoria.haeTallennetutKysymykset();
        
        ArrayList<Kysymys> testilista = new ArrayList();
        ArrayList<String> kysymyslista = new ArrayList();
        ArrayList<String> mallivastauslista = new ArrayList();       
        File kysymysFile = new File("kysymykset_kurssi1.txt");
        try {
        Scanner scanner = new Scanner(kysymysFile);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            kysymyslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        File mallivastausFile = new File("mallivastaukset_kurssi1.txt");
        try {
        Scanner scanner2 = new Scanner(mallivastausFile);

        while (scanner2.hasNextLine()){
            String line = scanner2.nextLine();
            mallivastauslista.add(line);
            }
        } catch (FileNotFoundException e) {
            }
        for (int i = 0; i < kysymyslista.size(); i++) {
            String kysymys = kysymyslista.get(i);
            String mallivastaus = mallivastauslista.get(i);
            testilista.add(new Kysymys(kysymys, mallivastaus));
        }
        ArrayList<String> vastaukset = new ArrayList();
        ArrayList<String> testivastaukset = new ArrayList();
        
        for (int i = 0; i < kategoria.palautaKysymykset().size(); i++) {
            vastaukset.add(kategoria.palautaKysymykset().get(i).haeMallivastaus());
        }
        for (int i = 0; i < testilista.size(); i++) {
            testivastaukset.add(testilista.get(i).haeMallivastaus());
        }
        assertEquals(testivastaukset, vastaukset);
    }
    @Test
    public void tallennettujenKysymystenHakeminenEiTuotaDuplikaatteja() {
        // TAA EI MITTAA MITAAN ENNEN KUIN lisaaKysymys() TALLENTAA TIEDOSTOON.
        kategoria.lisaaKysymys(kysymys1);
        kategoria.haeTallennetutKysymykset();
        int laskuri = 0;
        for (int i = 0; i < kategoria.palautaKysymykset().size(); i++) {
            if (kategoria.palautaKysymykset().get(i).haeKysymys().equals("Kumpi voitti?")) {
                laskuri++;
            }
        }
        assertTrue(laskuri == 1);
    }
    @Test
    public void kysymystenPoistaminenToimii() {
        ArrayList<Kysymys> lista = new ArrayList();
        lista.add(kysymys2);
        lista.add(kysymys3);
        kategoria.lisaaKysymys(kysymys1);
        kategoria.lisaaKysymys(kysymys2);
        kategoria.lisaaKysymys(kysymys3);
        kategoria.poistaKysymys(kysymys1);
        assertEquals(lista, kategoria.palautaKysymykset());
    }
    @Test
    public void kysymyksetJaMallivastauksetPoistuvatMyosTiedostoista() {
        //MUISTA TESTATA KUN TOIMINNALLISUUS KOODATTU! ERI TESTIT KYSSÄREILLE JA MALLIVASTAUKSILLE?
    }
    @Test
    public void alakategorioidenLuominenJaPalauttaminenToimii() {
        ArrayList<String> lista = new ArrayList();
        lista.add("alakategoria1");
        lista.add("alakategoria2");
        kategoria.luoAlakategoria("alakategoria1");
        kategoria.luoAlakategoria("alakategoria2");
        ArrayList<String> alakategorioidenNimet = new ArrayList();
        for (int i = 0; i < kategoria.palautaAlakategoriat().size(); i++) {
            alakategorioidenNimet.add(kategoria.palautaAlakategoriat().get(i).palautaNimi());
        }
        assertEquals(lista, alakategorioidenNimet);
    }
    @Test
    public void alakategorianKysymystenPalauttaminenToimii() {
        ArrayList<Kysymys> lista = new ArrayList();
        lista.add(kysymys1);
        lista.add(kysymys2);
        kategoria.lisaaKysymys(kysymys1);
        kategoria.lisaaKysymys(kysymys2);
        kysymys1.annaAlakategoria("alakategoria1");
        kysymys2.annaAlakategoria("alakategoria1");
        assertEquals(lista, kategoria.palautaAlakategorianKysymykset("alakategoria1"));
    }
}
