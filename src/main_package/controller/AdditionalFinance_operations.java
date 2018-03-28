/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.AdditionalFinance_struct_yaml;
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
public class AdditionalFinance_operations implements Interface_yaml{
    private final List<AdditionalFinance_struct_yaml> ListOfFinance;
    private final String file;
    
    public AdditionalFinance_operations(){     
        this.ListOfFinance = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\additionalfinance.yml";
        file = path;
    }
    
    @Override
    public synchronized void read_from_yaml(){
        try{
            ListOfFinance.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Type"));
                AdditionalFinance_struct_yaml one_ = new AdditionalFinance_struct_yaml((String)map.get("Type"), Integer.parseInt((String)map.get("Money")));
                ListOfFinance.add(one_);
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
            for (int i=0; i<ListOfFinance.size();i++)
            {
                AdditionalFinance_struct_yaml one_;
                one_ = ListOfFinance.get(i);
                writer.println("---");
                writer.println("Type:" + ' ' + one_.getType());
                writer.println("Money:" + ' ' + one_.getMoney());
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
        return ListOfFinance.size();
    }
    
    public AdditionalFinance_struct_yaml getOneAdditionalFinance(int i){
        return ListOfFinance.get(i);
    }
    
    public List<AdditionalFinance_struct_yaml> getAdditionalFinance(){
        return ListOfFinance;
    }
    
    public void addOneAdditionalFinance(String type, int money){
        AdditionalFinance_struct_yaml one_investment = new AdditionalFinance_struct_yaml(type, money);
        ListOfFinance.add(one_investment);
    }
    
    public void deleteOneAdditionalFinance(int id){
        ListOfFinance.remove(id);
    }

    public void updateOneAdditionalFinance(int id, String type, int money){
        AdditionalFinance_struct_yaml one_ = new AdditionalFinance_struct_yaml(type, money);
        ListOfFinance.set(id, one_);
    }
}
