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
public class Shoppingcart {
    private int Id_Panier;
    private double Ammount;
    private int ide_Produit;

    public Shoppingcart(int Id_Panier, double Ammount, int ide_Produit) {
        this.Id_Panier = Id_Panier;
        this.Ammount = Ammount;
        this.ide_Produit = ide_Produit;
    }

    public Shoppingcart(double Ammount) {
        this.Ammount = Ammount;
    }

    public Shoppingcart(double Ammount, int ide_Produit) {
        this.Ammount = Ammount;
        this.ide_Produit = ide_Produit;
    }

    public Shoppingcart() {
        
    }

    public int getId_Panier() {
        return Id_Panier;
    }

    public double getAmmount() {
        return Ammount;
    }

    public int getIde_Produit() {
        return ide_Produit;
    }

    public void setId_Panier(int Id_Panier) {
        this.Id_Panier = Id_Panier;
    }

    public void setAmmount(double Ammount) {
        this.Ammount = Ammount;
    }

    public void setIde_Produit(int ide_Produit) {
        this.ide_Produit = ide_Produit;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" + "Id_Panier=" + Id_Panier + ", Ammount=" + Ammount + ", ide_Produit=" + ide_Produit + '}';
    }
    
    
    
}
