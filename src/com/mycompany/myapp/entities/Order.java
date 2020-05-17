/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author helmi
 */
public class Order {
     private int Id_Order;
    private int nbrOrder;
    private int IdePanier;
    private String Name;
     private String Last_Name;
      private String Email;
      private int Number;
    private String Date;

    public Order(String Name) {
        this.Name = Name;
    }
    
    

    public Order( String Last_Name,String Name, String Email, int Number) {
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.Email = Email;
        this.Number = Number;
    }

    public Order() {
       
    }

    public Order(int parseInt) {
        
    }

    

     
    

    public int getId_Order() {
        return Id_Order;
    }

    public int getNbrOrder() {
        return nbrOrder;
    }

    public int getIdePanier() {
        return IdePanier;
    }

    public String getName() {
        return Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public int getNumber() {
        return Number;
    }

    public String getDate() {
        return Date;
    }

    public void setId_Order(int Id_Order) {
        this.Id_Order = Id_Order;
    }

    public void setNbrOrder(int nbrOrder) {
        this.nbrOrder = nbrOrder;
    }

    public void setIdePanier(int IdePanier) {
        this.IdePanier = IdePanier;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Order{" + "Id_Order=" + Id_Order + ", Name=" + Name + ", Last_Name=" + Last_Name + ", Email=" + Email + ", Number=" + Number + '}';
    }

    
    
    
    
}
