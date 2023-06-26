/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.testpackage;

import com.ams.repository.JDBCAccountRepository;
import com.ams.model.Account;
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
        
        testAccount = new Account("8", "2400000123456789", "26", "Nari Bachat Saving", 13, 
                "1999-02-02", "2020-02-02", 3434433, null);
        
        testAccount1 = new Account("9", "2400000123454592", "21", "Nari Bachat Saving", 13, 
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
    
    @Test
    public void testReadAccount(){
        
        Account retrievedAccount = accountRepository.readAccountByCustomerId
        (testAccount.getCustomerId());
        
        assertNotNull(retrievedAccount);
        assertEquals(testAccount.getId(), retrievedAccount.getId());
        assertEquals(testAccount.getAcc_no(), retrievedAccount.getAcc_no());
        assertEquals(testAccount.getCustomerId(), retrievedAccount.getCustomerId());
        assertEquals(testAccount.getAcc_type(), retrievedAccount.getAcc_type());
        assertEquals(testAccount.getInterest_rate(), retrievedAccount.getInterest_rate(), 0.01);
        assertEquals(testAccount.getOpened_date(), retrievedAccount.getOpened_date());
        assertEquals(testAccount.getMatured_date(), retrievedAccount.getMatured_date());
        assertEquals(testAccount.getBalance(), retrievedAccount.getBalance(), 0.01);   
    }
    
    @Test
    public void testGetAllAccounts(){
        
        List<Account> accounts = accountRepository.getAllAccounts();
        assertNotNull(accounts);
        assertEquals(10, accounts.size());  
    }
    
    @Test
    public void testUpdateAccount(){
        
        testAccount.setAcc_no("2400000137564811");
        testAccount.setAcc_type("Bal Bhachat Saving");
        testAccount.setInterest_rate(15);
        testAccount.setOpened_date("2000-02-02");
        testAccount.setMatured_date("2020-02-02");
        testAccount.setBalance(123456);
        
        accountRepository.updateAccountByCustomerId(testAccount.getCustomerId(), testAccount);
        
        Account updatedAccount = accountRepository.readAccountByCustomerId(testAccount.getCustomerId());
        
        assertNotNull(updatedAccount);
        assertEquals(testAccount.getAcc_no(),updatedAccount.getAcc_no());
        assertEquals(testAccount.getAcc_type(),updatedAccount.getAcc_type());

        assertEquals(testAccount.getOpened_date(),updatedAccount.getOpened_date());
        assertEquals(testAccount.getMatured_date(),updatedAccount.getMatured_date());
        assertEquals(testAccount.getInterest_rate(),updatedAccount.getInterest_rate(), 0.01); 
        assertEquals(testAccount.getBalance(), updatedAccount.getBalance(), 0.01);
    }
    
    @Test
    public void testDeleteAccount(){
        accountRepository.deleteAccountByCustomerId(testAccount.getCustomerId());
        Account deletedAccount = accountRepository.readAccountByCustomerId(testAccount.getCustomerId());
        assertNull(deletedAccount);
        
    }  
}
