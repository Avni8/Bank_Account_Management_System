/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
import java.util.*;
import com.ams.model.Account;
import com.ams.model.Customer;
import com.ams.repository.AccountRepository;


/**
 *
 * @author avni
 */
public class CreateAccount extends CustomerRegistration {
    
    static AccountRepository accountRepository = new AccountRepository();
    static Scanner scanner = new Scanner(System.in);
    
    public static void createAccount() throws Exception{
        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();
        
        Customer customer = customerRepository.read(customerId);
        
        if (customer != null) {
            // Prompt the user to enter account details
            System.out.println("Enter account details:");
            System.out.print("Account ID: ");
            String accountId = scanner.nextLine();
            System.out.print("Account Number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Account Type: ");
            String accountType = scanner.nextLine();
            System.out.print("Opened Date: ");
            String openedDate = scanner.nextLine();
            System.out.print("Matured Date: ");
            String maturedDate = scanner.nextLine();
            System.out.print("Interest Rate: ");
            Integer interestRate = scanner.nextInt();
            
            Account account = new Account(accountId, accountNumber, customerId, accountType, interestRate,
            openedDate, maturedDate, customer);
            
            accountRepository.createbyCustomerId(customerId, account);
            
            System.out.println("Account created successfully.");
            
        
        }
        
        else 
        {
            System.out.println("Customer not found with ID " + customerId);
            
        }  
             
    }
    
    public static void searchAccountList(){
        
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the ID of the customer whose account details you want to search: ");
        
        String customerId = sc.nextLine();
        
        Account retrievedAccount = accountRepository.readbyCustomerId(customerId);
        
        if (retrievedAccount != null){
            
            displayAccountDetails(retrievedAccount);      
        }
        
        else{
            System.out.println("Customer with id " + customerId + "not found!");
        }   
        
    }
    
    public static void displayAccountDetails(Account account){
        System.out.println("Account ID: " + account.getId());
        System.out.print("Account Number: " + account.getAcc_no() + "\n");
        System.out.print("Account Type: " + account.getAcc_type()+ "\n");
        System.out.print("Interest Rate: " + account.getInterest_rate()+ "\n");
        System.out.print("Opened Date: " + account.getOpened_date()+ "\n");
        System.out.print("Matured Date: " + account.getMatured_date()+ "\n");
        System.out.println();   
        
    }   
    
    
}
