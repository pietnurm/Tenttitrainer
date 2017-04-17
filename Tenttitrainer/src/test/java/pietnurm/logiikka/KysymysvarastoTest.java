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
public class KysymysvarastoTest {
    Kysymysvarasto kysymysvarasto;
    Kategoria kategoria1;
    Kategoria kategoria2;
    
    public KysymysvarastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        kysymysvarasto = new Kysymysvarasto();
        kategoria1 = new Kategoria("testikategoria1");
        kategoria2 = new Kategoria("testikategoria2");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void tallennettujenKategorioidenHakeminenToimii() throws IOException {
        ArrayList<Kategoria> testilista = new ArrayList();
        ArrayList<String> nimilista = new ArrayList();
        ArrayList<String> nimilista2 = new ArrayList();
        try {
        Scanner scanner = new Scanner(new File("kategorialista.txt"));
        while (scanner.hasNextLine()){
            String nimi = scanner.nextLine();
            Kategoria kategoria = new Kategoria(nimi);
            kategoria.haeTallennetutKysymykset();
            testilista.add(kategoria);
            }
        } catch (FileNotFoundException e) {
            }        
        kysymysvarasto.haeTallennetutKategoriat();
        
        for (int i = 0; i < testilista.size(); i++) {
            nimilista.add(testilista.get(i).palautaKategorianNimi());
        }
        ArrayList<Kategoria> testilista2 = kysymysvarasto.palautaKategoriat();
        for (int i = 0; i < testilista2.size(); i++) {
            nimilista2.add(testilista2.get(i).palautaKategorianNimi());
        }
        assertEquals(nimilista, nimilista2);       
    }
    @Test
    public void kategorianLisaaminenJaPalauttaminenToimii() {
        ArrayList<Kategoria> testilista = new ArrayList();
        testilista.add(kategoria1);
        testilista.add(kategoria2);
        kysymysvarasto.lisaaKategoria(kategoria1);
        kysymysvarasto.lisaaKategoria(kategoria2);
        assertEquals(testilista, kysymysvarasto.palautaKategoriat());    
    }
    @Test
    public void kategorianPoistaminenToimii() {
        ArrayList<Kategoria> testilista = new ArrayList();
        testilista.add(kategoria2);
        kysymysvarasto.lisaaKategoria(kategoria1);
        kysymysvarasto.lisaaKategoria(kategoria2);
        kysymysvarasto.poistaKategoria(kategoria1);
        assertEquals(testilista, kysymysvarasto.palautaKategoriat());
    }
    @Test
    public void kategorianPoistaminenTiedostostaToimii() {
// MUISTA TESTATA MYOS ETTA POISTUU KATEGORIALISTA-FILESTA!! (sit kun se on koodattu)
    }
    @Test
    public void kaikkienKysymystenPalauttaminenToimii() {
        kategoria1.lisaaKysymys(new Kysymys("kyssäri1", "mallivastaus1"));
        kategoria2.lisaaKysymys(new Kysymys("kyssäri2", "mallivastaus2"));
        kategoria2.lisaaKysymys(new Kysymys("kyssäri3", "mallivastaus3"));
        
        kysymysvarasto.lisaaKategoria(kategoria1);
        kysymysvarasto.lisaaKategoria(kategoria2);
        
        ArrayList<Kategoria> testikategoriat = new ArrayList<>();
        testikategoriat.add(kategoria1);
        testikategoriat.add(kategoria2);
        ArrayList<Kysymys> testikysymykset = new ArrayList<>();
        for (int i = 0; i < testikategoriat.size(); i++) {
            ArrayList<Kysymys> kategorianKysymykset = testikategoriat.get(i).palautaKysymykset();
            for (int j = 0; j < kategorianKysymykset.size(); j++) {
                testikysymykset.add(kategorianKysymykset.get(j));
            }     
        }
        assertEquals(testikysymykset, kysymysvarasto.palautaKaikkiKysymykset());
    }
}
