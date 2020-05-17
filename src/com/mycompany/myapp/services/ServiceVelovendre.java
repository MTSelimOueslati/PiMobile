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
import com.mycompany.myapp.entities.Velovendre;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author helmi
 */
public class ServiceVelovendre {
    
//     public ArrayList<Velovendre> velo;
//    
//    public static ServiceVelovendre instance=null;
//    public boolean resultOK;
//    private ConnectionRequest req;
//
//    private ServiceVelovendre() {
//         req = new ConnectionRequest();
//    }
//
//    public static ServiceVelovendre getInstance() {
//        if (instance == null) {
//            instance = new ServiceVelovendre();
//        }
//        return instance;
//    }
//     public boolean addVelo(Velovendre v) {
//        String url = Statics.BASE_URL + "/cart/" + v.getMarque() + "/" + v.getPrice()+ "/" + v.getPath_photo()+ "/" + v.getNombre();
//        req.setUrl(url);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
//
//    
//    
//       public ArrayList<Velovendre> parsevelo(String jsonText){
//        try {
//            velo=new ArrayList<>();
//            JSONParser j = new JSONParser();
//            Map<String,Object> veloListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)veloListJson.get("root");
//            for(Map<String,Object> obj : list){
//                Velovendre v = new Velovendre();
//                float id = Float.parseFloat(obj.get("id").toString());
//                v.setId((int)id);
//                v.setMarque(obj.get("marque").toString());
//                v.setNombre((int)Float.parseFloat(obj.get("nombre").toString()));
//                v.setPath_photo(obj.get("path_Photo").toString());
//                v.setPrice((double)Float.parseFloat(obj.get("price").toString()));
//                velo.add(v);
//            }
//            
//            
//        } catch (IOException ex) {
//            
//        }
//        return velo;
//    }
//
//        public ArrayList<Velovendre> getAllvelo(){
////       Velovendre  velo = new Velovendre();
////     req.setUrl("http://localhost/bascla/web/app_dev.php/cart/all3");
////        NetworkManager.getInstance().addToQueueAndWait(req);
////        String data = new String(req.getResponseData());
////        List<Velovendre> velos = parsevelo(data);
////        return velo;
//
//
//  ArrayList<Velovendre> velo = new ArrayList<>();
//        req.setUrl("http://localhost/bascla/web/app_dev.php/cart/all3");
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                JSONParser jsonp = new JSONParser();
//                try {
//                    Map<String, Object> velos = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
//                    List<Map<String, Object>> list = (List<Map<String, Object>>) velos.get("root");
//                    for (Map<String, Object> obj : list) {
//                        
//                        Velovendre v = new Velovendre();
//                       
//                        velo.add(v);
//                    }
//                } catch (IOException | NumberFormatException e) {
//                }
//
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return velo;
//    
//
//    }

    
       public void ajoutTask(Velovendre v) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "localhost/bascla/web/app_dev.php/cart/new3?price="+v.getPrice()+"&marque="+v.getMarque()+"&pathPhoto="+v.getPath_photo()+"&nombre="+v.getNombre();// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
       
         public ArrayList<Velovendre> parseListTaskJson(String json) {

        ArrayList<Velovendre> listTasks = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Velovendre v = new Velovendre();

               float id = Float.parseFloat(obj.get("id").toString());

              v.setId((int) id);
               v.setMarque(obj.get("marque").toString());
//                e.setDate_qc(obj.get("name").toString());
               
                
               float price = Float.parseFloat(obj.get("price").toString());
                v.setPrice((double) price);

                System.out.println(v);
                
                listTasks.add(v);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listTasks);
        return listTasks;

    }
         
          ArrayList<Velovendre> listTasks = new ArrayList<>();
    
    public ArrayList<Velovendre> getList2(){
        
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/bascla/web/app_dev.php/cart/all3");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceVelovendre ser = new ServiceVelovendre();
                listTasks = ser.parseListTaskJson(new String(con.getResponseData()));
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
    
    
  
}
    

    
    

