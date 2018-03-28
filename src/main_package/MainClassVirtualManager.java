/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import javax.swing.table.DefaultTableModel;
import main_package.controller.AdditionalFinance_operations;
import main_package.controller.Charges_operations;
import main_package.controller.CostsOperationsController;
import main_package.controller.Employees_operations_yaml;
import main_package.controller.Investments_operations;
import main_package.controller.Revenues_operations;
import main_package.model.AdditionalFinance_struct_yaml;
import main_package.model.Charges_struct_yaml;
import main_package.model.Costs_struct_yaml;
import main_package.model.Employees_struct_yaml;
import main_package.model.Investments_struct_yaml;
import main_package.model.Revenues_struct_yaml;
import main_package.threads_.ReadWrite_from_yaml_AdditionalFinance;
import main_package.threads_.ReadWrite_from_yaml_Charges;
import main_package.threads_.ReadWrite_from_yaml_Costs;
import main_package.threads_.ReadWrite_from_yaml_Employees;
import main_package.threads_.ReadWrite_from_yaml_Investments;
import main_package.threads_.ReadWrite_from_yaml_Revenues;
import main_package.threads_.Read_And_Calculate_Profit;
import main_package.threads_.Threads_main_class;
import org.javatuples.Pair;
import org.javatuples.Triplet;

/**
 *
 * @author Adrian
 */
public class MainClassVirtualManager implements MainInterface, EmployeesInterface, CostsInterface{
    private CostsOperationsController all_costs;
    private Revenues_operations all_revenues;
    private Charges_operations all_charges;
    private Investments_operations all_investments;
    private AdditionalFinance_operations all_finance;
    private Employees_operations_yaml all_employees;
    private Threads_main_class readwrite_thread;
    private Threads_main_class new_calculate_profit_thread;
    
    public MainClassVirtualManager(String type){
        System.out.println(type);
        switch(type){
            case "Costs":
                all_costs = new CostsOperationsController();               
                break;
            case "Revenues":
                all_revenues = new Revenues_operations();
                break;
            case "Charges":
                all_charges = new Charges_operations();
                break;
            case "Investments":
                all_investments = new Investments_operations();
                break;
            case "AdditionalFinance":
                all_finance = new AdditionalFinance_operations();
                break;
            case "Employees":
                all_employees = new Employees_operations_yaml();
                break;
        }
    }
    
    @Override
    public void startThreads(javax.swing.JLabel label, String type)
    {   
        switch(type){
            case "Costs":
                readwrite_thread = new ReadWrite_from_yaml_Costs("Costs", all_costs);
                readwrite_thread.start(); 
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
                break;
            case "Revenues":
                readwrite_thread = new ReadWrite_from_yaml_Revenues("Revenues", all_revenues);
                readwrite_thread.start(); 
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
                break;
            case "Charges":
                readwrite_thread = new ReadWrite_from_yaml_Charges("charges", all_charges);
                readwrite_thread.start();
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
                break;
            case "Investments":
                readwrite_thread = new ReadWrite_from_yaml_Investments("investments", all_investments);
                readwrite_thread.start();
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
                break;
            case "AdditionalFinance":
                readwrite_thread = new ReadWrite_from_yaml_AdditionalFinance("additional finance", all_finance);
                readwrite_thread.start();   
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
                break;
            case "Employees":
                readwrite_thread = new ReadWrite_from_yaml_Employees("employees", all_employees);
                readwrite_thread.start();
                new_calculate_profit_thread = new Read_And_Calculate_Profit("calculate profits", label);
                new_calculate_profit_thread.start();
        }
    }
    
    @Override
    public void terminateThreads(){
        readwrite_thread.terminate();
        new_calculate_profit_thread.terminate();
        if (all_costs != null) all_costs.write_to_yaml();
        if (all_revenues != null) all_revenues.write_to_yaml();
        if (all_charges != null) all_charges.write_to_yaml();
        if (all_investments != null) all_investments.write_to_yaml();
        if (all_finance != null) all_finance.write_to_yaml();
        if (all_employees != null) all_employees.write_to_yaml();
    }
    
    @Override
    public void add(String param1, float param2, String type){
        switch(type){
            case "Revenues":
                all_revenues.addRevenue(param1, param2);
                break;
            case "Charges":
                all_charges.addCharge(param1, (int) param2);
                break;
            case "Investments":
                all_investments.addInvestment(param1, (int) param2);
                break;
            case "AdditionalFinance":
                all_finance.addOneAdditionalFinance(param1, (int) param2);
                break;
        }
    }
    
    @Override
    public void add(String name, String surname, int salary, String type){
        all_employees.addEmployee(name, surname, salary, type);
    }
    
    @Override
    public void writeDataToTextField(int index, Triplet<javax.swing.JTextField,javax.swing.JTextField,javax.swing.JTextField> textfields, int id ){    
        Employees_struct_yaml employeeToUpdate = all_employees.getEmployee(index);
        textfields.getValue0().setText(employeeToUpdate.getName());
        textfields.getValue1().setText(employeeToUpdate.getSurname());
        textfields.getValue2().setText(Integer.toString(employeeToUpdate.getSalary()));
    }
    
    @Override
    public void writeDataToTextField(int index, Triplet<javax.swing.JLabel,javax.swing.JLabel,javax.swing.JTextField> textfields ){   
        Costs_struct_yaml costToUpdate = all_costs.getCost(index);
        textfields.getValue0().setText(costToUpdate.getType());
        textfields.getValue1().setText(costToUpdate.getTitle());
        textfields.getValue2().setText(Float.toString(costToUpdate.getCost()));       
    }
    
    @Override
    public void writeDataToTextField(int index, String type, Pair<javax.swing.JTextField,javax.swing.JTextField> textfields ){
        switch(type){
            case "Revenues":
                Revenues_struct_yaml revenueToUpdate = all_revenues.getRevenue(index);
                textfields.getValue0().setText(revenueToUpdate.getDate());
                textfields.getValue1().setText(Float.toString(revenueToUpdate.getRevenue()));
                break;
            case "Charges":
                Charges_struct_yaml chargeToUpdate = all_charges.getCharge(index);
                textfields.getValue0().setText(chargeToUpdate.getType());
                textfields.getValue1().setText(Integer.toString(chargeToUpdate.getCost()));
                break;
            case "Investments":
                Investments_struct_yaml investmentToUpdate = all_investments.getInvestment(index);
                textfields.getValue0().setText(investmentToUpdate.getType());
                textfields.getValue1().setText(Integer.toString(investmentToUpdate.getCost()));
                break;
            case "AdditionalFinance":
                AdditionalFinance_struct_yaml oneAdditionalFinanceToUpdate = all_finance.getOneAdditionalFinance(index);
                textfields.getValue0().setText(oneAdditionalFinanceToUpdate.getType());
                textfields.getValue1().setText(Integer.toString(oneAdditionalFinanceToUpdate.getMoney()));
                break;
        }
        
    }
    
    @Override
    public void updateList(int index, String type, String title, float cost){
        all_costs.updateCost(index, type, title, cost);
    }
    
    @Override
    public void updateList(int index, String name, String surname, int salary, String type){
        all_employees.updateEmployee(index, name, surname, salary, type);
    }
    
    @Override
    public void updateList(int index, String param1, float param2, String type){
         switch(type){
             case "Revenues":
                 all_revenues.updateRevenue(index, param1, param2);
                 break;
             case "Charges":
                 all_charges.updateCharge(index, param1, (int) param2);
                 break;
             case "Investments":
                 all_investments.updateInvestment(index, param1, (int) param2);
                 break;
             case "AdditionalFinance":
                 all_finance.updateOneAdditionalFinance(index, param1, (int) param2);
                 break;
         }
    }
    
    @Override
    public void delete(int index, String type){
        switch(type){
            case "Revenues":
                all_revenues.deleteRevenue(index);
                break;
            case "Charges":
                all_charges.deleteCharge(index);
                break;
            case "Investments":
                all_investments.deleteInvestment(index);
                break;
            case "Employees":
                all_employees.deleteEmployee(index);
                break;
            case "AdditionalFinance":
                all_finance.deleteOneAdditionalFinance(index);
        }
    }
    
    @Override
    public void refreshView(DefaultTableModel model_of_table, String type){
        model_of_table.getDataVector().clear();
        switch (type){
            case "Revenues":
                Revenues_struct_yaml revenue;
                for (int i=0; i<all_revenues.getCount(); i++){
                    revenue = all_revenues.getRevenue(i);
                    model_of_table.addRow(new Object[]{revenue.getDate(), revenue.getRevenue()});
                }
                break;
            case "Costs":
                Costs_struct_yaml cost;
                for (int i=0; i<all_costs.getCount(); i++){
                    cost = all_costs.getCost(i);
                    model_of_table.addRow(new Object[]{cost.getType(), cost.getTitle(), cost.getCost()});
                }
                break;
            case "Charges":
                Charges_struct_yaml charge;
                for (int i=0; i<all_charges.getCount(); i++){
                    charge = all_charges.getCharge(i);
                    model_of_table.addRow(new Object[]{charge.getType(), charge.getCost()});
                    //System.out.println(charge.getType() +  " " + charge.getCost());
                }
                break;
            case "Investments":
                Investments_struct_yaml investment;
                for (int i=0; i < all_investments.getCount(); i++){
                    investment = all_investments.getInvestment(i);
                    model_of_table.addRow(new Object[]{investment.getType(), investment.getCost()});
                    //System.out.println(investment.getType() +  " " + investment.getCost());
                }
                break;
            case "AdditionalFinance":
                AdditionalFinance_struct_yaml finance;
                for (int i=0; i < all_finance.getCount(); i++){
                    finance = all_finance.getOneAdditionalFinance(i);
                    model_of_table.addRow(new Object[]{finance.getType(), finance.getMoney()});
                    //System.out.println(finance.getType() +  " " + finance.getMoney());
                }
                break;
            case "Employees":
                Employees_struct_yaml employee;
                for (int i=0; i<all_employees.getCount(); i++){
                    employee = all_employees.getEmployee(i);
                    model_of_table.addRow(new Object[]{employee.getName(), employee.getSurname(), employee.getSalary(), employee.getType()});
                }
                break;
                        
        }
        
    }
    
}
