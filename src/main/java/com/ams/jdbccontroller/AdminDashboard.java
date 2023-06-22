/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.jdbccontroller;
import java.util.*;


/**
 *
 * @author avni
 */
public class AdminDashboard {
    
    public static void main(String[] args) throws Exception {
           
        System.out.println("\n****Admin DashBoard****\n");
        System.out.println("Please choose one of the folllowing actions\n");
        System.out.println("1. Register a new customer");
        System.out.println("2. View customer details");
        System.out.println("3. Update customer details");
        System.out.println("4. Delete customer details");
        System.out.println("5. Create account for customer");
        System.out.println("6. View account details");
        System.out.println("7. Update account details");
        System.out.println("8. Delete customer account");
        System.out.println("9. Make a monetary deposit");
        System.out.println("10. Withdraw funds\n");
        System.out.println("Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        switch(choice){
            case(1): System.out.println("\nWelcome to the Customer Registration Page!\n");
                     CustomerRegistration.registerCustomer();      
//                     main(args);
                     break;
            case(2): System.out.println("\nWelcome to the Customer Details Page!\n");
                     CustomerRegistration.displayCustomerDetails();
                     break;
            case(3): System.out.println("\nWelcome to the Customer Details Update Page!\n");
                     
                     main(args);

                     break;
            case(4): System.out.println("\nWelcome to the Customer Removal Page!\n");
                     
                     main(args);
                     break;
            case(5): System.out.println("\nWelcome to the Customer Account Creation Page!\n");
                    
                     main(args);
                     break;        
            case(6): System.out.println("\nWelcome to the Account Details Page!\n");
                    
                     main(args);
                     break;
            case(7): System.out.println("\n Welcome to the Account Details Update Page!\n");
                     
                     main(args); 
                     break;
            case(8): System.out.println("\n Welcome to the Account Deletion Page!\n"); 
                     
                     main(args);
                     break;
            case(9): System.out.println("\nWelcome to the Monetary Deposit Page!\n");
                     main(args);
                     break;
                     
            case(10): System.out.println("\nWelcome to the Cash Withdrawal Page\n");
                     main(args);
                     break;
                     
            default: System.out.println("\nInvalid Choice! Try Again.\n");
//                     main(args);
           
        }     
        
    }
    
    
}
