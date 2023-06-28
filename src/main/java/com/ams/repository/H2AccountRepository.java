/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;

import com.ams.model.Account;
import com.ams.repository.JDBCRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avni
 */
public class H2AccountRepository extends H2Repository{
    
    Connection connection = getConnection();
    
    public void createAccount(Account account){
        
        try {
//            Connection connection = getConnection();
            String query = " INSERT INTO account (acc_id, acc_no, customerId, acc_type, interest_rate,"
                    + "opened_date, matured_date, balance)VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, account.getId());
            statement.setString(2, account.getAcc_no());
            statement.setString(3, account.getCustomerId());
            statement.setString(4, account.getAcc_type());
            statement.setDouble(5, account.getInterest_rate());
            statement.setString(6, account.getOpened_date());
            statement.setString(7, account.getMatured_date());
            statement.setDouble(8, account.getBalance());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Account created successfully!");
            } else {
                System.out.println("Failed to create account!");
            }
            
            
//            connection.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    public Account readAccountByCustomerId(String customerId) {
    try {
//        Connection connection = getConnection();

        String query = "SELECT * FROM account WHERE customerId = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customerId);

        ResultSet resultSet = statement.executeQuery();

        Account account = null;
        if (resultSet.next()) {
            String accountId = resultSet.getString("acc_id");
            String accountNo = resultSet.getString("acc_no");
            String accCustomerId = resultSet.getString("customerId");
            String accountType = resultSet.getString("acc_type");
            double interestRate = resultSet.getDouble("interest_rate");
            String openedDate = resultSet.getString("opened_date");
            String maturedDate = resultSet.getString("matured_date");
            double balance = resultSet.getDouble("balance");

           
            account = new Account(accountId, accountNo, accCustomerId, accountType, interestRate, openedDate, maturedDate, balance, null);
        }

        resultSet.close();
        statement.close();
//        connection.close();

        return account;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

    
    
    public void updateAccountByCustomerId(String customerId, Account account) {
    try {
//        Connection connection = getConnection();
        String query = "UPDATE account SET acc_no=?, acc_type=?, interest_rate=?, opened_date=?, matured_date=?, balance=? WHERE customerId=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, account.getAcc_no());
        statement.setString(2, account.getAcc_type());
        statement.setDouble(3, account.getInterest_rate());
        statement.setString(4, account.getOpened_date());
        statement.setString(5, account.getMatured_date());
        statement.setDouble(6, account.getBalance());
        statement.setString(7, customerId);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Account updated successfully!");
        } else {
            System.out.println("Failed to update account!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void deleteAccountByCustomerId(String customerId){
        try{
//            Connection connection = getConnection();
            
            String query = "DELETE FROM account WHERE customerId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customerId);

            int rowsAffected = statement.executeUpdate();
            
            if(rowsAffected > 0){
                System.out.println("Customer account successfully deleted.");
            }
            else{
                System.out.println("Failed to delete customer account. Please check the customer ID.");
            }
            
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
        
    }



public List<Account> getAllAccounts(){
       
       List<Account> accounts = new ArrayList<>();
       
       try{
           
//           Connection connection = getConnection();
           String sql = "SELECT * FROM account";
           PreparedStatement statement = connection.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();

            
            while (resultSet.next()) {
                
                String acc_id = resultSet.getString("acc_id");
                String acc_no = resultSet.getString("acc_no");
                String customerId = resultSet.getString("customerId");
                String acc_type = resultSet.getString("acc_type");
                double interest_rate = resultSet.getDouble("interest_rate");
                String opened_date = resultSet.getString("opened_date");
                String matured_date = resultSet.getString("matured_date");
                double balance = resultSet.getDouble("balance");

                // Create an Account object and add it to the list
                Account account = new Account(acc_id, acc_no, customerId, acc_type, interest_rate,
                        opened_date, matured_date, balance, null);
                accounts.add(account);
                
            } 
            resultSet.close();
            statement.close();
//            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
                               
       }    
    
}
