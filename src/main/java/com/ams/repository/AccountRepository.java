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
        
        
   @Override
   public void update(Account account) {
    
    // Assuming `items` is the list or collection that holds the account objects
    
        for (int i = 0; i < items.size(); i++) {

            Account existingAccount = items.get(i);

            if (existingAccount.getId().equals(account.getId())) {

                // Update the existing account with the new values
                existingAccount.setAcc_no(account.getAcc_no());
                existingAccount.setAcc_type(account.getAcc_type());
                existingAccount.setOpened_date(account.getOpened_date());
                existingAccount.setMatured_date(account.getMatured_date());
                existingAccount.setInterest_rate(account.getInterest_rate());
                // Update any other relevant account details

                // Save the updated account back to the collection

                items.set(i, existingAccount);

                break;
            }
        }
    }

    public Account deletebyCustomerId(String customerId){
        
        Account foundAccount = null;
       for (Account account : items) {
            if (account.getCustomerId().equals(customerId)) {
                foundAccount = account;
                break;
            }  
        }   
        if (foundAccount != null) {
            items.remove(foundAccount);
            return foundAccount;
        }
        
        return null;
    }
       
 
   
   
   
   
}
