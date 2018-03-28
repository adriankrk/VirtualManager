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
public class Charges_struct_yaml {
    private final String Type;
    private final int Cost;
    
    public Charges_struct_yaml(String Type, int Cost) {
        this.Type=Type;
        this.Cost=Cost;
    }
    
    public String getType(){
        return this.Type;
    }
    
    public int getCost(){
        return this.Cost;
    }
}
