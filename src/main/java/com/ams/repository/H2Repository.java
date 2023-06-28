/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;

import com.ams.model.IModelId;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author avni
 */
//public abstract class H2Repository <T extends IModelId> extends CrudRepository<T> {

public abstract class H2Repository extends JDBCRepository{
    
    private Connection connection;
    private String url = "jdbc:h2:tcp://localhost/~/bank_account_management";
    private String username = "avni";
    private String password = "1234";
    
    public Connection getConnection() {
        if (connection == null) {
            try {
            Class.forName("org.h2.Driver");
                connection = DriverManager.getConnection(url, username, password);
            } 
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }  
}
