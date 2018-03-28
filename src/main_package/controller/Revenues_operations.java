/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.controller;

import main_package.model.Revenues_struct_yaml;
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
import javax.swing.JOptionPane;
import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;

/**
 *
 * @author Adrian
 */
public class Revenues_operations implements Interface_yaml{
    private final List<Revenues_struct_yaml> revenues;
    private final String file;
    
    public Revenues_operations(){     
        this.revenues = new ArrayList<>();
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        path += "\\src\\main_package\\model\\src\\revenues.yml";
        file = path;
    }
    
    @Override
    public synchronized void read_from_yaml(){
        try{
            revenues.clear();
            YamlReader reader = new YamlReader(new FileReader(file));
            while (true){
                Object object = reader.read();
                if (object == null) break;
                Map map = (Map)object;
                //System.out.println(map.get("Type"));
                Revenues_struct_yaml one_revenue = new Revenues_struct_yaml((String)map.get("Month"), Float.parseFloat((String)map.get("Revenue")));
                revenues.add(one_revenue);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Błąd odczytu pliku! Brak pliku z danymi", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Revenues_operations.class.getName()).log(Level.SEVERE, null, e);
        } 
        catch (YamlException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Błąd odczytu pliku!", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Revenues_operations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public synchronized void write_to_yaml(){
       try{
            PrintWriter writer;
            writer = new PrintWriter(file, "UTF-8");
            writer.print("");
            for (int i=0; i<revenues.size();i++)
            {
                Revenues_struct_yaml one_revenue;
                one_revenue = revenues.get(i);
                writer.println("---");
                writer.println("Month:" + ' ' + one_revenue.getDate());
                writer.println("Revenue:" + ' ' + one_revenue.getRevenue());
            }
            writer.close();
        } 
       catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Błąd zapisu pliku!", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Revenues_operations.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    @Override
    public int getCount(){
        return revenues.size();
    }
    
    public Revenues_struct_yaml getRevenue(int i){
        return revenues.get(i);
    }
    
    public List<Revenues_struct_yaml> getListOfRevenue(){
       return revenues;
    }
    
    public void addRevenue(String date, float revenue){
        Revenues_struct_yaml one_revenue = new Revenues_struct_yaml(date, revenue);
        revenues.add(one_revenue);
    }
    
    public void deleteRevenue(int id){
        revenues.remove(id);
    }

    public void updateRevenue(int id, String date, float revenue){
        Revenues_struct_yaml one_revenue = new Revenues_struct_yaml(date, revenue);
        revenues.set(id, one_revenue);
    }
}
