/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dulanji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Stock {
    
    Integer goodid;
    Integer usedQty;
    Integer totalQty;
    Integer waste;
    String name;
    
    public Stock(){}
    
    public Stock(Integer goodid,Integer usedQty,Integer totalQty,String name)
    {
        this.goodid = goodid;
        this.usedQty= usedQty;
        this.totalQty =totalQty;
        
    }
    
    public Stock getStock(Integer id){
        Stock stock = new Stock();
        try {
            String sql = "Select * from stock where id = "+id+";";
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","1234");
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next() ) {
                return null;
        } else {

            do {
                stock.goodid = id;
                stock.usedQty = Integer.parseInt(rs.getString("used"));
                stock.totalQty=Integer.parseInt(rs.getString("qty"));
                stock.name=rs.getString("name");
                
                stock.waste = rs.getInt("qty") - rs.getInt("used");
                
            } while (rs.next());
        }
            con.close(); 
        }

        catch(Exception e) {
            System.out.println(e);
            return null;
        }
        return stock;
        
    }
    
    
}
