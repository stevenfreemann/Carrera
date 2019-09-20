/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wilson
 */
public class UtilitariaTest {
    
    public UtilitariaTest() {
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

    /**
     * Test of random method, of class Utilitaria.
     */
    @Test
    public void testRandom() {
        System.out.println("Test Random");
        
        int result = Utilitaria.random();
        switch (result) {
            case 1:
                System.out.println("Numero generado "+result);
                assertEquals(1, result);
                break;
            case 2:
                System.out.println("Numero generado "+result);
                assertEquals(2, result);
                break;
            case 3:
                System.out.println("Numero generado "+result);
                assertEquals(3, result);
                break;
            default:
                System.out.println("Numero generado "+result);
                fail("numero fuera del rango 1-3");
                break;
        }
    }
    /**
     * Test of impresion.
     */
    @Test
    
    public void testLlegada(){
        System.out.println("Test Impresion");
        Equipo e3 = new Equipo("ECU");
        
        Persona persona = new Persona("persona8",0,60,e3);
        int resultadoAdelante = persona.avanzar(1);
        boolean valor = false;
        if(resultadoAdelante==1){
            valor = true;
        }
        if(resultadoAdelante==2){
            valor = true;
        }
        boolean resultadoEsperado = true;
        assertEquals(resultadoEsperado, valor);   
    }    
}