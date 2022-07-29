/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.finance_management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Prabhashwara
 */
public class CostManage extends javax.swing.JFrame {
    
    String vDate, vEB, vWB, vRent, vTB, vTrans, vEQ, vOt;

    /**
     * Creates new form CostManage
     */
    public CostManage() {
        initComponents();
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void saveData() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            vDate = df.format(date_save.getDate());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Date Field is empty");
            System.out.println(e);
        }
        
        vEB = txt_electricityBill.getText();    
        vWB = txt_waterBill.getText();
        vRent = txt_rent.getText();
        vTB = txt_telephone.getText();
        vTrans = txt_transport.getText();
        vEQ = txt_equipment.getText();
        vOt = txt_other.getText();
        
        if(vRent.isEmpty() || vTrans.isEmpty()) {
            JOptionPane.showMessageDialog(null, "One or more required field is empty");
        } else {
            double vEBf = 0;
            double vWB1 = 0;
            double vRent1 = 0;
            double vTB1 = 0;
            double vTrans1 = 0;
            double vEQ1 = 0;
            double vOt1 = 0;
            
            if(!vEB.isEmpty()) {
                try {
                    vEBf = Double.parseDouble(vEB);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vWB.isEmpty() ) {
                try {
                   vWB1 = Double.parseDouble(vWB); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vRent.isEmpty() ) {
                try {
                   vRent1 = Double.parseDouble(vRent); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vTB.isEmpty() ) {
                try {
                   vTB1 = Double.parseDouble(vTB); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vTrans.isEmpty() ) {
                try {
                   vTrans1 = Double.parseDouble(vTrans); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vEQ.isEmpty() ) {
                try {
                   vEQ1 = Double.parseDouble(vEQ); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }
            
            if( !vOt.isEmpty() ) {
                try {
                   vOt1 = Double.parseDouble(vOt); 
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    return;
                }
            }

            Connection connection = DBConnection.getConnection();

            String query = "insert into finance(cDate, elecBill, waterBill, rent, phoneBill, transport, equipment, other) values('" + vDate + "', " + vEBf + " , " + vWB1 + " , " + vRent1
                    + " , " + vTB1 + " , " + vTrans1 + " , " + vEQ1 + " ," + vOt1 + ")";
            
            try {
                Statement statement = connection.createStatement();
                int x = statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data saved successfully");
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error While inserting data");
            }
            
        }
    }
    
    private void viewData( String date ) {
        double eb = 0;
        double wb = 0;
        double r = 0;
        double t = 0;
        double tr = 0;
        double equ7 = 0;
        double o = 0;
        Connection connection = DBConnection.getConnection();
        
        String query = "SELECT * FROM finance where cDate='" + date + "'";
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()) {
                eb = rs.getDouble("elecBill");
                wb = rs.getDouble("waterBill");
                r = rs.getDouble("rent");
                t = rs.getDouble("phoneBill");
                tr = rs.getDouble("transport");
                equ7 = rs.getDouble("equipment");
                o = rs.getDouble("other");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        txt_electricityBill2.setText(String.valueOf(eb));
        txt_waterBill2.setText(String.valueOf(wb));
        txt_rent2.setText(String.valueOf(r));
        txt_telephone2.setText(String.valueOf(t));
        txt_transport2.setText(String.valueOf(tr));
        txt_equipment2.setText(String.valueOf(equ7));
        txt_other2.setText(String.valueOf(o));        
            
    }
    
    private void deleteData( String date ) {
        
        Connection connection = DBConnection.getConnection();
        
        String query = "delete from finance where cDate='" + date + "'";
            
            try {
                Statement statement = connection.createStatement();
                int x = statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Delete successfully");
            } catch(Exception e) {
                e.printStackTrace();
            }
        
    }
    
    private void updateData( String date) {
        
        String elec = txt_electricityBill2.getText();
        double elect = Double.parseDouble(elec);
        
        String water = txt_waterBill2.getText();
        double wat = Double.parseDouble(water);
        
        String rent = txt_rent2.getText();
        double ren = Double.parseDouble(rent);
        
        String tele = txt_telephone2.getText();
        double tel = Double.parseDouble(tele);
        
        String trans = txt_transport2.getText();
        double tra = Double.parseDouble(trans);
        
        String uEquipment = txt_equipment2.getText();
        double uEquipment1 = Double.parseDouble(uEquipment);
        
        String uOther = txt_other2.getText();
        double uOther1 = Double.parseDouble(uOther);
        
        Connection connection = DBConnection.getConnection();
        
        String query = "update finance set elecBill=" + elect + ", waterBill=" + wat + ", rent=" + ren +
                ", phoneBill=" + tel + ", transport=" + tra + ", equipment=" + uEquipment1 + ", other=" + uOther1
                + "where cDate='" + date + "'";
            
            try {
                Statement statement = connection.createStatement();
                int x = statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Updated successfully");
            } catch(Exception e) {
                e.printStackTrace();
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        btn_income = new javax.swing.JButton();
        btn_cost = new javax.swing.JButton();
        btn_profit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_electricityBill = new javax.swing.JTextField();
        txt_waterBill = new javax.swing.JTextField();
        txt_rent = new javax.swing.JTextField();
        txt_telephone = new javax.swing.JTextField();
        txt_transport = new javax.swing.JTextField();
        txt_equipment = new javax.swing.JTextField();
        txt_other = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        txt_waterBill2 = new javax.swing.JTextField();
        txt_electricityBill2 = new javax.swing.JTextField();
        txt_rent2 = new javax.swing.JTextField();
        txt_telephone2 = new javax.swing.JTextField();
        txt_transport2 = new javax.swing.JTextField();
        txt_equipment2 = new javax.swing.JTextField();
        txt_other2 = new javax.swing.JTextField();
        btn_view = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        date_save = new com.toedter.calendar.JDateChooser();
        date_view = new com.toedter.calendar.JDateChooser();
        date_delete = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_income.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_income.setText("Income");
        btn_income.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_incomeActionPerformed(evt);
            }
        });

        btn_cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cost.setText("Cost");
        btn_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_costActionPerformed(evt);
            }
        });

        btn_profit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_profit.setText("Profit");
        btn_profit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_income, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btn_income, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btn_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btn_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sumudu Juice Bar");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Today Cost");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Previous Cost");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Date (*)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Electricity Bill");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Water Bill");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Rent of the Building (*)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Telephone");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Transport");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Equipment");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Other");

        txt_electricityBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_electricityBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_electricityBillActionPerformed(evt);
            }
        });

        txt_waterBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_rent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_telephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_transport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_equipment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_other.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setText("(*) Fields is required");

        btn_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_waterBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_waterBill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_waterBill2ActionPerformed(evt);
            }
        });

        txt_electricityBill2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_electricityBill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_electricityBill2ActionPerformed(evt);
            }
        });

        txt_rent2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_rent2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rent2ActionPerformed(evt);
            }
        });

        txt_telephone2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_telephone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telephone2ActionPerformed(evt);
            }
        });

        txt_transport2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_transport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_transport2ActionPerformed(evt);
            }
        });

        txt_equipment2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_equipment2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_equipment2ActionPerformed(evt);
            }
        });

        txt_other2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_other2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_other2ActionPerformed(evt);
            }
        });

        btn_view.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_view.setText("View");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_electricityBill, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_waterBill, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rent, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_transport, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_other, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date_save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 88, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_waterBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_electricityBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_rent2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_telephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_transport2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_equipment2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_other2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(210, 210, 210))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(date_view, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(date_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(btn_save)
                .addGap(98, 98, 98)
                .addComponent(btn_view)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_delete)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_view, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_electricityBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_electricityBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_waterBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_rent2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_waterBill2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telephone2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_transport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_transport2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_equipment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_equipment2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_other, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_other2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_save)
                    .addComponent(btn_view)
                    .addComponent(btn_update)
                    .addComponent(btn_delete))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("jLabel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_electricityBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_electricityBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_electricityBillActionPerformed

    private void txt_waterBill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_waterBill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_waterBill2ActionPerformed

    private void txt_electricityBill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_electricityBill2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_electricityBill2ActionPerformed

    private void txt_rent2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rent2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rent2ActionPerformed

    private void txt_telephone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telephone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telephone2ActionPerformed

    private void txt_transport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_transport2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_transport2ActionPerformed

    private void txt_equipment2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_equipment2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_equipment2ActionPerformed

    private void txt_other2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_other2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_other2ActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String vPDate = df.format(date_view.getDate());
        viewData(vPDate);
    }//GEN-LAST:event_btn_viewActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String uPDate = df.format(date_view.getDate());
        updateData(uPDate);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dDate = df.format(date_delete.getDate());
        deleteData(dDate);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_incomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_incomeActionPerformed
        // TODO add your handling code here:
        IncomeManage2 income = new IncomeManage2();
        income.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_incomeActionPerformed

    private void btn_profitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profitActionPerformed
        // TODO add your handling code here:
        Profit profit = new Profit();
        profit.setVisible(true);
        dispose();
      
    }//GEN-LAST:event_btn_profitActionPerformed

    private void btn_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_costActionPerformed
        // TODO add your handling code here:
         CostManage c = new CostManage();
        c.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_costActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CostManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CostManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CostManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CostManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CostManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cost;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_income;
    private javax.swing.JButton btn_profit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_view;
    private com.toedter.calendar.JDateChooser date_delete;
    private com.toedter.calendar.JDateChooser date_save;
    private com.toedter.calendar.JDateChooser date_view;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txt_electricityBill;
    private javax.swing.JTextField txt_electricityBill2;
    private javax.swing.JTextField txt_equipment;
    private javax.swing.JTextField txt_equipment2;
    private javax.swing.JTextField txt_other;
    private javax.swing.JTextField txt_other2;
    private javax.swing.JTextField txt_rent;
    private javax.swing.JTextField txt_rent2;
    private javax.swing.JTextField txt_telephone;
    private javax.swing.JTextField txt_telephone2;
    private javax.swing.JTextField txt_transport;
    private javax.swing.JTextField txt_transport2;
    private javax.swing.JTextField txt_waterBill;
    private javax.swing.JTextField txt_waterBill2;
    // End of variables declaration//GEN-END:variables
}
