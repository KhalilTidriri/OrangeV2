/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Khalil
 */
import bean.Agence;
import bean.Admin;
import java.util.Date;
import util.Session;

/**
 *
 * @author Dell
 */
public class AdminService extends AbstractFacade<Admin>{
    
   
    
     public Admin ajouterAdmin(Long id, String username, String password){
    
        Admin admin = new Admin();
        admin.setId(id);
        admin.setUsername(username);
        admin.setPassword(password);
        create(admin);
        return admin;
     }
     
      public int seConnecter (Admin admin){
         Admin loadedAdmin = find (admin.getId());
         if (loadedAdmin == null){
             return -1;
         }
         else if (!loadedAdmin.getPassword().equals(admin.getPassword())){
             return -2;
         }
         else{
             Session.setAttribut(loadedAdmin,"AdminConnecte");
             return 1;
         }
     }

      
    public AdminService() {
        super(Admin.class);
    }
    
}
