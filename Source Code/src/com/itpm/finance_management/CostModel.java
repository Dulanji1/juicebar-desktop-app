/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.finance_management;

/**
 *
 * @author Prabhashwara
 */
public class CostModel {
    
    private String cDate;
    private double elecBill;
    private double waterBill;
    private double rent;
    private double tele;
    private double trans;
    private double equi;
    private double other;

    public String getcDate() {
        return cDate;
    }

    public double getElecBill() {
        return elecBill;
    }

    public double getWaterBill() {
        return waterBill;
    }

    public double getRent() {
        return rent;
    }

    public double getTele() {
        return tele;
    }

    public double getTrans() {
        return trans;
    }

    public double getEqui() {
        return equi;
    }

    public double getOther() {
        return other;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public void setElecBill(double elecBill) {
        this.elecBill = elecBill;
    }

    public void setWaterBill(double waterBill) {
        this.waterBill = waterBill;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public void setTele(double tele) {
        this.tele = tele;
    }

    public void setTrans(double trans) {
        this.trans = trans;
    }

    public void setEqui(double equi) {
        this.equi = equi;
    }

    public void setOther(double other) {
        this.other = other;
    }
    
}
