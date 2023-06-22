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
public class DeleteCustomer {
    
    public static void main(String[] args) {
        
        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository("jdbc:mysql://localhost:3306/bank_account_management", "root", "avni");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the customer ID: ");
        String id = scanner.nextLine();

        customerRepository.deleteCustomer(id);
        scanner.close();

    }
    
    
}
