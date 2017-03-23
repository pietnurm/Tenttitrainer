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
//    @Test
//    public void alakategorioidenLuominenJaListaaminenToimii() {
//        ArrayList<Alakategoria> lista = new ArrayList();
//        lista.add(new Alakategoria("alakategoria1"));
////        lista.add(new Alakategoria("alakategoria2"));
//        kategoria.luoAlakategoria("alakategoria1");
////        kategoria.luoAlakategoria("alakategoria2");
//        assertEquals(lista.toString(), kategoria.palautaAlakategoriat().toString());
//    }
    @Test
    public void alakategorianKysymystenPalauttaminenToimii() {
        ArrayList<Kysymys> lista = new ArrayList();
        lista.gsrdhf
        kysymys1.annaAlakategoria("alakategoria1");
        kysymys2.annaAlakategoria("alakategoria1");
        assertEquals(lista, kategoria.palautaAlakategorianKysymykset("alakategoria1"));
    }
}
