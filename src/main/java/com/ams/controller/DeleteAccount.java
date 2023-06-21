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
public class DeleteAccount extends CreateAccount{
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Enter the id of the customer whose account you want to delete: ");
        String customerId = sc.nextLine();
        
        Account deletedAccount = accountRepository.deletebyCustomerId(customerId);
        if (deletedAccount != null) {
            System.out.println("Account of customer with ID " + customerId + " is successfully deleted.");
        } 
        else {
            System.out.println("Customer with ID " + customerId + " does not exist or his/her account doesn't exist");
        }  
    }
}
