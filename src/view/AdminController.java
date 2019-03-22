/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Ville;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import service.AgenceService;
import service.TypeAbonnementService;
import service.TypeAchatsService;
import service.VilleService;

/**
 *
 * @author Khalil
 */
public class AdminController implements Initializable {
    
 List <Ville> villes; 
    
    
  private TypeAbonnementService typeAbonnementService = new TypeAbonnementService(); 
  
  private TypeAchatsService typeAchatsService = new TypeAchatsService();
  
  private VilleService villeService = new VilleService();
  
  private AgenceService agenceService = new AgenceService();
    
    @FXML
    private javafx.scene.control.TextField nom;
    
    @FXML
    private javafx.scene.control.TextField prix;
    
     @FXML
    private javafx.scene.control.TextField nom1;
     @FXML
    private javafx.scene.control.TextField prix1;
      
     @FXML
     private javafx.scene.control.TextField nom2;
     
     @FXML
     private TextField nom3;
     
     @FXML
     private TextField adresse;
     
    @FXML
    private ComboBox <Ville> ville;
     
    
     
//    private TypeAbonnement getParam(){
//        TypeAbonnement t = new TypeAbonnement(nom.getText(),new Double (prix.getText()));
//        return t;
//    }
//    
    
     
     private void initComboBox(){
         
        villes = villeService.findAll();
        ville.getItems().addAll(villes);
     }
   
     
     @FXML
     private void ajouterAgence(ActionEvent event){
         agenceService.ajouterAgence(nom3.getText(), adresse.getText(), ville.getValue());
         JOptionPane.showMessageDialog(null, "Agence ajoutée", "INFO", JOptionPane.INFORMATION_MESSAGE);
     }
     
     
     
    @FXML
    private void ajouterTypeAbonnement(ActionEvent event) {
     typeAbonnementService.ajouterTypeAbonnement(nom.getText(), new Double(prix.getText()));
     JOptionPane.showMessageDialog(null, "Abonnement ajouté", "INFO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @FXML
    private void ajouterTypeAchats(ActionEvent event){
        typeAchatsService.ajouterTypeAchats(nom1.getText(), new Double(prix1.getText()));
         JOptionPane.showMessageDialog(null,"Produit ajouté","INFO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @FXML
    private void ajouterVille(ActionEvent event){
        villeService.ajouterVille(nom2.getText());
        JOptionPane.showMessageDialog(null, "Ville ajoutée", "INFO", JOptionPane.INFORMATION_MESSAGE);
    }
//    
//    @FXML
//    private void ajouterAgence(ActionEvent event){
//        agenceService.ajouterAgence(nom3.getText(), adresse.getText(), ville.);
//    }        
//    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComboBox();
    }    

    public TypeAbonnementService getTypeAbonnementService() {
        return typeAbonnementService;
    }

    public void setTypeAbonnementService(TypeAbonnementService typeAbonnementService) {
        this.typeAbonnementService = typeAbonnementService;
    }

    public TypeAchatsService getTypeAchatsService() {
        return typeAchatsService;
    }

    public void setTypeAchatsService(TypeAchatsService typeAchatsService) {
        this.typeAchatsService = typeAchatsService;
    }

    public VilleService getVilleService() {
        return villeService;
    }

    public void setVilleService(VilleService villeService) {
        this.villeService = villeService;
    }

    public AgenceService getAgenceService() {
        return agenceService;
    }

    public void setAgenceService(AgenceService agenceService) {
        this.agenceService = agenceService;
    }
    
    
    
}
