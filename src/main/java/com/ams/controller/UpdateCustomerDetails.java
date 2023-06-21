/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
import java.util.*;

import com.ams.model.Customer;


/**
 *
 * @author avni
 */
public class UpdateCustomerDetails extends CustomerRegistration {
    
//    static CustomerRepository customerRepository = new CustomerRepository();
//    static Scanner scanner = new Scanner(System.in);
//    
    public static void main(String[] args) {
        
        System.out.println("Enter the id of the customer you want to update details of: ");
        String updateId = scanner.nextLine();
        
        Customer retrievedCustomer = customerRepository.read(updateId);
        if(retrievedCustomer != null){
            
            
//            System.out.print("Enter the updated id (or leave blank to skip): ");
//            String updatedId = scanner.nextLine();
//            if(!updatedId.isEmpty())
//            retrievedCustomer.setName(updatedId);
            
            System.out.print("Enter the updated name (or leave blank to skip): ");
            String updatedName = scanner.nextLine();
            if(!updatedName.isEmpty())
            retrievedCustomer.setName(updatedName);
            
            System.out.print("Enter the updated address (or leave blank to skip): ");
            String updatedAddress = scanner.nextLine();
            if(!updatedAddress.isEmpty())
            retrievedCustomer.setAddress(updatedAddress);
            
            System.out.print("Enter the updated contact (or leave blank to skip): ");
            String updatedContact = scanner.nextLine();
            if(!updatedContact.isEmpty())
            retrievedCustomer.setContact(updatedContact);
            
            System.out.print("Enter the updated date of birth (or leave blank to skip): ");
            String updatedDob = scanner.nextLine();
            if(!updatedDob.isEmpty())
            retrievedCustomer.setDob(updatedDob);
            
            System.out.print("Enter the updated email address (or leave blank to skip): ");
            String updatedEmail = scanner.nextLine();
            if(!updatedEmail.isEmpty())
            retrievedCustomer.setEmail(updatedEmail);
            
            System.out.print("Enter the updated product type (or leave blank to skip): ");
            String updatedProduct_type = scanner.nextLine();
            if(!updatedProduct_type.isEmpty())
            retrievedCustomer.setProduct_type(updatedProduct_type);
            
            System.out.print("Enter the updated username (or leave blank to skip): ");
            String updatedUsername = scanner.nextLine();
            if(!updatedUsername.isEmpty())
            retrievedCustomer.setUsername(updatedUsername);
            
            System.out.print("Enter the updated password (or leave blank to skip): ");
            String updatedPassword = scanner.nextLine();
            if(!updatedPassword.isEmpty())
            retrievedCustomer.setPassword(updatedPassword);
            
            customerRepository.update(retrievedCustomer);
            
            System.out.println("Customer details updated successfully."); 
            
        }
        else{
            System.out.println("Customer not found!");
        }   
        
    }
    
}
