/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.controller;
import java.util.*;

/**
 *
 * @author avni
 */
public class MainClass {
    
     public static void main(String[] args) throws Exception {
        
        System.out.println("\n****Bank Account Management System****\n");
        System.out.println("Are you an admin or a customer?");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 'admin' or 'customer'");
        String ans = sc.nextLine();
        
        if(ans.equals("admin")){
            System.out.println("\nWelcome to the Admin Login Page!\n");
            AdminLogin.main(args);
        
        }
        else if (ans.equals("customer")){
        
            System.out.println("\nWelcome to the Customer Login Page!");
        }
        else{
            System.out.println("Enter a valid option!");
            main(args);
        }     
        
        
    }
    
}
