/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.myapp.services.ServiceOrder;
import com.mycompany.myapp.services.ServiceVelovendre;

/**
 *
 * @author helmi
 */
public class AfficherForm extends Form {
     Form current;
     SpanLabel lb;
    public AfficherForm() {
        current=this;
         setTitle("Orders");
       
        
        lb = new SpanLabel("");
        add(lb);
        ServiceOrder rep=new ServiceOrder();   
        
        lb.setText(rep.getList2().toString());
}
}
