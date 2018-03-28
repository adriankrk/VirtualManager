/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.threads_;

import main_package.calculate_profits.CalculateProfits;

/**
 *
 * @author Adrian
 */
public class Read_And_Calculate_Profit extends Threads_main_class{
    CalculateProfits prediction_profit;
    private javax.swing.JLabel label;
    
    public Read_And_Calculate_Profit(String name, javax.swing.JLabel label) {
        this.prediction_profit = new CalculateProfits();
        this.label = label;
        threadName = name;
        System.out.println("Creating " +  threadName );
    }
    
    @Override
    public void run() {
            System.out.println("Running " +  threadName );
            try {
                while(running) {  
                    Thread.sleep(500);
                    label.setText(String.format("%.2f",prediction_profit.calculateProfits())); 
                }
            }catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            System.out.println("Thread " +  threadName + " exiting.");
        }
}
