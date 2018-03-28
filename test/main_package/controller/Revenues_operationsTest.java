/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import java.util.List;
import main_package.model.Revenues_struct_yaml;
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
public class Revenues_operationsTest {
    
    public Revenues_operationsTest() {
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
     * Test of read_from_yaml method, of class Revenues_operations.
     */
    @Test
    public void testRead_from_yaml() {
        System.out.println("read_from_yaml");
        Revenues_operations instance = new Revenues_operations();
        instance.read_from_yaml();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write_to_yaml method, of class Revenues_operations.
     */
    @Test
    public void testWrite_to_yaml() {
        System.out.println("write_to_yaml");
        Revenues_operations instance = new Revenues_operations();
        instance.write_to_yaml();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class Revenues_operations.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Revenues_operations instance = new Revenues_operations();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevenue method, of class Revenues_operations.
     */
    @Test
    public void testGetRevenue() {
        System.out.println("getRevenue");
        int i = 0;
        Revenues_operations instance = new Revenues_operations();
        Revenues_struct_yaml expResult = null;
        Revenues_struct_yaml result = instance.getRevenue(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfRevenue method, of class Revenues_operations.
     */
    @Test
    public void testGetListOfRevenue() {
        System.out.println("getListOfRevenue");
        Revenues_operations instance = new Revenues_operations();
        List<Revenues_struct_yaml> expResult = null;
        List<Revenues_struct_yaml> result = instance.getListOfRevenue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRevenue method, of class Revenues_operations.
     */
    @Test
    public void testAddRevenue() {
        System.out.println("addRevenue");
        String date = "";
        float revenue = 0.0F;
        Revenues_operations instance = new Revenues_operations();
        instance.addRevenue(date, revenue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRevenue method, of class Revenues_operations.
     */
    @Test
    public void testDeleteRevenue() {
        System.out.println("deleteRevenue");
        int id = 0;
        Revenues_operations instance = new Revenues_operations();
        instance.deleteRevenue(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRevenue method, of class Revenues_operations.
     */
    @Test
    public void testUpdateRevenue() {
        System.out.println("updateRevenue");
        int id = 0;
        String date = "";
        float revenue = 0.0F;
        Revenues_operations instance = new Revenues_operations();
        instance.updateRevenue(id, date, revenue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
