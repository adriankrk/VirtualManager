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
public class Employees_struct_yamlTest {
    
    public Employees_struct_yamlTest() {
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
     * Test of getName method, of class Employees_struct_yaml.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employees_struct_yaml instance = new Employees_struct_yaml("Jan", "Janek", 2000, "Praca");
        String expResult = "Jan";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSurname method, of class Employees_struct_yaml.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Employees_struct_yaml instance = new Employees_struct_yaml("Jan", "Janek", 2000, "Praca");
        String expResult = "Janek";
        String result = instance.getSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSalary method, of class Employees_struct_yaml.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Employees_struct_yaml instance = new Employees_struct_yaml("Jan", "Janek", 2000, "Praca");
        int expResult = 2000;
        int result = instance.getSalary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Employees_struct_yaml.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Employees_struct_yaml instance = new Employees_struct_yaml("Jan", "Janek", 2000, "Praca");
        String expResult = "Praca";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
