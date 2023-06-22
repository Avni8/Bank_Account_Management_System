/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;

import com.ams.model.Customer;
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
    

    
}
