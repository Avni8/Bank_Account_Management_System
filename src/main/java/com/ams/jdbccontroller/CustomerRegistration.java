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
public class CustomerRegistration {
    
    public static void registerCustomer() throws Exception{
        
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();
        
        System.out.print("Enter the number of customers to register: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int i = 0; i < numCustomers; i++) {
            System.out.println("\nEnter details for customer #" + (i + 1));
            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Contact: ");
            String contact = scanner.nextLine();

            System.out.print("Date of Birth (DOB): ");
            String dob = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Product Type: ");
            String productType = scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Create a Customer object with user-provided values
            Customer customer = new Customer(id, name, address, contact, dob, email, productType, username, password);

            // Add the customer to the list
            customers.add(customer);
        }

        // Create an instance of CustomerRepository
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository("jdbc:mysql://localhost:3306/bank_account_management", "root", "avni");

        // Insert each customer into the database
        for (Customer customer : customers) {
            customerRepository.createCustomer(customer);
        }

        scanner.close();
        System.out.println("Customers registered successfully!");
        
    }
    
    public static void displayCustomerDetails(){
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository("jdbc:mysql://localhost:3306/bank_account_management", "root", "avni");

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        Customer customer = customerRepository.readCustomer(customerId);

        if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println("ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Contact: " + customer.getContact());
            System.out.println("DOB: " + customer.getDob());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Product Type: " + customer.getProductType());
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Password: " + customer.getPassword());

            System.out.println("Customer found!");
        } 
        else {
            System.out.println("Customer not found!");
        }

        scanner.close();    
    }     
    }
    
    
    
