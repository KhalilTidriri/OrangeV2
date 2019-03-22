/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Agence;
import bean.Client;
import java.util.Date;
import util.Session;

/**
 *
 * @author Dell
 */
public class ClientService extends AbstractFacade<Client>{
    
   
    
     public Client ajouterClient(Long id, String password, String nom, String prenom, String sexe, Date dateDeNaissance, String nationalite, Agence agence){
    
        Client client = new Client();
        client.setId(id);
        client.setPassword(password);
        client.setPrenom(prenom);
        client.setNom(nom);
        client.setSexe(sexe);
        client.setDateDeNaissance(dateDeNaissance);
        client.setNationalite(nationalite);
        client.setAgence(agence);
        create(client);
        return client;
     }
     
      public int seConnecter (Client client){
         Client loadedClient = find (client.getId());
         if (loadedClient == null){
             return -1;
         }
         else if (!loadedClient.getPassword().equals(client.getPassword())){
             return -2;
         }
         else{
             Session.setAttribut(loadedClient,"ClientConnecte");
             return 1;
         }
     }

       public Client findByNom(String nom){
        String query="SELECT cl FROM Client cl WHERE cl.nom='"+nom+"'";
        return (Client) getEntityManager().createQuery(query).getSingleResult();
    }
    
    public ClientService() {
        super(Client.class);
    }
    
}
