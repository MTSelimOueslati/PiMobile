/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author taieb
 */
public class Association {
     private int id;
    private String name;
    private String description;
    private String logo;
    private String location;
    private String website;

    public Association(int id, String name, String description, String logo, String location, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.location = location;
        this.website = website;
    }

    public Association(String name, String description, String logo, String location, String website) {
        this.name = name;
        this.description = description;
        this.logo = logo;
        this.location = location;
        this.website = website;
    }

    public Association() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Association{" + "id=" + id + ", name=" + name + ", description=" + description + ", logo=" + logo + ", website=" + website + '}';
    }
    
    
}
