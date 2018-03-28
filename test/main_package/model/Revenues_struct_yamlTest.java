/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.model;

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
public class Revenues_struct_yamlTest {
    
    public Revenues_struct_yamlTest() {
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
     * Test of getDate method, of class Revenues_struct_yaml.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Revenues_struct_yaml instance = new Revenues_struct_yaml("01-2017",20000);
        String expResult = "01-2017";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRevenue method, of class Revenues_struct_yaml.
     */
    @Test
    public void testGetRevenue() {
        System.out.println("getRevenue");
        Revenues_struct_yaml instance = new Revenues_struct_yaml("01-2017",20000);
        float expResult = 20000F;
        float result = instance.getRevenue();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
