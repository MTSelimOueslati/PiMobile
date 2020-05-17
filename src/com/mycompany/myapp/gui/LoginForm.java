/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.VarGlobales;
import com.mycompany.myapp.services.ServiceUser;


/**
 *
 * @author taieb
 */
public class LoginForm extends Form{
     Form current;
    
 
        public LoginForm(Form previous) {
            
 
        current=this;
        setTitle("Login");
        setLayout(BoxLayout.y());
        
        
        
    TextField username = new TextField("","Username");
    TextField password = new TextField ("","Password",20, TextArea.PASSWORD);
    Button login = new Button ("Login");
    Button sign = new Button ("Sign up");
    
    sign.addActionListener(e-> new SignInForm(current).show());
   
    
    
    login.addActionListener(new ActionListener(){
    @Override
        public void actionPerformed(ActionEvent evt){
            if (ServiceUser.getInstance().VerifUser(username.getText(), password.getText())==false){
                Dialog.show("","Check Username And Password",new Command("OK"));
                new LoginForm(current).show();
            }else{
                VarGlobales.setusername(username.getText());
                new VeloView().getForm().show();
            }
            }
    });
    
    
    
    
    addAll(username,password,login,sign);
}
       
        
        
}
