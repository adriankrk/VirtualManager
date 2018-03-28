/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.Charges_struct_yaml;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;

/**
 *
 * @author Adrian
 */
public class Charges_operations implements Interface_yaml {
    private List<Charges_struct_yaml> charges;
    private final String file;
    //private List<Charges_struct_yaml> employees_to_read;
    
    public Charges_operations(){     
        this.charges = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\charges.yml";
        file = path;
    }  
    
    @Override
    public synchronized void read_from_yaml(){
        try{
            charges.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Type"));
                Charges_struct_yaml one_charge = new Charges_struct_yaml((String)map.get("Type"), Integer.parseInt((String)map.get("Cost")));
                charges.add(one_charge);
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
            for (int i=0; i<charges.size();i++)
            {
                Charges_struct_yaml one_charge;
                one_charge = charges.get(i);
                writer.println("---");
                writer.println("Type:" + ' ' + one_charge.getType());
                writer.println("Cost:" + ' ' + one_charge.getCost());
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
        return charges.size();
    }
    
    public Charges_struct_yaml getCharge(int i){
        return charges.get(i);
    }
    
    public List<Charges_struct_yaml> getCharges(){
        return charges;
    }
    
    public void addCharge(String type, int cost){
        Charges_struct_yaml one_charge = new Charges_struct_yaml(type, cost);
        charges.add(one_charge);
    }
    
    public void deleteCharge(int id){
        charges.remove(id);
    }

    public void updateCharge(int id, String type, int cost){
        Charges_struct_yaml one_charge = new Charges_struct_yaml(type, cost);
        charges.set(id, one_charge);
    }
}
