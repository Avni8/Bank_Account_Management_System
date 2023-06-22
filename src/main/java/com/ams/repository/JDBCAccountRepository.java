/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;
import com.ams.model.Account;

/**
 *
 * @author avni
 */
public class JDBCAccountRepository extends JDBCRepository<Account> {
    
    public JDBCAccountRepository(String url, String username, String password) {
        
        super(url, username, password);
        
    }
    
    
}
