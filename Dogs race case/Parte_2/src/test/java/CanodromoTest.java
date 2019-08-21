/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import arsw.threads.Canodromo;
import arsw.threads.Galgo;
import arsw.threads.MainCanodromo;
import arsw.threads.RegistroLlegada;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2125509
 */
public class CanodromoTest {

    public CanodromoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void pauseTest() {
        Canodromo can = new Canodromo(15, 100);
        ArrayList<Galgo> galgos = new ArrayList<>();
        RegistroLlegada reg = new RegistroLlegada();
        for (int i = 0; i < can.getNumCarriles(); i++) {
            galgos.add(new Galgo(can.getCarril(i), Integer.toString(i), reg));
            galgos.get(i).start();
        }
        ArrayList<Integer> pasos = new ArrayList<>();
        for (int i = 0; i < can.getNumCarriles(); i++) {
            galgos.get(i).setPausa(true);
            pasos.add(galgos.get(i).getPaso());
        }

        boolean condicion = true;
        int contador = 0;
        while (condicion) {
            contador++;
            if (contador == 500) {
                condicion = false;
            }
        }
        for (int i = 0; i < can.getNumCarriles(); i++) {
            assertEquals((int) pasos.get(i), (int) galgos.get(i).getPaso());
        }
         
        for (int i = 0; i < can.getNumCarriles(); i++) {
                galgos.get(i).stop();
        }
        assertTrue(true);

    }
}
