/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package.exceptions_;

/**
 *
 * @author Adrian
 */
public class NumberoutException extends Exception{
    public NumberoutException() {}

    //Constructor that accepts a message
    public NumberoutException(String message)
    {
        super(message);
    }
}
