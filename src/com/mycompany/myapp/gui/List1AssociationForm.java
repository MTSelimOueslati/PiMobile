package com.mycompany.myapp.gui;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.myapp.entities.Association;
import com.mycompany.myapp.services.ServiceAssociation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;






public class List1AssociationForm extends Form{ 
    private Form f ;
    Form previous ;
    public List1AssociationForm( Form previous) {
          ServiceAssociation rs = new ServiceAssociation();
ArrayList<Association>list = new ArrayList<>();
list.addAll(rs.getAllAssociations());
        setLayout(BoxLayout.y());
            setTitle("Associations");
for (Association c  : rs.getAllAssociations()){
    System.out.println("haha"+c );
              try {
                  addItem(c);
              } catch (IOException ex) {
              }
            }
        
    }
        public void addItem (Association c) throws IOException {
Image img ;
            ImageViewer imv;
                    Container c1 = new Container(BoxLayout.y());
c1.getStyle().setMargin(TOP, 50);
//   String url="http://localhost/piweb/web/uploads/web/" +c.getLogo(); //hedhi zeda?
          EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(500, 450, 0xffff0000), true);
            URLImage logo = URLImage.createToStorage(placeholder, c.getName()+".cache",
                "http://localhost/piweb/web/uploads/web/" +c.getLogo());
            //tasti, mazzel osber aad makamaltch
            //
                 
imv = new ImageViewer();
imv.setImage(logo);

        Label l = new Label(c.getName());
        l.setAlignment(CENTER);
        Label tel = new Label(c.getDescription());
        tel.setAlignment(CENTER);
        Label dc = new Label (c.getLocation());
         dc.setAlignment(CENTER);
        
         Label IDC = new Label (String.valueOf(c.getId()));
        IDC.setAlignment(CENTER);
         Label vide= new Label("");
          vide.setAlignment(CENTER);
        
       Container cBtn= new Container(new FlowLayout(CENTER, CENTER)); 
//c2.add(IDC);

        c1.addAll(imv,l,tel,vide,cBtn);
        
//la7dha
       
        add(c1);
        show();
        
        l.addPointerPressedListener((evt) -> {Dialog.show("Details du Club", "Nom : "+l.getText()+ "\n Email : " +tel.getText()+"\n Date de creation :"+dc.getText(), "OK",null);
        Form f2 = new Form("Ajout", BoxLayout.y())  ;
        Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                TextField tf = new TextField("");
 TextField ta = new TextField("");
c3.add(tf);
c3.add(ta);
f2.add(c3);
        });
       


        


   getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->new  AssociationsManagement().show());

        
        
    }

}