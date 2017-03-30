/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pietnurm.logiikka.Alakategoria;
import pietnurm.logiikka.Kategoria;

/**
 *
 * @author pieta
 */
public class TestiTest {
    Kategoria kategoria;
    Alakategoria alakategoria1;
    Alakategoria alakategoria2;
    
    public TestiTest() {
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
        alakategoria1 = new Alakategoria("alakategoria1");
        alakategoria2 = new Alakategoria("alakategoria2");    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
