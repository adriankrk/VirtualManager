/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

import main_package.controller.AdditionalFinance_operations;

/**
 *
 * @author Adrian
 */
public class ReadWrite_from_yaml_AdditionalFinance extends Threads_main_class{
    AdditionalFinance_operations finance;
    
    public ReadWrite_from_yaml_AdditionalFinance(String name, AdditionalFinance_operations finance) {
        this.finance = finance;
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
                        finance.read_from_yaml(); 
                        //System.out.println(licz);
                    }
                    finance.write_to_yaml();
                    Thread.sleep(1000);
                    licz++;
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
}
