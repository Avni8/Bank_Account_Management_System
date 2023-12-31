/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;
import java.sql.*;
import com.ams.model.IModelId;

/**
 *
 * @author avni
 */
public abstract class JDBCRepository <T extends IModelId> extends CrudRepository<T> {
    
    
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/bank_account_management";
    private String username = "root";
    private String password = "avni";
    
    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }   
}
    



    
    
    
    
    

