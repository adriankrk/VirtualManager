/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.Costs_struct_yaml;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;

/**
 *
 * @author Adrian
 */
public class CostsOperationsController implements Interface_yaml{
    private final List<Costs_struct_yaml> costs;
    private final Lock _mutex;  
    private final String file; //= "C:\\Users\\Adrian\\Documents\\NetBeansProjects\\Projekt\\src\\yaml_model_\\src\\costs.yml";
    
    public CostsOperationsController(){     
        this.costs = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\costs.yml";
        file = path;
        _mutex = new ReentrantLock(true);
    }
    
    @Override
    public synchronized void read_from_yaml(){      
        try{
            //_mutex.lock();
            costs.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Type"));
                Costs_struct_yaml one_cost = new Costs_struct_yaml((String)map.get("Type"), (String)map.get("Title"), Float.parseFloat((String)map.get("Cost")));
                costs.add(one_cost);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Brak pliku");
            Logger.getLogger(CostsOperationsController.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (YamlException | IOException ex) {
            Logger.getLogger(CostsOperationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*finally{
           _mutex.unlock();
        /*finally{
           _mutex.unlock();
        }*/
    }
    
    @Override
    public synchronized void write_to_yaml(){      
       try{
            //_mutex.lock();
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.print("");
            for (int i=0; i<costs.size();i++)
            {
                Costs_struct_yaml one_cost;
                one_cost = costs.get(i);
                writer.println("---");
                writer.println("Type:" + ' ' + one_cost.getType());
                writer.println("Title:" + ' ' + one_cost.getTitle());
                writer.println("Cost:" + ' ' + one_cost.getCost());
            }
            writer.close();
        } 
       catch (IOException ex) {
            Logger.getLogger(CostsOperationsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       /*finally{
           _mutex.unlock(); 
       /*finally{
           _mutex.unlock();
        }*/
       
    }
    
    @Override
    public int getCount(){
        return costs.size();
    }
    
    public Costs_struct_yaml getCost(int i){
        return costs.get(i);
    }
    
    public List<Costs_struct_yaml> getCosts(){
        return costs;
    }
    
    public void addCost(String type, String title, float cost){
        Costs_struct_yaml one_cost = new Costs_struct_yaml(type, title, cost);
        costs.add(one_cost);
    }
    
    public void deleteCost(int id){
        costs.remove(id);
    }

    public void updateCost(int id, String type, String title, float cost){
        Costs_struct_yaml one_cost = new Costs_struct_yaml(type, title, cost);
        costs.set(id, one_cost);
    }
}
