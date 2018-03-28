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
public class Revenues_struct_yaml {
    private final String Date;
    private final float Revenue;
    
    public Revenues_struct_yaml(String Date, float Revenue){
        this.Date = Date;
        this.Revenue = Revenue;
    }
    
    public String getDate(){
        return this.Date;
    }
    
    public float getRevenue(){
        return this.Revenue;
    }
    
}
