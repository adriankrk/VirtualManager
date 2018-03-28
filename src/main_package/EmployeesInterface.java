/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import javax.swing.table.DefaultTableModel;
import org.javatuples.Triplet;

/**
 *
 * @author Adrian
 */
public interface EmployeesInterface {
    public void startThreads(javax.swing.JLabel label, String type);
    public void terminateThreads();
    public void refreshView(DefaultTableModel model_of_table, String type);
    public void add(String name, String surname, int salary, String type);
    public void writeDataToTextField(int index, Triplet<javax.swing.JTextField,javax.swing.JTextField,javax.swing.JTextField> textfields, int id );
    public void updateList(int index, String name, String surname, int salary, String type);
    public void delete(int index, String type);
}
