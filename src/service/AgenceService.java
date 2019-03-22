/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Agence;
import bean.Ville;
import java.util.List;


/**
 *
 * @author Dell
 */
public class AgenceService extends AbstractFacade<Agence>{
    
    public Agence ajouterAgence (String nom, String adresse, Ville ville){
        Agence agence = new Agence();
        
        agence.setNom(nom);
        agence.setAdresse(adresse);
        agence.setVille(ville);
        create (agence);
        return agence;
    }
   
    
    public List<Agence> searchByCriteria(String nom, Ville ville){
        String query = constructQuery(nom, ville);
        return getEntityManager().createQuery(query).getResultList();
    }
    private String constructQuery(String nom, Ville ville){
        String query ="SELECT agence FROM Agence where 1=1";
     if(nom!=null){
        query+=" AND agence.nom='"+nom+"'";
        return query;
    }
     if(ville!=null){
         query+=" AND agence.ville='"+ville+"'";
     }
     return query;
    }
    
    
     public List<Agence> findByVille(Ville ville){
        String query="SELECT ag FROM Agence ag WHERE ag.ville.id='"+ville.getId()+"'";
        return getEntityManager().createQuery(query).getResultList();
    }
     
         public Agence findById(Long id){
        String query="SELECT ag FROM Agence ag WHERE ag.id='"+id+"'";
        return (Agence) getEntityManager().createQuery(query).getSingleResult();
    }
    
         
          public Agence findByNom(String nom){
        String query="SELECT ag FROM Agence ag WHERE ag.nom='"+nom+"'";
        return (Agence) getEntityManager().createQuery(query).getSingleResult();
    }
     
          public int deleteAgence(String nom){
        Agence agence = findByNom(nom);
        remove(agence);
        return 1;
          }
     
    
    public AgenceService() {
        super(Agence.class);
    }
    
    
}
