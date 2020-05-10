/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Association;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.util.ArrayList;

/**
 *
 * @author taieb
 */
public class ServiceUser {
    
     public ArrayList<User> user;
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
    
    
        public boolean addUser(User u) {
        String url = Statics.BASE_URL + "/esprit/tasks/newUser?username=" + u.getUsername() + "&email=" + u.getEmail() + "&password=" + u.getPassword();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
