/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import java.util.List;
import main_package.model.Charges_struct_yaml;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian
 */
public class Charges_operationsTest {
    
    public Charges_operationsTest() {
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
     * Test of read_from_yaml method, of class Charges_operations.
     */
    @Test
    public void testRead_from_yaml() {
        System.out.println("read_from_yaml");
        Charges_operations instance = new Charges_operations();
        instance.read_from_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write_to_yaml method, of class Charges_operations.
     */
    @Test
    public void testWrite_to_yaml() {
        System.out.println("write_to_yaml");
        Charges_operations instance = new Charges_operations();
        instance.write_to_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class Charges_operations.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Charges_operations instance = new Charges_operations();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCharge method, of class Charges_operations.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
        int i = 0;
        Charges_operations instance = new Charges_operations();
        Charges_struct_yaml expResult = null;
        Charges_struct_yaml result = instance.getCharge(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCharges method, of class Charges_operations.
     */
    @Test
    public void testGetCharges() {
        System.out.println("getCharges");
        Charges_operations instance = new Charges_operations();
        List<Charges_struct_yaml> expResult = null;
        List<Charges_struct_yaml> result = instance.getCharges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addCharge method, of class Charges_operations.
     */
    @Test
    public void testAddCharge() {
        System.out.println("addCharge");
        String type = "";
        int cost = 0;
        Charges_operations instance = new Charges_operations();
        instance.addCharge(type, cost);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCharge method, of class Charges_operations.
     */
    @Test
    public void testDeleteCharge() {
        System.out.println("deleteCharge");
        int id = 0;
        Charges_operations instance = new Charges_operations();
        instance.deleteCharge(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateCharge method, of class Charges_operations.
     */
    @Test
    public void testUpdateCharge() {
        System.out.println("updateCharge");
        int id = 0;
        String type = "";
        int cost = 0;
        Charges_operations instance = new Charges_operations();
        instance.updateCharge(id, type, cost);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
