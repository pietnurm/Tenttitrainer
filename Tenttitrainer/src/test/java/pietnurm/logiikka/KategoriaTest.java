/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pietnurm.logiikka;

import java.util.ArrayList;
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
    public void setUp() {
        kategoria = new Kategoria("kurssi1");
        kysymys1 = new Kysymys("Kumpi voitti?", "No Kampi tietysti.");
        kysymys2 = new Kysymys("Kumpi hävisi?", "No Kumpi tietysti.");
        kysymys3 = new Kysymys("Ovatko esimerkkikysymykset tyhmiä?", "No ovathan ne.");
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
    
}
