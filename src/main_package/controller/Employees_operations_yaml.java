/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.Employees_struct_yaml;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
/**
 *
 * @author Adrian
 */

public class Employees_operations_yaml implements Interface_yaml{
    private final List<Employees_struct_yaml> employees;
    private final String file;
    
    public Employees_operations_yaml(){     
        this.employees = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\employee.yml";
        file = path;
    }    
    
    @Override
    public synchronized void read_from_yaml(){
        try{
            employees.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Name"));
                Employees_struct_yaml one_employee = new Employees_struct_yaml((String)map.get("Name"), (String)map.get("Surname"), Integer.parseInt((String)map.get("Salary")), (String)map.get("Type"));
                employees.add(one_employee);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Brak pliku");
        } 
        catch (YamlException | IOException ex) {
            Logger.getLogger(Employees_operations_yaml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public synchronized void write_to_yaml(){
       try{
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print("");
            for (int i=0; i<employees.size();i++)
            {
                Employees_struct_yaml one_employee;
                one_employee = employees.get(i);
                writer.println("---");
                writer.println("Name:" + ' ' + one_employee.getName());
                writer.println("Surname:" + ' ' + one_employee.getSurname());
                writer.println("Salary:" + ' ' + one_employee.getSalary());
                writer.println("Type: " + one_employee.getType());
            }
            writer.close();
        } 
       catch (IOException ex) {
            Logger.getLogger(Employees_operations_yaml.class.getName()).log(Level.SEVERE, null, ex);
        }  
       /*catch (YamlException ex) {
            Logger.getLogger(Employees_class_yaml.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    @Override
    public int getCount(){
        return employees.size();
    }
    
    public Employees_struct_yaml getEmployee(int i){
        return employees.get(i);
    }
    
    public List<Employees_struct_yaml> getEmployees(){
        return employees;
    }
    
    public void addEmployee(String name, String surname, int salary, String type){
        Employees_struct_yaml one_employee = new Employees_struct_yaml(name, surname, salary, type);
        employees.add(one_employee);
    }
    
    public void deleteEmployee(int id){
        try{
            employees.remove(id);
        }
        catch (IndexOutOfBoundsException e)
        {}
    }

    public void updateEmployee(int id, String name, String surname, int salary, String type){
        Employees_struct_yaml one_employee = new Employees_struct_yaml(name, surname, salary, type);
        employees.set(id, one_employee);
    }
    
    
}
