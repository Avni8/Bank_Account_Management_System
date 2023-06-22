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

    public static void main(String[] args) throws Exception
    {
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository("jdbc:mysql://localhost:3306/bank_account_management", "root", "avni");

       
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the customer ID: ");
        String id = scanner.nextLine();

        
        Customer existingCustomer = customerRepository.readCustomer(id);
        
        if (existingCustomer != null) {
            
            System.out.print("Enter the updated name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the updated address: ");
            String address = scanner.nextLine();

            System.out.print("Enter the updated contact: ");
            String contact = scanner.nextLine();

            System.out.print("Enter the updated date of birth (DOB): ");
            String dob = scanner.nextLine();

            System.out.print("Enter the updated email: ");
            String email = scanner.nextLine();

            System.out.print("Enter the updated product type: ");
            String productType = scanner.nextLine();

            System.out.print("Enter the updated username: ");
            String username = scanner.nextLine();

            System.out.print("Enter the updated password: ");
            String password = scanner.nextLine();

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

    
    

