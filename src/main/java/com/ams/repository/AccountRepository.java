/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;

import com.ams.model.Account;
import com.ams.model.IModelId;
import com.ams.model.Customer;


/**
 *
 * @author avni
 */
public class AccountRepository extends CrudRepository<Account>{

   public void createbyCustomerId(String customerId,  Account account) {
        
        account.setCustomerId(customerId);
        create(account);
    }
   
   public Account readbyCustomerId(String customerId){
       for (Account account : items) {
            if (account.getCustomerId().equals(customerId)) {
                return account;
            }
        }   
        return null;
    }
       
       
 
   
   
   
   
}
