/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Achat;
import bean.TypeAchats;

/**
 *
 * @author Dell
 */
public class AchatService extends AbstractFacade<Achat>{
    
     public int addAchat(Achat ach) {
        create(ach);
        return 1;
    }
   
    public Achat addAchat(TypeAchats typeAchats, String nom, String mode){
        
         Achat achat = new Achat();

        achat.setTypeAchats(typeAchats);
        achat.setNom(nom);
        achat.setMode(mode);
        create(achat);
        return achat;
    }
   
    
    public AchatService() {
        super(Achat.class);
    }
    
    
    
}
