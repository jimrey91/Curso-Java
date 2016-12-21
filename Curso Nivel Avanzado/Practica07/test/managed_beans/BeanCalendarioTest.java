/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managed_beans;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class BeanCalendarioTest {
    
    public BeanCalendarioTest() {
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
     * Test of getFechaCalendario method, of class BeanCalendario.
     */
    @Test
    public void testGetFechaCalendario() {
        System.out.println("getFechaCalendario");
        BeanCalendario instance = new BeanCalendario();
        Date expResult = null;
        Date result = instance.getFechaCalendario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaCalendario method, of class BeanCalendario.
     */
    @Test
    public void testSetFechaCalendario() {
        System.out.println("setFechaCalendario");
        Date fechaCalendario = null;
        BeanCalendario instance = new BeanCalendario();
        instance.setFechaCalendario(fechaCalendario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarDatos method, of class BeanCalendario.
     */
    @Test
    public void testLimpiarDatos() {
        System.out.println("limpiarDatos");
        BeanCalendario instance = new BeanCalendario();
        instance.limpiarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarDatos method, of class BeanCalendario.
     */
    @Test
    public void testGuardarDatos() {
        System.out.println("guardarDatos");
        BeanCalendario instance = new BeanCalendario();
        instance.guardarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
