/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Abonnement;
import bean.Client;
import bean.TypeAbonnement;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class AbonnementService extends AbstractFacade<Abonnement> {

    public int abonnerAbonnement(Abonnement a) {
        create(a);
        return 1;
    }

    public Abonnement abonnerAbonnement(long id, TypeAbonnement typeAbonnement, Date dateFin, Client client) {
        Abonnement abonnement = new Abonnement();

        abonnement.setId(id);
        abonnement.setTypeAbonnement(typeAbonnement);
        abonnement.setDateFin(dateFin);
        abonnement.setClient(client);
        create(abonnement);
        return abonnement;
    }
 
    public AbonnementService() {
        super(Abonnement.class);
    }

}
