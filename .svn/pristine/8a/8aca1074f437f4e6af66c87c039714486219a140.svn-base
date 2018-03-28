/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import java.util.List;
import main_package.model.Costs_struct_yaml;
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
public class CostsOperationsControllerTest {
    
    public CostsOperationsControllerTest() {
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
     * Test of read_from_yaml method, of class Costs_Operations.
     */
    @Test
    public void testRead_from_yaml() {
        System.out.println("read_from_yaml");
        CostsOperationsController instance = new CostsOperationsController();
        instance.read_from_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write_to_yaml method, of class Costs_Operations.
     */
    @Test
    public void testWrite_to_yaml() {
        System.out.println("write_to_yaml");
        CostsOperationsController instance = new CostsOperationsController();
        instance.write_to_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class Costs_Operations.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        CostsOperationsController instance = new CostsOperationsController();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCost method, of class Costs_Operations.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        int i = 0;
        CostsOperationsController instance = new CostsOperationsController();
        instance.addCost("XY", "xy", 20);
        float expResult = 20f;
        Costs_struct_yaml result = instance.getCost(i);
        float res = result.getCost();
        assertEquals(expResult, res, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCosts method, of class Costs_Operations.
     */
    @Test
    public void testGetCosts() {
        System.out.println("getCosts");
        CostsOperationsController instance = new CostsOperationsController();
        List<Costs_struct_yaml> expResult = null;
        List<Costs_struct_yaml> result = instance.getCosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of addCost method, of class Costs_Operations.
     */
    @Test
    public void testAddCost() {
        System.out.println("addCost");
        String type = "";
        String title = "";
        float cost = 0.0F;
        CostsOperationsController instance = new CostsOperationsController();
        instance.addCost(type, title, cost);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCost method, of class Costs_Operations.
     */
    @Test
    public void testDeleteCost() {
        System.out.println("deleteCost");
        int id = 0;
        CostsOperationsController instance = new CostsOperationsController();
        instance.deleteCost(id);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of updateCost method, of class Costs_Operations.
     */
    @Test
    public void testUpdateCost() {
        System.out.println("updateCost");
        int id = 0;
        String type = "";
        String title = "";
        float cost = 0.0F;
        CostsOperationsController instance = new CostsOperationsController();
        instance.updateCost(id, type, title, cost);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
