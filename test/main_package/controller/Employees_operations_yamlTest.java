/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import java.util.List;
import main_package.model.Employees_struct_yaml;
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
public class Employees_operations_yamlTest {
    
    public Employees_operations_yamlTest() {
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
     * Test of read_from_yaml method, of class Employees_operations_yaml.
     */
    @Test
    public void testRead_from_yaml() {
        System.out.println("read_from_yaml");
        Employees_operations_yaml instance = new Employees_operations_yaml();
        instance.read_from_yaml();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write_to_yaml method, of class Employees_operations_yaml.
     */
    @Test
    public void testWrite_to_yaml() {
        System.out.println("write_to_yaml");
        Employees_operations_yaml instance = new Employees_operations_yaml();
        instance.write_to_yaml();
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class Employees_operations_yaml.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        Employees_operations_yaml instance = new Employees_operations_yaml();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class Employees_operations_yaml.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        int i = 0;
        Employees_operations_yaml instance = new Employees_operations_yaml();
        Employees_struct_yaml expResult = null;
        Employees_struct_yaml result = instance.getEmployee(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployees method, of class Employees_operations_yaml.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        Employees_operations_yaml instance = new Employees_operations_yaml();
        List<Employees_struct_yaml> expResult = null;
        List<Employees_struct_yaml> result = instance.getEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployee method, of class Employees_operations_yaml.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        String name = "";
        String surname = "";
        int salary = 0;
        String type = "";
        Employees_operations_yaml instance = new Employees_operations_yaml();
        instance.addEmployee(name, surname, salary, type);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployee method, of class Employees_operations_yaml.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        int id = 0;
        Employees_operations_yaml instance = new Employees_operations_yaml();
        instance.deleteEmployee(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class Employees_operations_yaml.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("updateEmployee");
        int id = 0;
        String name = "";
        String surname = "";
        int salary = 0;
        String type = "";
        Employees_operations_yaml instance = new Employees_operations_yaml();
        instance.updateEmployee(id, name, surname, salary, type);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
