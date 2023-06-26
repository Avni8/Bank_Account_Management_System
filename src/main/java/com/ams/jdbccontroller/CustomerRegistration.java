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
    
    public static void registerCustomer() {
        
        Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter details for customer");
            System.out.print("ID: ");
            String id = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();
            name = Validation.validateNameandAdd(name, "Name");

            System.out.print("Address: ");
            String address = scanner.nextLine();
            address = Validation.validateNameandAdd(address, "Address");

            System.out.print("Contact: ");
            String contact = scanner.nextLine();
            contact = Validation.validateContact(contact);

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();
            dob = Validation.validateDate(dob, "Date of Birth");

            System.out.print("Email: ");
            String email = scanner.nextLine();
            email = Validation.validateEmail(email);

            System.out.print("Product Type: ");
            String productType = scanner.nextLine();
            productType = Validation.validateProductType(productType);

            System.out.print("Username: ");
            String username = scanner.nextLine();
            username = Validation.validateUsername(username, contact);

            System.out.print("Password: ");
            String password = scanner.nextLine();
            password = Validation.validatePassword(password);

            
            Customer customer = new Customer(id, name, address, contact, dob, email, productType, username, password);

    
            JDBCCustomerRepository customerRepository = new JDBCCustomerRepository();

            customerRepository.createCustomer(customer);

        scanner.close();
        System.out.println("Customer registered successfully!");
        
    }
    
    public static void displayCustomerDetails() {
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository();

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
    
    public static void DisplayForAll(){
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository();
        List<Customer> customers = customerRepository.getAllCustomers();

        for (Customer customer : customers) {
            
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Name: " + customer.getName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Contact: " + customer.getContact());
            System.out.println("DOB: " + customer.getDob());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Product Type: " + customer.getProductType());
            System.out.println("Username: " + customer.getUsername());
            System.out.println("Password: " + customer.getPassword());
            System.out.println();
        }
        
    }
    
}
    
    
    

