/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.jdbccontroller;
import java.util.*;
import com.ams.model.Account;
import com.ams.model.Customer;
import com.ams.repository.JDBCAccountRepository;
import com.ams.repository.JDBCCustomerRepository;
import com.ams.repository.JDBCRepository;

/**
/**
 *
 * @author avni
 */
public class CreateAccount {
   
    public static void registerAccount(){
        
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        // Get account details from the user
        System.out.print("Enter customer ID of the customer whose account you want to create ");
        String customerId = scanner.nextLine();
        

        JDBCCustomerRepository customerRepository = new JDBCCustomerRepository();
        Customer customer = customerRepository.readCustomer(customerId);
        
        if(customer != null){
        System.out.print("Enter account id: ");
        String accountId = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        accountNumber = Validation.validateAccountNumber(accountNumber);

        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();
        accountType = Validation.validateAccountType(accountType);

        System.out.print("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.print("Enter opened date (YYYY-MM-DD): ");
        String openedDate = scanner.next();
        openedDate = Validation.validateDate(openedDate, "Opened Date");

        System.out.print("Enter matured date (YYYY-MM-DD): ");
        String maturedDate = sc.next();
        maturedDate = Validation.validateDate(maturedDate, "Mature Date");

        System.out.print("Enter account balance: ");
        double balance = scn.nextDouble();

        // Create an Account object with the user-provided values
        
        Account account = new Account(accountId, accountNumber, customerId, accountType, interestRate,
                openedDate, maturedDate, balance, customer);
        
        JDBCAccountRepository accountRepository = new JDBCAccountRepository();
        // Call the createAccount method with the Account object
        accountRepository.createAccount(account);

        // Close the scanner
        scanner.close();
    }
        else{
            System.out.println("Customer with id " + customerId + "doesn't exists");
        }
    
    }
    
    public static void displayAccountDetails(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();

        JDBCAccountRepository accountRepository = new JDBCAccountRepository();
        Account account = accountRepository.readAccountByCustomerId(customerId);

        
        if (account != null) {
            
            String accountId = account.getId();
            String accountNo = account.getAcc_no();
            String accountType = account.getAcc_type();
            double interestRate = account.getInterest_rate();
            String openedDate = account.getOpened_date();
            String maturedDate = account.getMatured_date();
            double balance = account.getBalance();

            System.out.println("Account ID: " + accountId);
            System.out.println("Account No: " + accountNo);
            System.out.println("Account Type: " + accountType);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Opened Date: " + openedDate);
            System.out.println("Matured Date: " + maturedDate);
            System.out.println("Balance: Rs. " + balance);
        } else {
            System.out.println("Account not found for the provided customer ID.");
        }

      
        scanner.close();
        
    }
    
    
    public static void displayForAll(){
        
        JDBCAccountRepository accountRepository = new JDBCAccountRepository();
        List<Account> accounts = accountRepository.getAllAccounts();

        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Account Number: " + account.getAcc_no());
            System.out.println("Customer ID: " + account.getCustomerId());
            System.out.println("Account Type: " + account.getAcc_type());
            System.out.println("Interest Rate: " + account.getInterest_rate());
            System.out.println("Opened Date: " + account.getOpened_date());
            System.out.println("Matured Date: " + account.getMatured_date());
            System.out.println("Balance: Rs. " + account.getBalance());
            
            System.out.println();
        }
        
    }
    
} 
    
    

