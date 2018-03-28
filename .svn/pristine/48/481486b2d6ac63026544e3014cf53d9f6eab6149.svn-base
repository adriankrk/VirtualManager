/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

import main_package.controller.Employees_operations_yaml;

/**
 *
 * @author Adrian
 */
public class ReadWrite_from_yaml_Employees extends Threads_main_class {
    
        Employees_operations_yaml employees;

        public ReadWrite_from_yaml_Employees(String name,Employees_operations_yaml employees) {
            this.employees = employees;
            threadName = name;
            System.out.println("Creating " +  threadName );
        }
        
        @Override
        public void run() {
            System.out.println("Running " +  threadName );
            try {
                int licz=0;
                while(running) {                   
                    if (licz==0) {
                        employees.read_from_yaml(); 
                        //employees.copy_employees_from_reader_to_writer();
                        System.out.println(licz);
                    }
                    employees.write_to_yaml();
                    Thread.sleep(1000);
                    licz++;
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
   

    }
