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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class RevenueController implements Initializable {

    @FXML
    private Button backbtn;
    
    @FXML
    private void BackToHomepage(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) backbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Homepage.fxml"));

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
