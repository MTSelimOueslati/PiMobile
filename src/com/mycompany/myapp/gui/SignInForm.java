/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.messaging.Message;
import com.codename1.social.FacebookConnect;
import com.codename1.social.Login;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;

/**
 *
 * @author taieb
 */
public class SignInForm extends Form {
    
     Form current;
        public SignInForm(Form previous) {
             current=this;
        setTitle("Sign In");
        setLayout(BoxLayout.y());
        
        TextField username = new TextField("","Username");
        TextField email = new TextField("","Email");
        TextField password = new TextField ("","Password",20, TextArea.PASSWORD);
        TextField passwordconfirm = new TextField ("","Confirm Password",20, TextArea.PASSWORD);
        TextField tel = new TextField("","Phone number");
        Button btnValider = new Button("Sign In");
        Button facebooklogin = new Button ("Login with Facebook");
        
        facebooklogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String clientId = "1654896674667347";
                String redirectURI = "https://www.codenameone.com/";
                String clientSecret = "27804c48ab2159991982e49a70acbf68";
                Login fb = FacebookConnect.getInstance();
                fb.setClientId(clientId);
                fb.setRedirectURI(redirectURI);
                fb.setClientSecret(clientSecret);
                //Sets a LoginCallback listener
                
                //trigger the login if not already logged in
                if(!fb.isUserLoggedIn()){
                    fb.doLogin();
                }else{
                    //get the token and now you can query the facebook API
                    String token = fb.getAccessToken().getToken();
                    
                }
            }
        });
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((username.getText().length()==0)||(email.getText().length()==0)||(password.getText().length()==0)||(passwordconfirm.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else if (!password.getText().equals(passwordconfirm.getText())){
                Dialog.show("Alert", "Password don't match", new Command("OK"));
                }
                else
                {
                    try {
                        User u = new User(username.getText(), email.getText(), password.getText(),tel.getText());
          if( ServiceUser.getInstance().addUser(u))
          {
              Dialog.show("Success","Connection accepted",new Command("OK"));
              new LoginForm(current).show();
          }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Errors", new Command("OK"));
                    }
                    
                }
                
        Message m = new Message("Bonsoir Mr voici le test");
        Display.getInstance().sendMessage(new String[]{email.getText()}, "A propos de votre test", m); 
            }
            
        });
        
        addAll(username,email,password,passwordconfirm,tel,btnValider,facebooklogin);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }


}
