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
public class AdminLogin {
    
    private static final String USERNAME = "Admin";
    private static final String PASSWORD = "Admin"; 
    
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        
        if (validate(username, password)){
            System.out.println("\nAuthentication successfull!\n");
            AdminDashboard.main(args);
        }
        else{
            System.out.println("\nInvalid username or password. Try Again!");
        }
        
        
        
    }
    
    public static boolean validate(String username, String password){
    
        return username.equals(USERNAME) && password.equals(PASSWORD);
        
    }
    
}
