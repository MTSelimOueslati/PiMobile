package com.mycompany.myapp.gui;


import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;


public class BaseVelo {
    
    private Form form;
    
    public void addToolBar(Toolbar tb){
        tb.addMaterialCommandToOverflowMenu("Bikes List", FontImage.MATERIAL_HOME, (e)->{

            VeloView ev = new VeloView(); 
            ev.getForm().show();
        });
        
        tb.addMaterialCommandToOverflowMenu("Add a Bike", FontImage.MATERIAL_ADD_BOX, (e)->{

            AddVelo addEvent = new AddVelo();
            addEvent.getForm().show();
            
        });
        tb.addMaterialCommandToOverflowMenu("Logout", FontImage.MATERIAL_LOCK, (e)->{
            new LoginForm(form).show();
        });
    }
    
}
