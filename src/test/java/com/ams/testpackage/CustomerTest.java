/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.testpackage;
import com.ams.repository.JDBCCustomerRepository;
import com.ams.model.Customer;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.util.*;

/**
 *
 * @author avni
 */
public class CustomerTest {
    
    private static JDBCCustomerRepository customerRepository;
    private static Customer testCustomer;
    private static Customer testCustomer1;
    
    
    
    @BeforeClass
    public static void setUp(){
        
        customerRepository = new JDBCCustomerRepository();
        testCustomer = new Customer("25", "Rishi", "ktm", "9834675382", "1995-02-02",
                "ria@gmail.com", "Savings", "9834675382", "rishi");
        testCustomer1 = new Customer("26", "Annie", "ktm", "9834675382", "1995-02-02",
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
        assertEquals(20, customers.size());
        
    }
    
    @Test
    public void testUpdateCustomer(){
        
        testCustomer.setName("Harry");
        testCustomer.setAddress("USA");
        testCustomer.setContact("9851094818");
        testCustomer.setDob("2000-10-09");
        testCustomer.setEmail("harry@gmail.com");
        testCustomer.setProduct_type("Fixed Deposits");
        testCustomer.setUsername("9851094818");
        testCustomer.setPassword("harry");

        customerRepository.updateCustomer(testCustomer);

        Customer updatedCustomer = customerRepository.readCustomer(testCustomer.getId());
        
        assertNotNull(updatedCustomer);
        assertEquals(testCustomer.getName(), updatedCustomer.getName());
        assertEquals(testCustomer.getAddress(), updatedCustomer.getAddress());
        assertEquals(testCustomer.getContact(), updatedCustomer.getContact());
        assertEquals(testCustomer.getDob(), updatedCustomer.getDob());
        assertEquals(testCustomer.getEmail(), updatedCustomer.getEmail());
        assertEquals(testCustomer.getProductType(), updatedCustomer.getProductType());
        assertEquals(testCustomer.getUsername(), updatedCustomer.getUsername());
        assertEquals(testCustomer.getPassword(), updatedCustomer.getPassword());
        
    }
    
    @Test
    public void testDeleteCustomer(){
        
        customerRepository.deleteCustomer(testCustomer.getId());    
        Customer deletedCustomer = customerRepository.readCustomer(testCustomer.getId());
        assertNull(deletedCustomer);
        
        
    }
    
}
