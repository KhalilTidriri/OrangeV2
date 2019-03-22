/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Ville;

/**
 *
 * @author Dell
 */
public class VilleService extends AbstractFacade<Ville>{
    
     public Ville ajouterVille(String nom){
        Ville ville = new Ville();
        ville.setNom(nom);
        create(ville);
        return ville;
     }
    
    public VilleService() {
        super(Ville.class);
    }
    
    public Ville findByNom(String nom){
        String query="SELECT v FROM Ville v WHERE v.nom='"+nom+"'";
        return (Ville) getEntityManager().createQuery(query).getSingleResult();
    }
    
}
