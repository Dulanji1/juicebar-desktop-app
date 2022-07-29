/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.finance_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Prabhashwara
 */
public class DBConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","1234");
            System.out.println("connected");
        } catch(SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
    
}
