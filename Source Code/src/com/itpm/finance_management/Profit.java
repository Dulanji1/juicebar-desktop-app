/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.finance_management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Prabhashwara
 */
public class Profit extends javax.swing.JFrame {

    /**
     * Creates new form CostManage
     */
    public Profit() {
        initComponents();
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private ArrayList<CostModel> getCost() {
        
        ArrayList<CostModel> cm = new ArrayList<>();
        Connection con = DBConnection.getConnection();

        String query = "select * from finance order by cDate";

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            
            while(rs.next()) {
                CostModel cModel = new CostModel();
                cModel.setcDate(rs.getString("cDate"));
                cModel.setElecBill(rs.getDouble("elecBill"));
                cModel.setWaterBill(rs.getDouble("waterBill"));
                cModel.setRent(rs.getDouble("rent"));
                cModel.setTele(rs.getDouble("phoneBill"));
                cModel.setTrans(rs.getDouble("transport"));
                cModel.setEqui(rs.getDouble("equipment"));
                cModel.setOther(rs.getDouble("other"));
                cm.add(cModel);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        
        return cm;
    }
    
    private double totalIncome(String dates) {
        Connection con = DBConnection.getConnection();
        
        double t = 0.0;
        
        String query = "select income from totalIncome where dates='" + dates + "'";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                t = rs.getDouble("income");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return t;
    }
    
    private void calcProfit() {
        
        ArrayList<CostModel> cm = getCost();
        System.out.println(cm);
        
        DefaultTableModel model = (DefaultTableModel)tab_profit.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        
        for(int i=0; i<cm.size(); i++) {
            row[0] = cm.get(i).getcDate();
            
            double cost = (cm.get(i).getElecBill() +
                    cm.get(i).getWaterBill()+
                    cm.get(i).getRent()+
                    cm.get(i).getTele()+
                    cm.get(i).getTrans()+
                    cm.get(i).getEqui()+
                    cm.get(i).getOther());
            
            double t = totalIncome(cm.get(i).getcDate());
            
            row[1] = cost;
            
            row[2] = t;
            
            row[3] = t - cost;
            
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        btn_income = new javax.swing.JButton();
        btn_cost = new javax.swing.JButton();
        btn_profit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_profit = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btn_calcProfit = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_chart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGap(18, 18, 18)
                .addComponent(btn_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_profit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sumudu Juice Bar");
        jLabel1.setOpaque(true);

        tab_profit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tab_profit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Cost", "Income", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab_profit);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Profit");

        btn_calcProfit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_calcProfit.setText("Calculate Profite");
        btn_calcProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcProfitActionPerformed(evt);
            }
        });

        btn_print.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_chart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_chart.setText("Chart");
        btn_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btn_calcProfit)
                .addGap(211, 211, 211)
                .addComponent(btn_chart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_print)
                .addGap(44, 44, 44))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_calcProfit)
                        .addComponent(btn_chart))
                    .addComponent(btn_print))
                .addGap(0, 143, Short.MAX_VALUE))
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

    private void btn_calcProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcProfitActionPerformed
        // TODO add your handling code here:
        calcProfit();
    }//GEN-LAST:event_btn_calcProfitActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        // TODO add your handling code here:
        
        MessageFormat header = new MessageFormat("Profit Report");
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        
        try {
            tab_profit.print(JTable.PrintMode.NORMAL, header, footer);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_incomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_incomeActionPerformed
        // TODO add your handling code here:
        IncomeManage2 income = new IncomeManage2();
        income.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_incomeActionPerformed

    private void btn_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_costActionPerformed
        // TODO add your handling code here:
        CostManage c = new CostManage();
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_costActionPerformed

    private void btn_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chartActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tab_profit.getModel();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int i=0; i < tab_profit.getRowCount(); i++) {
            String x = model.getValueAt(i, 3).toString();
            String d = model.getValueAt(i, 0).toString();
            double y = Double.parseDouble(x);
            
            
            dataset.setValue(y, "Profit", d);
        }
        
        JFreeChart jc = ChartFactory.createBarChart("Profit", "Dates", "Profit", dataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p = jc.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame f = new ChartFrame("Profit", jc);
        f.setVisible(true);
        f.setSize(720, 580);
    }//GEN-LAST:event_btn_chartActionPerformed

    private void btn_profitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profitActionPerformed
        // TODO add your handling code here:
         Profit profit = new Profit();
        profit.setVisible(true);
        dispose();
      
    }//GEN-LAST:event_btn_profitActionPerformed

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
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_calcProfit;
    private javax.swing.JButton btn_chart;
    private javax.swing.JButton btn_cost;
    private javax.swing.JButton btn_income;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_profit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_profit;
    // End of variables declaration//GEN-END:variables
}
