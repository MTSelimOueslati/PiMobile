/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.ArrayList;

/**
 *
 * @author helmi
 */
public class Velovendre {

   
    private int id;
    private double price;
    private String marque;
    private String Path_photo;
    private int nombre;

    public Velovendre(int id, double price, String marque, String Path_photo, int nombre) {
        this.id = id;
        this.price = price;
        this.marque = marque;
        this.Path_photo = Path_photo;
        this.nombre = nombre;
    }

    public Velovendre(double price) {
        this.price = price;
    }
    
    

    public Velovendre(int id, double price, String marque) {
        this.id = id;
        this.price = price;
        this.marque = marque;
    }

    public Velovendre(double price, String marque) {
        this.price = price;
        this.marque = marque;
    }

    public Velovendre() {
        
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getMarque() {
        return marque;
    }

    public String getPath_photo() {
        return Path_photo;
    }

    public int getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPath_photo(String Path_photo) {
        this.Path_photo = Path_photo;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Velovendre{" + "id=" + id + ", price=" + price + ", marque=" + marque + '}';
    }

  
    
    
}
