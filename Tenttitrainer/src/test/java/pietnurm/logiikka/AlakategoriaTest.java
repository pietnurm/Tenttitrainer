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

/**
 *
 * @author pieta
 */
public class AlakategoriaTest {
    Alakategoria alakategoria;
    Kategoria kategoria;
    Kysymys kysymys1;
    Kysymys kysymys2;
    Kysymys kysymys3;
    
    public AlakategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        alakategoria = new Alakategoria("alakategoria1");
        kategoria = new Kategoria("kategoria1");
        kysymys1 = new Kysymys("kysymys1", "mallivastaus1");
        kysymys2 = new Kysymys("kysymys2", "mallivastaus2");
        kysymys3 = new Kysymys("kysymys3", "mallivastaus3");
        kategoria.lisaaKysymys(kysymys1);
        kategoria.lisaaKysymys(kysymys2);
        kategoria.lisaaKysymys(kysymys3);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void nimenMuokkaaminenToimii() {
        alakategoria.muokkaaNimea("uusi nimi");
        assertEquals("uusi nimi", alakategoria.palautaNimi());
    }
    @Test
    public void alakategorianLisaaminenToimii() {
        alakategoria.lisaaKysymys(kysymys1);
        assertEquals("alakategoria1", kysymys1.haeAlakategoria());
    }
    @Test
    public void alakategorianPoistaminenToimii() {
        alakategoria.lisaaKysymys(kysymys1);
        alakategoria.poistaKysymys(kysymys1);
        assertEquals("", kysymys1.haeAlakategoria());
    } 
}
