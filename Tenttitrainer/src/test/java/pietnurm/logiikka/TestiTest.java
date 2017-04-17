/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pietnurm.logiikka.Alakategoria;
import pietnurm.logiikka.Kategoria;
import pietnurm.logiikka.Kysymys;
import pietnurm.logiikka.Kysymysvarasto;
import pietnurm.logiikka.Testi;

/**
 *
 * @author pieta
 */
public class TestiTest {
    Kysymysvarasto kysymysvarasto;
    Kategoria kategoria;
    Alakategoria alakategoria1;
    Alakategoria alakategoria2;
    Testi testaaKaikki;
    
    public TestiTest() {
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
        kategoria = new Kategoria("kurssi1");
        kategoria.lisaaKysymys(new Kysymys("kyssäri1", "malliv.1"));
        kategoria.lisaaKysymys(new Kysymys("kyssäri2", "malliv.2"));
        alakategoria1 = new Alakategoria("alakategoria1");
        alakategoria2 = new Alakategoria("alakategoria2");
        kysymysvarasto.lisaaKategoria(kategoria);
        testaaKaikki = new Testi(kysymysvarasto);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void kysymyslistanLuominenKaikilleKysymyksilleToimii() { 
        testaaKaikki.luoKysymyslista();
        // listat on randomoitu, joten testataan listan pituutta eika sisaltoa.
        assertEquals(kysymysvarasto.palautaKaikkiKysymykset().size(), testaaKaikki.palautaKysymyslista().size());        
    }
    @Test
    public void kysymyslistanLuominenKategorialleToimii() {
        // TESTI
    }
    @Test
    public void kysymyslistanLuominenAlakategorialleToimii() {
        // TESTATAAN TARVITTAESSA ERIKSEEN LISTAN LUOMISTA ALAKATEGORIALISTAN (ei yksittaisen) PERUSTEELLA
    }
    @Test
    public void esitaKysymysPalauttaaTekstia() {
        testaaKaikki.luoKysymyslista();
        assertTrue(testaaKaikki.esitaKysymys().getClass() == String.class);
    }
    @Test
    public void esitaMallivastausPalauttaaTekstia() {
        testaaKaikki.luoKysymyslista();
        assertTrue(testaaKaikki.esitaMallivastaus().getClass() == String.class);
    }
    @Test
    public void mallivastauksenEsittaminenSiirtaaSeuraavaanKysymykseen() {
        testaaKaikki.luoKysymyslista();
        String eka = testaaKaikki.esitaKysymys();
        testaaKaikki.esitaMallivastaus();
        String toka = testaaKaikki.esitaKysymys();
        assertFalse(eka.equals(toka));
    }
    @Test
    public void arvosteluKasvattaaPistesaldoa() {
        testaaKaikki.arvostele(5);
        testaaKaikki.arvostele(3);
        assertEquals(8, testaaKaikki.palautaPistesaldo());
    }
    @Test
    public void keskiarvoLaskettuOikein() {
        testaaKaikki.luoKysymyslista();
        testaaKaikki.esitaMallivastaus();
        testaaKaikki.arvostele(5);
        testaaKaikki.esitaMallivastaus();
        testaaKaikki.arvostele(4);
        assertEquals(4.5, testaaKaikki.testinKeskiarvo(), 1e-8); // 1e-8 = delta-arvo
    }
    @Test
    public void keskiarvoToimiiNollalla() {
        assertEquals(0.0, testaaKaikki.testinKeskiarvo(), 1e-8);
    }
}
