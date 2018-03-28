/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.calculate_profits;

import main_package.model.AdditionalFinance_struct_yaml;
import main_package.model.Charges_struct_yaml;
import main_package.model.Costs_struct_yaml;
import main_package.model.Employees_struct_yaml;
import main_package.model.Investments_struct_yaml;
import main_package.model.Revenues_struct_yaml;
import main_package.controller.AdditionalFinance_operations;
import main_package.controller.Charges_operations;
import main_package.controller.CostsOperationsController;
import main_package.controller.Employees_operations_yaml;
import main_package.controller.Investments_operations;
import main_package.controller.Revenues_operations;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class CalculateProfits {
    private final Employees_operations_yaml employees;
    private final Charges_operations charges;
    private final Investments_operations investments;
    private final Revenues_operations revenues;
    private final CostsOperationsController costs;   
    private final AdditionalFinance_operations finance; 
    private List<Employees_struct_yaml> listOfEmployees;
    private List<Charges_struct_yaml> listOfCharges;
    private List<Investments_struct_yaml> listOfInvestments;
    private List<Revenues_struct_yaml> listOfRevenues;
    private List<Costs_struct_yaml> listOfCosts;
    private List<AdditionalFinance_struct_yaml> listOfFinance; 
    
    public CalculateProfits(){
        employees = new Employees_operations_yaml();       
        charges = new Charges_operations();    
        investments = new Investments_operations();    
        revenues = new Revenues_operations();    
        costs = new CostsOperationsController();       
        finance = new AdditionalFinance_operations();       
    }
    
    public float calculateProfits(){
        employees.read_from_yaml();
        listOfEmployees = employees.getEmployees();
        charges.read_from_yaml();
        listOfCharges = charges.getCharges();
        investments.read_from_yaml();
        listOfInvestments = investments.getInvestments();
        revenues.read_from_yaml();
        listOfRevenues = revenues.getListOfRevenue();
        costs.read_from_yaml();
        listOfCosts = costs.getCosts();
        finance.read_from_yaml();
        listOfFinance = finance.getAdditionalFinance();
        float temp_costs = 0;
        float temp_revenue;
        Revenues_struct_yaml revenue = listOfRevenues.get(listOfRevenues.size()-1);
        System.out.println(revenue);
        temp_revenue = revenue.getRevenue();
        for (int i=0; i<listOfCosts.size(); i++){        //podstawa opadatowania    
            if ("Koszty własne".equals(listOfCosts.get(i).getType()) && "Koszty uzyskania dochodu".equals(listOfCosts.get(i).getTitle())){
                temp_revenue -= listOfCosts.get(i).getCost();
                break;
            }
        }
        
        for (int i=0; i<listOfCosts.size(); i++){   //obliczenie podatku
            if ("Koszty własne".equals(listOfCosts.get(i).getType()) && "Podatek".equals(listOfCosts.get(i).getTitle())){
                temp_revenue *= (listOfCosts.get(i).getCost()/100);
                break;
            }
        }
        
        float tmp_podstawa = 0;
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            if ("Podstawa do obliczenia składek".equals(cost.getType()) && "Przeciętne wynagrodzenie w sektorze przedsiębiorstw".equals(cost.getTitle())){
                tmp_podstawa = ((float)(0.75*cost.getCost()));
                break;
            }
        }
        float odlicz_składkę = 0;
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            if ("Koszty własne".equals(cost.getType()) && "Odliczenie składki zdrowotnej od podatku".equals(cost.getTitle())){
                odlicz_składkę = cost.getCost()/100*tmp_podstawa;
                break;
            }
        }
        temp_revenue -= odlicz_składkę;
       
        
        float składka_zdrowotna = 0;
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            if ("Koszty własne".equals(cost.getType()) && "Składki na ubezpieczenia zdrowotne (procent od podstawy)".equals(cost.getTitle())){
                składka_zdrowotna = cost.getCost()/100*tmp_podstawa;
                break;
            }
        }
        temp_costs += składka_zdrowotna;
        temp_costs += temp_revenue;  //dodajemy podatek z odliczoną składką na ubezpieczenie zdrowotne
        temp_revenue = revenue.getRevenue();
        
        
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            if ("Podstawa do obliczenia składek".equals(cost.getType()) && "Prognozowane średnie wynagrodzenie".equals(cost.getTitle())){
                tmp_podstawa = ((float)(0.6*cost.getCost()));
                break;
            }
        }
        
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            if ("Koszty własne".equals(cost.getType()) && "Składki na ubezpieczenia społeczne (procent od podstawy)".equals(cost.getTitle())){
                temp_costs += cost.getCost()/100*tmp_podstawa;
                break;
            }
        }
        
        for (int i=0; i<listOfCosts.size(); i++){
            Costs_struct_yaml cost = listOfCosts.get(i);
            //System.out.println(cost.getCost());
            if ("Koszty własne".equals(cost.getType()) && "Fundusz Pracy (procent od podstawy)".equals(cost.getTitle())){
                temp_costs += cost.getCost()/100*tmp_podstawa;
                break;
            }
        }
        
        for (int i=0; i<listOfEmployees.size(); i++){
            Employees_struct_yaml employee = listOfEmployees.get(i);
            float tmp_cost_salary = 0;
            switch(employee.getType()){
                case "Praca":                   
                    for (int j=0; j<listOfCosts.size(); j++){                        
                        Costs_struct_yaml cost = listOfCosts.get(j);
                        if ("Praca".equals(cost.getType())){
                            tmp_cost_salary += employee.getSalary()*(cost.getCost()/100);
                        }
                    }
                    tmp_cost_salary += employee.getSalary();
                    break;
                case "Zlecenie":
                    for (int j=0; j<listOfCosts.size(); j++){                        
                        Costs_struct_yaml cost = listOfCosts.get(j);
                        if ("Zlecenie".equals(cost.getType())){
                            tmp_cost_salary += employee.getSalary()*(cost.getCost()/100);
                        }
                    }
                    tmp_cost_salary += employee.getSalary();
                    break;
                default:
                    tmp_cost_salary = employee.getSalary();
            }
            temp_costs += tmp_cost_salary;
        }
        for (int i=0; i<listOfCharges.size(); i++){
            Charges_struct_yaml charge = listOfCharges.get(i);
            temp_costs += charge.getCost();
        }
        for (int i=0; i<listOfInvestments.size(); i++){
            Investments_struct_yaml investment = listOfInvestments.get(i);
            temp_costs += investment.getCost();
        }
        
        for (int i=0; i<listOfFinance.size(); i++){
            AdditionalFinance_struct_yaml finance_ = listOfFinance.get(i);
            temp_costs -= finance_.getMoney();
        }
        
        return temp_revenue - temp_costs;
    }
}


