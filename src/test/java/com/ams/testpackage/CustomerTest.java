/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.testpackage;
import com.ams.repository.H2CustomerRepository;
import com.ams.repository.JDBCRepository;
import com.ams.repository.H2Repository;
import com.ams.model.Customer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.util.*;

/**
 *
 * @author avni
 */
public class CustomerTest  extends H2Repository{
    
    private static H2CustomerRepository customerRepository;
    private static Customer testCustomer;
    private static Customer testCustomer1;
    
    
    
    @BeforeClass
    public static void setUp(){
        
        
        
        customerRepository = new H2CustomerRepository();
        testCustomer = new Customer("10", "Ram", "ktm", "9834675382", "1995-02-02",
                "ria@gmail.com", "Savings", "9834675382", "rishi");
        testCustomer1 = new Customer("11", "Hari", "ktm", "9834675382", "1995-02-02",
                "annie@gmail.com", "Savings", "9834675382", "ann");
    }
    
//    @After
//    public void tearDown() {
//        // Clean up the test data (optional)
//        if (testCustomer != null) {
//            customerRepository.deleteCustomer(testCustomer.getId());
//        }
//    }
    
    @Test
    public void testCreateCustomer(){
        
        customerRepository.createCustomer(testCustomer);
        customerRepository.createCustomer(testCustomer1);
        Customer createdCustomer = customerRepository.readCustomer(testCustomer.getId());

        assertNotNull(createdCustomer);
        assertEquals(testCustomer.getName(), createdCustomer.getName());
        assertEquals(testCustomer.getAddress(), createdCustomer.getAddress());
        assertEquals(testCustomer.getContact(), createdCustomer.getContact());
        assertEquals(testCustomer.getDob(), createdCustomer.getDob());
        assertEquals(testCustomer.getEmail(), createdCustomer.getEmail());
        assertEquals(testCustomer.getProductType(), createdCustomer.getProductType());
        assertEquals(testCustomer.getUsername(), createdCustomer.getUsername());
        assertEquals(testCustomer.getPassword(), createdCustomer.getPassword());
   
    }
    
    @Test
    public void testReadCustomer(){
        
        Customer retrievedCustomer = customerRepository.readCustomer(testCustomer.getId());

        assertNotNull(retrievedCustomer);
        assertEquals(testCustomer.getId(), retrievedCustomer.getId());
        assertEquals(testCustomer.getName(), retrievedCustomer.getName());
        assertEquals(testCustomer.getAddress(), retrievedCustomer.getAddress());
        assertEquals(testCustomer.getContact(), retrievedCustomer.getContact());
        assertEquals(testCustomer.getDob(), retrievedCustomer.getDob());
        assertEquals(testCustomer.getEmail(), retrievedCustomer.getEmail());
        assertEquals(testCustomer.getProductType(), retrievedCustomer.getProductType());
        assertEquals(testCustomer.getUsername(), retrievedCustomer.getUsername());
        assertEquals(testCustomer.getPassword(), retrievedCustomer.getPassword()); 
        
    }
    
    @Test
    public void testGetAllCustomers(){  
        List<Customer> customers = customerRepository.getAllCustomers();
        assertNotNull(customers);
        assertEquals(5, customers.size());
        
    }
    
    @Test
    public void testUpdateCustomer(){
        
        testCustomer1.setName("Harry");
        testCustomer1.setAddress("USA");
        testCustomer1.setContact("9851094818");
        testCustomer1.setDob("2000-10-09");
        testCustomer1.setEmail("harry@gmail.com");
        testCustomer1.setProduct_type("Fixed Deposits");
        testCustomer1.setUsername("9851094818");
        testCustomer1.setPassword("harry");

        customerRepository.updateCustomer(testCustomer1);

        Customer updatedCustomer = customerRepository.readCustomer(testCustomer1.getId());
        
        assertNotNull(updatedCustomer);
        assertEquals(testCustomer1.getName(), updatedCustomer.getName());
        assertEquals(testCustomer1.getAddress(), updatedCustomer.getAddress());
        assertEquals(testCustomer1.getContact(), updatedCustomer.getContact());
        assertEquals(testCustomer1.getDob(), updatedCustomer.getDob());
        assertEquals(testCustomer1.getEmail(), updatedCustomer.getEmail());
        assertEquals(testCustomer1.getProductType(), updatedCustomer.getProductType());
        assertEquals(testCustomer1.getUsername(), updatedCustomer.getUsername());
        assertEquals(testCustomer1.getPassword(), updatedCustomer.getPassword());
        
    }
    
    @Test
    public void testDeleteCustomer(){
        
        customerRepository.deleteCustomer(testCustomer.getId());    
        Customer deletedCustomer = customerRepository.readCustomer(testCustomer.getId());
        assertNull(deletedCustomer);
        
        
    }    
    
    
    
}
