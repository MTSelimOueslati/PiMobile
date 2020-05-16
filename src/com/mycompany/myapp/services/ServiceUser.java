/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author taieb
 */
public class ServiceUser {
    
     public ArrayList<User> users;
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
        String url = Statics.BASE_URL + "/esprit/tasks/newUser?username=" + u.getUsername() + "&email=" + u.getEmail() + "&password=" + u.getPassword()+"&tel="+u.getTel();
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
        
        public ArrayList<User> parseUsers(String jsonText){
        try {
            users=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> associationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)associationsListJson.get("root");
            for(Map<String,Object> obj : list){
                User a = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int)id);
                a.setUsername(obj.get("username").toString());
                a.setPassword(obj.get("password").toString());
                a.setEmail(obj.get("email").toString());
             
                users.add(a);
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return users;
    }
        
    public ArrayList<User> getAllUsers(){
        String url = Statics.BASE_URL+"/esprit/tasks/allUsers";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
        
        
        
        
        public User parseTasks(String jsonText) {
        User u = new User();
        try {
            users = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                u.setPassword(obj.get("password").toString());
                users.add(u);
            }
        } catch (IOException ex) {
        }
        return u;
    }
        
        
         public Boolean VerifUser(String username, String password) {
        User u = new User();
        String url = Statics.BASE_URL + "/esprit/tasks/VerifUsers?username=" + username + "&password=" + password;
        System.out.println(url);
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                User users = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
                u.setPassword(users.getPassword());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(users);
        System.out.println(u.getPassword());
        if (u.getPassword().equals("faux")) {
            return false;
        } else {
            return true;
        }
    }
}
