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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class Wastage 
{
    Integer goodid;
    Integer usedQty;
    Integer totalQty;
    Integer wastage;
    String date;
    
    
    public Wastage(){}
    
    public Wastage(Integer goodid,Integer usedQty,Integer totalQty,Integer wastage,String date)
    {
        this.goodid = goodid;
        this.usedQty= usedQty;
        this.totalQty =totalQty;
        this.wastage = wastage;
        this.date = date;
    }
    
    public boolean insertWastage(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juice_bar","root","1234");
           
            Statement statement = con.createStatement();

            statement.executeUpdate("INSERT INTO wastage (`goodid`, `used_qty`, `total_qty`,`wastage`,`date` ) VALUES ('"+this.goodid+"', '"+this.usedQty+"', '"+this.totalQty+"', '"+this.wastage+"','"+this.date+"')");

            con.close(); 
        }

        catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
        
    }
    
    public boolean updateWastage(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con2= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","mandira123");
           
            Statement statement = con2.createStatement();
            System.out.print(this.goodid);
            statement.executeUpdate("UPDATE wastage SET  `used_qty` = '"+this.usedQty+"', `total_qty`='"+this.totalQty+"',`wastage`='"+this.wastage+"',`date`='"+this.date+"' where `goodid` = '"+this.goodid+"' ; " );

            con2.close(); 
        }

        catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
        
    }
    
    
    public boolean deleteWastage(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","mandira123");
           
            Statement statement = con.createStatement();

            statement.executeUpdate("DELETE from wastage where `goodid` = '"+this.goodid+"' ; ");
            con.close(); 
        }

        catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
        
    }
    
    public List getWastage(){
    
        List list = new ArrayList();

        try {
            String sql = "Select * from wastage ;";
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","mandira123");
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (!rs.next() ) {
                return null;
        } else {

            do {
                Wastage w = new Wastage();
                
                w.goodid = Integer.parseInt(rs.getString("goodid"));;
                w.usedQty = Integer.parseInt(rs.getString("used_qty"));
                w.totalQty=Integer.parseInt(rs.getString("total_qty"));
                w.wastage = Integer.parseInt(rs.getString("wastage"));
                w.date = rs.getString("date");
                
                list.add(w);
                
            } while (rs.next());
        }
            con.close(); 
        }

        catch(Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
        
    }
    
}
