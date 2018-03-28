/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

import main_package.controller.Investments_operations;

/**
 *
 * @author Adrian
 */
public class ReadWrite_from_yaml_Investments extends Threads_main_class{
    Investments_operations investments;
    
    public ReadWrite_from_yaml_Investments(String name,Investments_operations investments) {
        this.investments = investments;
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
                        investments.read_from_yaml(); 
                        //System.out.println(licz);
                    }
                    investments.write_to_yaml();
                    Thread.sleep(1000);
                    licz++;
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
}
