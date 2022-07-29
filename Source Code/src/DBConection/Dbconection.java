/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Dula
 */
public class Dbconection {
    private static Connection conn;
    
    private static void DBConn() throws Exception{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","1234");
    }
    
    public static void iud(String sql) throws Exception{
        if(conn == null){
            DBConn();
        }
        conn.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet search(String sql) throws Exception{
        if(conn == null){
            DBConn();
        }
        return conn.createStatement().executeQuery(sql);
    }
    
    public static Connection getConn() throws Exception{
        if(conn==null)
            DBConn();
        return conn;
    }
}
