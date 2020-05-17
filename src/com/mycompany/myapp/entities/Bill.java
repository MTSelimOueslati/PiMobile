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
public class Bill {
    private int Id_Bill;
    private double Ammount;
    private int Id_Item;
    private  int Id_Client;
    private String Name;
    private String Last_Name;
    private float Price;

    public Bill(int Id_Bill, double Ammount, String Name, String Last_Name) {
        this.Id_Bill = Id_Bill;
        this.Ammount = Ammount;
        this.Name = Name;
        this.Last_Name = Last_Name;
    }

    public Bill(int Id_Bill, double Ammount, int Id_Item, int Id_Client, String Name, String Last_Name, float Price) {
        this.Id_Bill = Id_Bill;
        this.Ammount = Ammount;
        this.Id_Item = Id_Item;
        this.Id_Client = Id_Client;
        this.Name = Name;
        this.Last_Name = Last_Name;
        this.Price = Price;
    }

    public Bill() {
        
    }

    public Bill(double Ammount, String Name, String Last_Name) {
        this.Ammount = Ammount;
        this.Name = Name;
        this.Last_Name = Last_Name;
    }

    

    
    public Bill( String Name, String Last_Name) {
      
        this.Name = Name;
        this.Last_Name = Last_Name;
    }

    
    

    public int getId_Bill() {
        return Id_Bill;
    }

    public double getAmmount() {
        return Ammount;
    }

    public int getId_Item() {
        return Id_Item;
    }

    public int getId_Client() {
        return Id_Client;
    }

    public String getName() {
        return Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setId_Bill(int Id_Bill) {
        this.Id_Bill = Id_Bill;
    }

    public void setAmmount(double Ammount) {
        this.Ammount = Ammount;
    }

    public void setId_Item(int Id_Item) {
        this.Id_Item = Id_Item;
    }

    public void setId_Client(int Id_Client) {
        this.Id_Client = Id_Client;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Bill{" + "Id_Bill=" + Id_Bill + ", Ammount=" + Ammount + ", Name=" + Name + ", Last_Name=" + Last_Name + '}';
    }

    public void setNumber(int i) {
        
    }
    
    
    
    
}
