/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author taieb
 */
public class AssociationsManagement extends Form {
    
    Form current;
    public AssociationsManagement() {
        current=this;
        setTitle("Associations Management");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAdd = new Button("Add Association");
        Button btnList = new Button("List Associations");
        
        
        btnAdd.addActionListener(e-> new AddAssociationForm(current).show());
        btnList.addActionListener(e-> new ListAssociationForm(current).show());
        addAll(btnAdd,btnList);
        
        
    }
    
}
