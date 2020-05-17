/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Bill;
import com.mycompany.myapp.entities.Order;
import com.mycompany.myapp.entities.Shoppingcart;
import com.mycompany.myapp.entities.Velovendre;
import com.mycompany.myapp.services.ServiceBill;
import com.mycompany.myapp.services.ServiceOrder;
import com.mycompany.myapp.services.ServiceShoppingcart;
import com.mycompany.myapp.services.ServiceVelovendre;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author helmi
 */
public class CartForm extends Form{
    Form current;
    public CartForm(  ) {
        current=this;
        Velovendre v = new Velovendre();
    

        ServiceVelovendre s = new ServiceVelovendre();
        setTitle("Please pick your item");
        setLayout(BoxLayout.y());
        ComboBox cb= new ComboBox();
        //cb.addItem("Scott Spark");
        //cb.addItem(""+ s.getList2().toString());
      
        //cb.addItem("park");
        // ArrayList<Velovendre> listTasks = new ArrayList<>();
         
        ArrayList<Velovendre> velo = new ArrayList<>();
                   Velovendre v1 = new Velovendre(2, 80, "Scott Spark");
                   Velovendre v2 = new Velovendre(3,50, "park");
                   Velovendre v3 = new Velovendre(42,200, "Alta");
                   Velovendre v4 = new Velovendre(49,12, "ff");
                   Velovendre v5 = new Velovendre(53,5, "jjjj");
                   Velovendre v6 = new Velovendre(50,2, "boom");
                   Velovendre v7 = new Velovendre(54,12, "Alta");
                   
                   velo.add(v1);
                   velo.add(v2);
                   velo.add(v3);
                   velo.add(v4);
                   velo.add(v5);
             velo.add(v6);
velo.add(v7);
             
           for(Velovendre velos : velo){
                 cb.addItem(""+velos.getMarque());
           }
            
             
         
        add(cb);
        Container c1 = new Container();
        Label l1 = new Label("Ammount:");
        TextField t1 = new TextField();
        c1.add(l1);
        c1.add(t1);
      add(c1);
      Button add = new Button("add to cart");
      add(add);
      add.addActionListener((ActionEvent e) -> {
            ServiceShoppingcart ser = new ServiceShoppingcart();
          //  reponse rep = new reponse();
            Shoppingcart t = new Shoppingcart( Integer.parseInt(t1.getText()));
            ser.ajoutTask(t);
            Form Show=new Form("Your Shopping Cart", BoxLayout.y());
          
           
        //  if(cb.getSelectedItem().toString().equalsIgnoreCase("Scott Spark")){
               
        
                    
                    Label p = new Label ("marque :"+cb.getSelectedItem());
                    
                   
                    
                    Label p1 = new Label("price : "+v1.getPrice());
                   
                   
                    Label p2= new Label("Ammount:"+t1.getText());
                    Container c2 = new Container(BoxLayout.y());
                    c2.add(p);
                    c2.add(p1);
                    c2.add(p2);
                   
                     Show.add(c2);
                   
                    
                    
                    
                    
                    
                    
//            if(cb.getSelectedItem().toString().equalsIgnoreCase("park")){
//                       
//                    Label p = new Label ("marque : park");
//                    Label p1 = new Label("price:"+v2.getPrice());
//                    Label p2= new Label("Ammount:"+t1.getText());
//                    Container c3 = new Container(BoxLayout.y());
//                    c3.add(p);
//                    c3.add(p1);
//                    c3.add(p2);
//                    Show.add(c3);} 
      
            Container c5 = new Container(BoxLayout.x());
            Button d = new Button("delete");
            c5.add(d);
             Show.add(c5);
            
             Button c = new Button("Order");
             
        Show.add(c);
       
        d.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   Form Show2=new Form("Your Shopping Cart", BoxLayout.y());
                   Container c6 = new Container(BoxLayout.yCenter());
                   Button c1 = new Button("Order");
                   c6.add(c1);
                   Show2.add(c6);
                   c1.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent evt) {
                           if(Dialog.show("Error", "Your Shopping Cart Is Empty! ", "Ok", null)){
                               current.show();
                           }
                       }
                   });
                   Show2.show();
                }
                
            });
      
        c.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
           Form order= new Form("Order", BoxLayout.y());
           
        
           
           SpanLabel lb;
            lb = new SpanLabel("");
        add(lb);
          
        Container co = new Container();
        Label o1= new Label("Name : ");
        TextField name = new TextField();
        co.add(o1);
        co.add(name);
         Container co1 = new Container();
        Label o2= new Label("Last Name : ");
        TextField ln = new TextField();
        co1.add(o2);
        co1.add(ln);
         Container co3 = new Container();
        Label o3= new Label("Email : ");
        TextField mail= new TextField();
        co3.add(o3);
        co3.add(mail);
        Container co4= new Container();
        Label o4= new Label("Number : ");
        TextField num= new TextField();
        co4.add(o4);
        co4.add(num);
        order.add(co);
        order.add(co1);
        order.add(co3);
        order.add(co4);
       
        Button cancel = new Button("Cancel");
        cancel.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                   Show.show();
                   
               }
           });
        Container c8=new Container(BoxLayout.x());
        c8.add(cancel);
      
      
   
        
        
        Button e = new Button("Confirm");
        c8.add(e);
        order.add(c8);
        e.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent evt) {
                   
                    Message m = new Message("Your Order Is Confirmed Thank you for Shopping!");
        Display.getInstance().sendMessage(new String[]{mail.getText()}, "Order Confirmation", m);
        
     
                  ServiceOrder ser = new ServiceOrder();
                   Form bill= new Form("Your bill", BoxLayout.y());
                  Order t = new Order(name.getText(), ln.getText(),mail.getText(),Integer.parseInt(num.getText()));
                  ser.ajoutTask(t);
                  if(Dialog.show("Confirmation", "Your Order Is Confirmed! ", "Ok", null))
                                           bill.show();
                 
                  Label b1 = new Label("Name: "+name.getText());
               
                   Label b2 = new Label("Last Name: "+ln.getText());
                    //Label b3 = new Label("Ammount: "+t1.getText());
                    Label b3 = new Label("Total "+p1.getText());
                    bill.add(b1);
                    bill.add(b2);
                    bill.add(b3);
                    Button bu= new Button("ok");
                    bill.add(bu);
                    bu.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                          
                          if(Dialog.show("Done!", "Thank you for Shopping! ", "Ok", null))
                                           current.show();
                           ServiceBill sb = new ServiceBill();
                     Bill bi = new Bill(name.getText(), ln.getText());
                 
                  sb.ajoutTask(bi);
                         
                      }
                  }
                    );
                    ServiceBill sb = new ServiceBill();
                     Bill bi = new Bill(Integer.parseInt(t1.getText()),name.getText(), ln.getText());
                 
                  sb.ajoutTask(bi);
                    
                   bill.show();
                  
                  
        }
                
              
           });
       
        order.show();
        Show.show();   }
    });
            
          Show.show(); 
      
       
      });
    
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, (e)->{

            VeloView ev = new VeloView(); 
            ev.getForm().show();
        });           

        
            
        
        
        
        
    
    
}
}