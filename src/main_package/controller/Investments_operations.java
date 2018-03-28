/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.Investments_struct_yaml;
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
public class Investments_operations implements Interface_yaml{
    private final List<Investments_struct_yaml> investments;
    private final String file;
    
    public Investments_operations(){     
        this.investments = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\investments.yml";
        file = path;
    }
    
    @Override
    public synchronized void read_from_yaml(){
        try{
            investments.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Type"));
                Investments_struct_yaml one_investment = new Investments_struct_yaml((String)map.get("Type"), Integer.parseInt((String)map.get("Cost")));
                investments.add(one_investment);
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
            for (int i=0; i<investments.size();i++)
            {
                Investments_struct_yaml one_investment;
                one_investment = investments.get(i);
                writer.println("---");
                writer.println("Type:" + ' ' + one_investment.getType());
                writer.println("Cost:" + ' ' + one_investment.getCost());
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
        return investments.size();
    }
    
    public Investments_struct_yaml getInvestment(int i){
        return investments.get(i);
    }
    
    public List<Investments_struct_yaml> getInvestments(){
        return investments;
    }
    
    public void addInvestment(String type, int cost){
        Investments_struct_yaml one_investment = new Investments_struct_yaml(type, cost);
        investments.add(one_investment);
    }
    
    public void deleteInvestment(int id){
        investments.remove(id);
    }

    public void updateInvestment(int id, String type, int cost){
        Investments_struct_yaml one_investment = new Investments_struct_yaml(type, cost);
        investments.set(id, one_investment);
    }
}
