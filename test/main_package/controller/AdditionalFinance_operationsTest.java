/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import java.util.List;
import main_package.model.AdditionalFinance_struct_yaml;
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
public class AdditionalFinance_operationsTest {
    
    public AdditionalFinance_operationsTest() {
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
     * Test of read_from_yaml method, of class AdditionalFinance_operations.
     */
    @Test
    public void testRead_from_yaml() {
        System.out.println("read_from_yaml");
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        instance.read_from_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write_to_yaml method, of class AdditionalFinance_operations.
     */
    @Test
    public void testWrite_to_yaml() {
        System.out.println("write_to_yaml");
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        instance.write_to_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class AdditionalFinance_operations.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOneAdditionalFinance method, of class AdditionalFinance_operations.
     */
    @Test
    public void testGetOneAdditionalFinance() {
        System.out.println("getOneAdditionalFinance");
        int i = 0;
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        AdditionalFinance_struct_yaml expResult = null;
        AdditionalFinance_struct_yaml result = instance.getOneAdditionalFinance(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAdditionalFinance method, of class AdditionalFinance_operations.
     */
    @Test
    public void testGetAdditionalFinance() {
        System.out.println("getAdditionalFinance");
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        String type = "sdsd";
        int money = 10;
        instance.addOneAdditionalFinance(type, money);
        List<AdditionalFinance_struct_yaml> result = instance.getAdditionalFinance();
        int expResult = 10;
        assertEquals(expResult, result.get(0).getMoney());
        assertEquals("sdsd", result.get(0).getType());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addOneAdditionalFinance method, of class AdditionalFinance_operations.
     */
    @Test
    public void testAddOneAdditionalFinance() {
        System.out.println("addOneAdditionalFinance");
        String type = "";
        int money = 0;
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        instance.addOneAdditionalFinance(type, money);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteOneAdditionalFinance method, of class AdditionalFinance_operations.
     */
    @Test
    public void testDeleteOneAdditionalFinance() {
        System.out.println("deleteOneAdditionalFinance");
        int id = 0;
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        instance.deleteOneAdditionalFinance(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateOneAdditionalFinance method, of class AdditionalFinance_operations.
     */
    @Test
    public void testUpdateOneAdditionalFinance() {
        System.out.println("updateOneAdditionalFinance");
        int id = 0;
        String type = "";
        int money = 0;
        AdditionalFinance_operations instance = new AdditionalFinance_operations();
        instance.updateOneAdditionalFinance(id, type, money);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
