/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeAbonnement;

/**
 *
 * @author Dell
 */
public class TypeAbonnementService extends AbstractFacade<TypeAbonnement>{
    
    
    public TypeAbonnement findByNom(String nom){
        String query="SELECT ty FROM TypeAbonnement ty WHERE ty.nom='"+nom+"'";
        return (TypeAbonnement) getEntityManager().createQuery(query).getSingleResult();
    }
    
     public TypeAbonnement ajouterTypeAbonnement(String nom, double prix){
        TypeAbonnement typeAbonnement = new TypeAbonnement();
        typeAbonnement.setNom(nom);
        typeAbonnement.setPrix(prix);
        create(typeAbonnement);
        return typeAbonnement;
     }
    
    public TypeAbonnementService() {
        super(TypeAbonnement.class);
    }
    
}
