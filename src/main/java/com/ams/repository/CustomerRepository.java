/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.repository;
import java.util.*;
import com.ams.model.Customer;

/**
 *
 * @author avni
 */
public class CustomerRepository extends CrudRepository<Customer>{
    
    protected String getId(Customer customer){
    
        return customer.getId(); 
    }
      
    
}
