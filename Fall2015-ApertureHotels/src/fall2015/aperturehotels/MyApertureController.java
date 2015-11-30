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
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class MyApertureController implements Initializable {
    String acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
    
    @FXML
    private Hyperlink hyperback;
    @FXML
    private Label username_label;
    @FXML
    private Button clock_btn;
    @FXML
    private Button apply_btn;
    @FXML
    private Button pinfo_btn;
    @FXML
    private Button feedback_btn;
    @FXML
    private Button team_btn;
    @FXML
    private Button timeoff_btn;
    
    
    @FXML
    private void BackToHomepage(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) hyperback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Homepage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void OpenClockIn(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        if(event.getSource()==clock_btn){
            stage=new Stage();
            root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/ClockIn.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(clock_btn.getScene().getWindow());
            stage.showAndWait();
        }
        else{
            stage=(Stage)apply_btn.getScene().getWindow();
            stage.close();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
