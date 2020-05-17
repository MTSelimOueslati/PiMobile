/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Order;
import com.mycompany.myapp.services.ServiceOrder;
import com.mycompany.myapp.services.ServiceVelovendre;

/**
 *
 * @author helmi
 */
public class OrderForm extends Form{
     SpanLabel lb;
    Form current;
      
    public OrderForm() {
        current=this;
        
        setTitle("Please Confirm Your Order");
       
        
      SpanLabel lb;
            lb = new SpanLabel("");
        add(lb);
         
       
        Label o1= new Label("Name : ");
        TextField name = new TextField();
        add(o1);
        add(name);
        
        Label o2= new Label("Last Name : ");
        TextField ln = new TextField();
        add(o2);
        add(ln);
        
        Label o3= new Label("Email : ");
        TextField mail= new TextField();
        add(o3);
        add(mail);
        
        Label o4= new Label("Number : ");
        TextField num= new TextField();
        
       add(o4);
       add(num);
//        add(co);
//        add(co1);
//        add(co3);
//       add(co4);
        
        Button b= new Button("Confirm");
        add(b);
        b.addActionListener((e) -> {
            ServiceOrder ser = new ServiceOrder();
          //  reponse rep = new reponse();
            Order t = new Order(name.getText(), ln.getText(),mail.getText(),Integer.parseInt(num.getText()));
            ser.ajoutTask(t);
        
    
        
        
          
        
        
    
    
});
                }
}
