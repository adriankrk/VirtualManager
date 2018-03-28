/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.model;

/**
 *
 * @author Adrian
 */

public class Employees_struct_yaml{
    private final String Name;
    private final String Surname;
    private final int Salary;
    private final String Type;
    
    public Employees_struct_yaml(String Name, String Surname, int Salary, String Type){
        this.Name = Name;
        this.Surname = Surname;
        this.Salary = Salary;
        this.Type = Type;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public String getSurname(){
        return this.Surname;
    }
    
    public int getSalary(){
        return this.Salary;
    }
    
    public String getType(){
        return this.Type;
    }
}

