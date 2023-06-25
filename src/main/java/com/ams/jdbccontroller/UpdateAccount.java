/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.jdbccontroller;
import com.ams.repository.JDBCAccountRepository;
import com.ams.model.Account;
import java.util.*;

/**
 *
 * @author avni
 */
public class UpdateAccount {
    
    public static void update() {
       
        JDBCAccountRepository accountRepository = new JDBCAccountRepository();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();

        // Create an Account object with the updated values based on user input
        System.out.print("Enter the account ID: ");
        String accountId = scanner.nextLine();

        System.out.print("Enter the updated account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter the updated account type: ");
        String accountType = scanner.nextLine();

        System.out.print("Enter the updated interest rate: ");
        double interestRate = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the updated opened date: ");
        String openedDate = scanner.nextLine();

        System.out.print("Enter the updated matured date: ");
        String maturedDate = scanner.nextLine();

        System.out.print("Enter the updated balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        // Create the updated Account object
        Account updatedAccount = new Account(accountId, accountNumber, customerId, accountType,
            interestRate, openedDate, maturedDate, balance, null);

        // Call the updateAccountByCustomerId method
        accountRepository.updateAccountByCustomerId(customerId, updatedAccount);

        // Close the Scanner
        scanner.close();
    }
        
        
    }
    

