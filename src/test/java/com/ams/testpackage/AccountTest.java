/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.testpackage;
import com.ams.repository.JDBCCustomerRepository;
import com.ams.repository.JDBCAccountRepository;
import com.ams.model.Account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.util.*;

/**
 *
 * @author avni
 */
public class AccountTest {
    
    private static JDBCAccountRepository accountRepository;
    private static Account testAccount;
    private static Account testAccount1;
    
    @BeforeClass
    public static void setUp(){
        
        accountRepository = new JDBCAccountRepository();
        
        testAccount = new Account("8", "2400000123456789", "8", "Nari Bachat Saving", 13, 
                "1999-02-02", "2020-02-02", 3434433, null);
        
        testAccount1 = new Account("9", "2400000123454592", "9", "Nari Bachat Saving", 13, 
                "1999-02-02", "2020-02-02", 10000000, null);
        
    }
    
    @Test
    public void testCreateAccount(){
        
        accountRepository.createAccount(testAccount);
        accountRepository.createAccount(testAccount1);
        Account createdAccount = accountRepository.readAccountByCustomerId(
                testAccount.getCustomerId());
        
        assertNotNull(createdAccount);
        assertEquals(testAccount.getId(), createdAccount.getId());
        assertEquals(testAccount.getAcc_no(), createdAccount.getAcc_no());
        assertEquals(testAccount.getCustomerId(), createdAccount.getCustomerId());
        assertEquals(testAccount.getAcc_type(), createdAccount.getAcc_type());
        assertEquals(testAccount.getInterest_rate(), createdAccount.getInterest_rate(), 0.01);
        assertEquals(testAccount.getOpened_date(), createdAccount.getOpened_date());
        assertEquals(testAccount.getMatured_date(), createdAccount.getMatured_date());
        assertEquals(testAccount.getBalance(), createdAccount.getBalance(), 0.01);
        
        
    }
    
    
    
    
}
