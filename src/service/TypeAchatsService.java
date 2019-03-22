/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeAchats;
/**
 *
 * @author Dell
 */
public class TypeAchatsService extends AbstractFacade<TypeAchats> {
    
      public TypeAchats findByNom(String nom){
        String query="SELECT ac FROM TypeAchats ac WHERE ac.nom='"+nom+"'";
        return (TypeAchats) getEntityManager().createQuery(query).getSingleResult();
    }
    
        public TypeAchats ajouterTypeAchats(String nom, double prix){
        TypeAchats typeAchats = new TypeAchats();
        typeAchats.setNom(nom);
        typeAchats.setPrix(prix);
        create(typeAchats);
        return typeAchats;
     }
        
        public int deleteTypeAchats(String nom){
        TypeAchats typeAchats = findByNom(nom);
        remove(typeAchats);
        return 1;
          }
        
         public TypeAchatsService() {
        super(TypeAchats.class);
    }
    
}
