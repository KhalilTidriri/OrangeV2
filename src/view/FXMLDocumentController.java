/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFx;

import bean.Admin;
import bean.Client;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import service.AdminService;
import service.ClientService;
import util.Session;

/**
 * FXML Controller class
 *
 * @author Naoufal's pc
 */
public class FXMLDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField id;
    @FXML
    private PasswordField password;
    private AdminService adminService = new AdminService();

    private Admin getParam() {
        Admin admin = new Admin(new Long(id.getText()), password.getText());
        return admin;
    }

    @FXML
    public void Login(ActionEvent event) throws IOException {
        int res = adminService.seConnecter(getParam());
        if (res > 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Connected");
            alert.setHeaderText(null);
            alert.setContentText("Connected!");
            alert.showAndWait();
            Stage stage = new Stage();
            Parent nfl = FXMLLoader.load(getClass().getResource("adminView.fxml"));
            Scene scene = new Scene(nfl);
            stage.setScene(scene);
            stage.setTitle("Orange.ma");
            stage.getIcons().add(new Image("Icons/OrangeIcon.png"));
            stage.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error");
            alert.setContentText("Wrong username or password");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public TextField getId() {
        return id;
    }

    public void setId(TextField id) {
        this.id = id;
    }

    
    public TextField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

}
