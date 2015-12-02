/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class CustomerSelfRegistrationController implements Initializable {

    @FXML
    private Button proceedbtn;
    @FXML
    private Hyperlink hyperlogin;
    
    @FXML
    private void ToSelfRegistration(ActionEvent event) throws IOException {   
        Stage stage; 
        Parent root;
  
        stage=(Stage) proceedbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/CustSelfRegistration2.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private void BackToLogIn(ActionEvent event) throws IOException {   
        Stage stage; 
        Parent root;
  
        stage=(Stage) hyperlogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/LogInScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
