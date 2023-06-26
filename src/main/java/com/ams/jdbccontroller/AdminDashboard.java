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

    public static void main(String[] args) throws NoSuchElementException {

//        Boolean exit = Boolean.FALSE;
//        while (!exit) {
            
            System.out.println("\n****Admin DashBoard****\n");

            System.out.println("Please choose one of the folllowing actions\n");
            System.out.println("1. Register a new customer");
            System.out.println("2. View customer details");
            System.out.println("3. View all customers");
            System.out.println("4. Update customer details");
            System.out.println("5. Delete customer details");
            System.out.println("6. Create account for customer");
            System.out.println("7. View account details");
            System.out.println("8. View all account details");
            System.out.println("9. Update account details");
            System.out.println("10. Delete customer account");

            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
//            exit = choice == 0;

            switch (choice) {
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
//                    exit = choice == 0;
                    break;
                case 1:

                    System.out.println("\nWelcome to the Customer Registration Page!\n");

                    CustomerRegistration.registerCustomer();

                    break;

                case 2:

                    System.out.println("\nWelcome to the Customer Details Page!\n");

                    CustomerRegistration.displayCustomerDetails();

                    break;

                case 3:

                    System.out.println("\nWelcome to the All Customer Details Page!\n");

                    CustomerRegistration.DisplayForAll();

                    break;

                case 4:

                    System.out.println("\nWelcome to the Customer Details Update Page!\n");

                    UpdateCustomer.update();

                    break;

                case 5:

                    System.out.println("\nWelcome to the Customer Removal Page!\n");

                    DeleteCustomer.delete();

                    break;

                case 6:

                    System.out.println("\nWelcome to the Customer Account Creation Page!\n");

                    CreateAccount.registerAccount();

                    break;

                case 7:

                    System.out.println("\nWelcome to the Account Details Page!\n");

                    CreateAccount.displayAccountDetails();

                    break;

                case 8:

                    System.out.println("\nWelcome to the All Account Details Page!\n");

                    CreateAccount.DisplayForAll();

                    break;

                case 9:

                    System.out.println("\n Welcome to the Account Details Update Page!\n");

                    UpdateAccount.update();

                    break;

                case 10:

                    System.out.println("\n Welcome to the Account Deletion Page!\n");

                    DeleteAccount.delete();

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

                    break;

            }
//            System.out.println(); // Print an empty line for separation
//            sc.close();
            
            
        }
    }

//}


