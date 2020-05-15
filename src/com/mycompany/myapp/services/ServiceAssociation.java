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
import com.mycompany.myapp.entities.Association;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author taieb
 */
public class ServiceAssociation {
    public ArrayList<Association> associations;
    public static ServiceAssociation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
    public ServiceAssociation() {
         req = new ConnectionRequest();
    }

    public static ServiceAssociation getInstance() {
        if (instance == null) {
            instance = new ServiceAssociation();
        }
        return instance;
    }
    
    public boolean addAssociation(Association a) {
        String url = Statics.BASE_URL + "/esprit/tasks/newAssociation?name=" + a.getName() + "&description=" + a.getDescription() + "&logo=" + a.getLogo() + "&location=" + a.getLocation() + "&website=" + a.getWebsite();
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
    
        public ArrayList<Association> parseAssociations(String jsonText){
        try {
            associations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> associationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)associationsListJson.get("root");
            for(Map<String,Object> obj : list){
                Association a = new Association();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int)id);
                a.setName(obj.get("name").toString());
                a.setDescription(obj.get("description").toString());
                a.setLogo(obj.get("logo").toString());
                a.setLocation(obj.get("location").toString());
                a.setWebsite(obj.get("website").toString());
                associations.add(a);
                
            }
            
            
        } catch (IOException ex) {
            
        }
        return associations;
    }
        
    public ArrayList<Association> getAllAssociations(){
        String url = Statics.BASE_URL+"/esprit/tasks/allAssociations";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                associations = parseAssociations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return associations;
    }
}

