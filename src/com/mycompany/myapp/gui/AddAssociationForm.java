/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Association;
import com.mycompany.myapp.services.ServiceAssociation;

/**
 *
 * @author taieb
 */
public class AddAssociationForm extends Form {
        public AddAssociationForm(Form previous) {
        setTitle("Add a new association");
        setLayout(BoxLayout.y());
        
        TextField name = new TextField("","Association Name");
        TextField description = new TextField("","Description");
        TextField logo = new TextField ("","Logo");
        TextField location = new TextField ("","Location");
        TextField website = new TextField ("","Website");
        Button btnValider = new Button("Add Association");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((name.getText().length()==0)||(logo.getText().length()==0)||(location.getText().length()==0)||(website.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Association a = new Association(name.getText(),description.getText(),logo.getText(),location.getText(),website.getText());
                        if( ServiceAssociation.getInstance().addAssociation(a))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Errors", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(name,description,logo,website,location,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
}
