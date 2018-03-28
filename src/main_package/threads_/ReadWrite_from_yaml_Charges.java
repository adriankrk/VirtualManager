/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

import main_package.controller.Charges_operations;

/**
 *
 * @author Adrian
 */
public class ReadWrite_from_yaml_Charges extends Threads_main_class{
    
        Charges_operations charges;
            
        public ReadWrite_from_yaml_Charges(String name,Charges_operations charges) {
            this.charges = charges;
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
                        charges.read_from_yaml(); 
                        //System.out.println(licz);
                    }
                    charges.write_to_yaml();
                    Thread.sleep(500);
                    licz++;
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }        
}
