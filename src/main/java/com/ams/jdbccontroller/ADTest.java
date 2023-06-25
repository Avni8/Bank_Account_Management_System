/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ams.jdbccontroller;

import com.ams.controller.UpdateAccountDetails;
import com.ams.controller.UpdateCustomerDetails;
import java.util.Scanner;

/**
 *
 * @author avni
 */
public class ADTest {

    public static void main(String[] args) throws Exception {
        Boolean exit = Boolean.FALSE;
        while (!exit) {
            System.out.println("Enter 1 to continue 0 to exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            exit = choice == 0;
        }

    }

}
