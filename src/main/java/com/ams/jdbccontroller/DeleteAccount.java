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
public class DeleteAccount {
    
    public static void main(String[] args) {
        
        JDBCAccountRepository accountRepository = new JDBCAccountRepository("jdbc:mysql://localhost:3306/bank_account_management", "root", "avni");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the customer ID: ");
        String customerId = scanner.nextLine();
        
        accountRepository.deleteAccountByCustomerId(customerId);
        
        
        
    }
    
    
}
