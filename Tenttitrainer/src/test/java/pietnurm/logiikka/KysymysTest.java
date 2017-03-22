/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

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
public class KysymysTest {
    
    Kysymys kysymys;
    
    public KysymysTest() {   
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kysymys = new Kysymys("Esimerkkikysymys", "Esimerkkimallivastaus");
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
    public void kysymyksenMuokkaaminenToimii() {
        kysymys.muokkaaKysymysta("Uusi kysymys");
        assertEquals("Uusi kysymys", kysymys.toString());
    }
    @Test
    public void mallivastauksenMuokkaaminenToimii() {
        kysymys.muokkaaKysymysta("Uusi mallivastaus");
        assertEquals("Uusi mallivastaus", kysymys.toString());
    }
}
