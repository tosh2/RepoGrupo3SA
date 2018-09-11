/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denis
 */
public class ConsultarMesaTest {
    
    public ConsultarMesaTest() {
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
     * Test of ConsultarMesaPorDPI method, of class ConsultarMesa.
     */
    @Test
    public void testConsultarMesaPorDPI() throws Exception {
        System.out.println("ConsultarMesaPorDPI");
        String _DPI = "123456789987456";
        ConsultarMesa instance = new ConsultarMesa();
        String expResult = "[{\"NombreDepartamento\":\"Guatemala\",\"NombreMunicipio\":\"Mixco\",\"DireccionCentroVotacion\":\"Zona1 de Mixco\",\"Descripcion\":\"Centro de de Votacion # 75\",\"NoEmpadronamiento\":\"123456\",\"DPI\":\"123456789987456\",\"Nombre\":\"Denis\",\"Apellido\":\"Morales\"}]";
        String result = instance.ConsultarMesaPorDPI(_DPI);
        assertEquals(expResult, result);
        if(!result.equals(expResult)){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of ConsultarMesaPorPadron method, of class ConsultarMesa.
     */
    @Test
    public void testConsultarMesaPorPadron_String() throws Exception {
        System.out.println("ConsultarMesaPorPadron");
        String _NoPadron = "123456";
        ConsultarMesa instance = new ConsultarMesa();
        String expResult = "[{\"NombreDepartamento\":\"Guatemala\",\"NombreMunicipio\":\"Mixco\",\"DireccionCentroVotacion\":\"Zona1 de Mixco\",\"Descripcion\":\"Centro de de Votacion # 75\",\"NoEmpadronamiento\":\"123456\",\"DPI\":\"123456789987456\",\"Nombre\":\"Denis\",\"Apellido\":\"Morales\"}]";
        String result = instance.ConsultarMesaPorPadron(_NoPadron);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        }
    }

    /**
     * Test of ConsultarMesaPorPadron method, of class ConsultarMesa.
     */
    @Test
    public void testConsultarMesaPorPadron_0args() throws Exception {
        System.out.println("ConsultarMesaPorPadron");
        ConsultarMesa instance = new ConsultarMesa();
        String expResult = "";
        String result = instance.ConsultarMesaPorPadron();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
