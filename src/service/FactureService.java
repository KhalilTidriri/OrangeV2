/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import bean.Client;
import bean.Facture;
import bean.TypeAbonnement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class FactureService extends AbstractFacade<Facture>{
    
 public void payerFacture(String code, Double montant, String mode, Date dateFinPaiement, Date datePaiement, Client client, TypeAbonnement typeAbonnement){
        Facture facture= new Facture();
           
           
           facture.setCode(code);
           facture.setMontant(montant);
           facture.setMode(mode);
           facture.setDateFinPaiement(dateFinPaiement);
           facture.setDatePaiement(datePaiement);
           facture.setClient(client);
           facture.setTypeAbonnement(typeAbonnement);
           create(facture);
         
    }
     private String constructQuery(Long id){
       String query = "SELECT facture FROM Facture facture WHERE facture.client.agence.id = " + id ;
  return query;
     }
     
      public List<Facture> findById(Long id) {
        
          String query = constructQuery(id);
         return getEntityManager().createQuery(query).getResultList();
     }
  
      public Facture findByNom(String nom){
        String query="SELECT fa FROM Facture fa WHERE fa.nom='"+nom+"'";
        return (Facture) getEntityManager().createQuery(query).getSingleResult();
    }
     
    
    public FactureService() {
        super(Facture.class);
    }

    
}
