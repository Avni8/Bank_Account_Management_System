/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
import com.ams.model.Account;
import java.util.*;

/**
 *
 * @author avni
 */
public class UpdateAccountDetails extends CreateAccount{
    
    static Scanner sc = new Scanner(System.in);
        
    
    public static void main(String[] args) {
        
        
        System.out.println("Enter the id of the customer you want to update details of: ");
        String customerId = sc.nextLine();
        
        Account retrievedAccount = accountRepository.readbyCustomerId(customerId);
        
        if (retrievedAccount != null){
            
            System.out.print("Enter the updated Account number (or leave blank to skip): ");
            String updatedAcc_no = sc.nextLine();
            if(!updatedAcc_no.isEmpty())
            retrievedAccount.setAcc_no(updatedAcc_no);  
            
            System.out.print("Enter the updated Account type (or leave blank to skip): ");
            String updatedAcc_type = sc.nextLine();
            if(!updatedAcc_type.isEmpty())
            retrievedAccount.setAcc_type(updatedAcc_type);   
            
            System.out.print("Enter the updated Opened date (or leave blank to skip): ");
            String updatedOpenedDate = sc.nextLine();
            if(!updatedOpenedDate.isEmpty())
            retrievedAccount.setOpened_date(updatedOpenedDate);  
            
            System.out.print("Enter the updated Matured date (or leave blank to skip): ");
            String updatedMaturedDate = sc.nextLine();
            if(!updatedMaturedDate.isEmpty())
            retrievedAccount.setMatured_date(updatedMaturedDate); 
            
            System.out.print("Enter the updated Interest rate: ");
            Double updatedInterest_rate = sc.nextDouble();
            retrievedAccount.setInterest_rate(updatedInterest_rate); 
            
            accountRepository.update(retrievedAccount);
            
            System.out.println("Customer details updated successfully."); 
            
            
        }
        
        else{
            System.out.println("Customer with id " + customerId + "not found!");
        }   
        
        
        
        
    }
}
