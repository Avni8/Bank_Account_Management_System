/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
import java.util.*;
import com.ams.model.Customer;
import com.ams.repository.CustomerRepository;

/**
 *
 * @author avni
 */
public class CustomerRegistration {   
    
    static CustomerRepository customerRepository = new CustomerRepository();
    static Scanner scanner = new Scanner(System.in);
    
    public static void registerCustomer() throws Exception{
        
        System.out.println("Enter the number of customer you want to register: ");
        int Numcustomers = scanner.nextInt();
        scanner.nextLine();
        
        for(int i=1; i <= Numcustomers; i++){
            
            System.out.println("Enter details for Customer#" +i);
            
            System.out.println("ID: ");
            String id = scanner.nextLine();
            
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            System.out.println("Address: ");
            String address = scanner.nextLine();
            
            System.out.println("Contact Number: ");
            String contact = scanner.nextLine();
            
            System.out.println("Date of Birth: ");
            String dob = scanner.nextLine();
            
            System.out.println("Email");
            String email = scanner.nextLine();
            
             System.out.println("Type of account to be created: ");
            String product_type = scanner.nextLine();
            System.out.println("\n");
            
            System.out.println("Set username and password for the user");

        // Get the username
            System.out.print("Username: ");
            String username = scanner.nextLine();

        // Get the password
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            Customer customer = new Customer(id, name, address, contact, dob, email, 
                    product_type, username, password);
            
            customerRepository.create(customer);
            
            
        }
        
        System.out.println("\nCustomers Registered successfully!"); 
        
        
    }
    
    public static void searchCustomerList(){
    
        System.out.println("Enter the ID of customer to search: ");
        
        String searchId = scanner.nextLine();
        
        Customer retrievedCustomer = customerRepository.read(searchId);
        if (retrievedCustomer != null){
            
            displayCustomerDetails(retrievedCustomer);      
        }
        
        else{
            System.out.println("Customer with id " + searchId + "not found!");
        }   
        
    }
    
    public static void displayCustomerDetails(Customer customer){
        
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Contact Number: " + customer.getContact());
            System.out.println("Date of Birth: " + customer.getDob());
            System.out.println("Email Address: " + customer.getEmail());
            System.out.println("Account Type: " + customer.getProductType());
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Password: " + customer.getPassword());
            System.out.println();
           
    }
        
//public static void main(String[] args) {
//        
//        CustomerRegistration registration = new CustomerRegistration();
//        registration.registerCustomer();
//        registration.searchCustomerList();
//        
//    }
    
}
