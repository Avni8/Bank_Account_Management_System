/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;

import java.sql.*;
import java.sql.SQLException;
import com.ams.model.Customer;

/**
 *
 * @author avni
 */
public class JDBCCustomerRepository extends JDBCRepository<Customer>{
    
    public JDBCCustomerRepository(String url, String username, String password) {
        
        super(url, username, password);
        
    }
    
    public void createCustomer(Customer customer) {
        try {
            Connection connection = getConnection();

            String query = "INSERT INTO customer (id, name, address, contact, dob, email, product_type, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getContact());
            statement.setString(5, customer.getDob());
            statement.setString(6, customer.getEmail());
            statement.setString(7, customer.getProductType());
            statement.setString(8, customer.getUsername());
            statement.setString(9, customer.getPassword());

            statement.executeUpdate();

            statement.close();
            connection.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public Customer readCustomer(String id) {
        try {
            Connection connection = getConnection();

            String query = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,id);

            ResultSet resultSet = statement.executeQuery();

            Customer customer = null;
            if (resultSet.next()) {
                String cid = resultSet.getString("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                String dob = resultSet.getString("dob");
                String email = resultSet.getString("email");
                String productType = resultSet.getString("product_type");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                customer = new Customer(cid, name, address, contact, dob, email, productType, username, password);
            }

            resultSet.close();
            statement.close();
            connection.close();

            return customer;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateCustomer(Customer customer) {
    try {
        Connection connection = getConnection();

        String query = "UPDATE customer  SET name=?, address=?, contact=?, dob=?, email=?, product_type=?, username=?, password=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getAddress());
        statement.setString(3, customer.getContact());
        statement.setString(4, customer.getDob());
        statement.setString(5, customer.getEmail());
        statement.setString(6, customer.getProductType());
        statement.setString(7, customer.getUsername());
        statement.setString(8, customer.getPassword());
        statement.setString(9, customer.getId());

        int rowsUpdated = statement.executeUpdate();

        statement.close();
        connection.close();

        if (rowsUpdated > 0) {
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Failed to update customer!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

   }
    
//   public void deleteCustomer(String id) {
//    try {
//        Connection connection = getConnection();
//
////        String query = "DELETE FROM " + customer + " WHERE id=?";
////        PreparedStatement statement = connection.prepareStatement(query);
////        statement.setString(1, id);
////
////        int rowsDeleted = statement.executeUpdate();
////
////        statement.close();
////        connection.close();
//
//        if (rowsDeleted > 0) {
//            System.out.println("Customer deleted successfully!");
//        } else {
//            System.out.println("Failed to delete customer!");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
}

    
    
    
    
    
    




