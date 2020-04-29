/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.codename1.ui.List;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ContainerList;


/**
 *
 * @author taieb
 */
public class ListAssociForm extends Form {
    
    Form current;
    private List list;    
    private ContainerList listContainer; 
    
    public ListAssociForm(String Login) {
        
        setTitle("Liste Enfants");
        setLayout(BoxLayout.y());

      
    }
}
