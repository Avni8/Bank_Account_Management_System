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
public class Validation {
    
    static Scanner scanner  = new Scanner(System.in);
    
   public static String validateNameandAdd(String valueName, String fieldName) {
    Scanner scanner = new Scanner(System.in);

    String value = valueName;

    while (value == null || value.trim().isEmpty()) {
        System.out.println(fieldName + " cannot be empty.");
        System.out.print("Enter " + fieldName + ": ");
        value = scanner.nextLine();
    }
    String regexPattern = "^[a-zA-Z\\s]+$";

    while (!value.matches(regexPattern)) {
        System.out.println("Invalid " + fieldName + " format! Only alphabets and spaces are allowed.");
        System.out.print("Enter " + fieldName + ": ");
        value = scanner.nextLine();
    }

    return value;
}
    
    public static String validateContact(String contact) {

    while (contact == null || contact.trim().isEmpty()) {
        System.out.println("Contact number cannot be empty.");
        System.out.print("Enter contact number: ");
        contact = scanner.nextLine();
    }
    String regexPattern = "^\\d{10}$";
    
    while (!contact.matches(regexPattern)) {
        System.out.println("Invalid contact number format! It should be a 10-digit number.");
        System.out.print("Enter contact number: ");
        contact = scanner.nextLine();
    }
    
    return contact;
    }
    
    public static String validateDate(String date, String field) {
    
    while (date == null || date.trim().isEmpty()) {
        System.out.println(field + " cannot be empty.");
        System.out.print("Enter " + field + " (YYYY-MM-DD): ");
        date = scanner.nextLine();
    }
    
    String regexPattern = "^\\d{4}-\\d{2}-\\d{2}$";
    
    while (!date.matches(regexPattern)) {
        System.out.println("Invalid " + field + " format! Please enter a valid date in the format YYYY-MM-DD.");
        System.out.print("Enter " + field + " (YYYY-MM-DD): ");
        date = scanner.nextLine();
    }
    
    return date;
    }
    
    public static String validateEmail(String email) {
    
    while (email == null || email.trim().isEmpty()) {
        System.out.println("Email cannot be empty.");
        System.out.print("Enter email: ");
        email = scanner.nextLine();
    }
    String regexPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    
    while (!email.matches(regexPattern)) {
        System.out.println("Invalid email format! Please enter a valid email address.");
        System.out.print("Enter email: ");
        email = scanner.nextLine();
    }
    
    return email;
    }
    
    public static String validateProductType(String productType) {
    
    List<String> validProductTypes = new ArrayList<>(Arrays.asList("Savings", "Current", "Fixed Deposits"));
    
    while (productType == null || productType.trim().isEmpty() || !validProductTypes.contains(productType)) {
        System.out.println("Invalid product type! Available options are: Savings, Current, Fixed Deposits");
        System.out.print("Enter product type: ");
        productType = scanner.nextLine();
    }
    
    return productType;
    }
    
    public static String validateUsername(String username, String contact) {

    while (username == null || username.trim().isEmpty()) {
        System.out.println("Username cannot be empty.");
        System.out.print("Enter username: ");
        username = scanner.nextLine();
    }
    
    while (!username.equals(contact)) {
        System.out.println("Username must be the same as the contact number. Please try again.");
        System.out.print("Enter username: ");
        username = scanner.nextLine();
    }
    
    return username;
    }
    
    public static String validatePassword(String password) {

    while (true) {
        if (password == null || password.trim().isEmpty()) {
            System.out.println("Invalid password! Password cannot be null or empty.");
        } else if (password.length() < 8) {
            System.out.println("Invalid password. Password must be at least 8 characters long.");
        } else if (!password.matches(".*[A-Z].*")) {
            System.out.println("Invalid password! Password must contain at least one uppercase letter.");
        } else if (!password.matches(".*\\d.*")) {
            System.out.println("Invalid password! Password must contain at least one digit.");
        } else {
            break;
        }
        
        System.out.print("Enter password: ");
        password = scanner.nextLine();
    }

    return password;
    }
    
    public static String validateAccountNumber(String accountNumber) {
    Scanner scanner = new Scanner(System.in);

    while (accountNumber == null || accountNumber.trim().isEmpty() || accountNumber.length() != 16
            || !accountNumber.startsWith("24") || !accountNumber.substring(2).startsWith("000001")
            || !accountNumber.substring(8).matches("\\d+")) {
        System.out.println("Invalid account number!");
        System.out.print("Enter account number: ");
        accountNumber = scanner.nextLine();
    }

    return accountNumber;
    }
    
    public static String validateAccountType(String accountType) {
    Scanner scanner = new Scanner(System.in);

    List<String> validAccountTypes = Arrays.asList(
        "Nari Bhachat Saving",
        "Bal Bachat Saving",
        "Senior Citizens Saving",
        "Fixed Deposit",
        "Sunaulo Bhabisya Saving",
        "ABC Current"
    );

    while (accountType == null || accountType.trim().isEmpty() || !validAccountTypes.contains(accountType.trim())) {
        System.out.println("Invalid account type! Available options are: "
            + validAccountTypes.toString());
        System.out.print("Enter account type: ");
        accountType = scanner.nextLine();
    }

    return accountType;
}
    
}
