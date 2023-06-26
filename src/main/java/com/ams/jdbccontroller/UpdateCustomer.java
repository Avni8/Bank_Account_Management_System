/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.jdbccontroller;
import java.util.*;
import com.ams.model.Customer;
import com.ams.repository.JDBCCustomerRepository;

/**
 *
 * @author avni
 */
public class UpdateCustomer {

    public static void update() 
    {
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository();

       
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the customer ID: ");
        String id = scanner.nextLine();

        
        Customer existingCustomer = customerRepository.readCustomer(id);
        
        if (existingCustomer != null) {
            
            System.out.print("Enter the updated name: ");
            String name = scanner.nextLine();
            name = Validation.validateNameandAdd(name, "Name");

            System.out.print("Enter the updated address: ");
            String address = scanner.nextLine();
            address = Validation.validateNameandAdd(address, "Address");

            System.out.print("Enter the updated contact: ");
            String contact = scanner.nextLine();
            contact = Validation.validateContact(contact);

            System.out.print("Enter the updated date of birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            dob = Validation.validateDate(dob, "Date of Birth");

            System.out.print("Enter the updated email: ");
            String email = scanner.nextLine();
            email = Validation.validateEmail(email);

            System.out.print("Enter the updated product type: ");
            String productType = scanner.nextLine();
            productType = Validation.validateProductType(productType);

            System.out.print("Enter the updated username: ");
            String username = scanner.nextLine();
            username = Validation.validateUsername(username, contact);

            System.out.print("Enter the updated password: ");
            String password = scanner.nextLine();
            password = Validation.validatePassword(password);

            Customer updatedCustomer = new Customer(id, name, address, contact, dob, email, productType, username, password);

            customerRepository.updateCustomer(updatedCustomer);
        } 
        else 
        {
            System.out.println("Customer not found!");
        }

        scanner.close();
    }

}

    
    

