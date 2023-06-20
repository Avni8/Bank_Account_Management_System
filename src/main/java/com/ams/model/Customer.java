/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.model;

/**
 *
 * @author avni
 */
public class Customer {
    
    private String id;
    private String name;
    private String address;
    private String contact;
    private String dob;
    private String email; 
    private String product_type;
    private String username;
    private String password;

    public Customer(String id, String name, String address, String contact, String dob, String email, 
                    String product_type, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.email = email;
        this.product_type = product_type;
        this.username = username;
        this.password = password;
    }
    
    
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getContact() {
        return contact;
    }
    
    public String getDob() {
        return dob;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getProductType() {
        return product_type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}

    

