/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
//import com.ams.repository.CustomerRepository;
import com.ams.model.Customer;

/**
 *
 * @author avni
 */
public class DeleteCustomer extends CustomerRegistration {
    
    public static void main(String[] args) {
        
        System.out.println("Enter the id of the customer you want to delete: ");
        String deleteId = scanner.nextLine();
        Customer deletedCustomer = customerRepository.delete(deleteId);
        if (deletedCustomer != null) {
            System.out.println("Customer with ID " + deleteId + " is successfully deleted.");
        } 
        else {
            System.out.println("Customer with ID " + deleteId + " does not exist.");
        }
        
        
    }
    
    
    
}
