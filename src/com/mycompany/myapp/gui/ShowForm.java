/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.services.ServiceOrder;
import com.mycompany.myapp.services.ServiceShoppingcart;
import com.mycompany.myapp.services.ServiceVelovendre;

/**
 *
 * @author helmi
 */
public class ShowForm extends Form{
    Form current;
    SpanLabel lb;
public ShowForm() {
    current=this;
        
        setTitle("Your Shopping Cart");
       
        
        lb = new SpanLabel("");
        add(lb);
        ServiceShoppingcart rep=new ServiceShoppingcart();   
        
        lb.setText(rep.getList2().toString());
        
   
        
        
          
      
       
        
    }

  
}
