/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class HomepageController implements Initializable {
    String acc_name = "";
    
    
    @FXML
    private Hyperlink hyperlog;
    @FXML
    private Button ticketbtn;
    @FXML
    private Button RMbtn;
    @FXML
    private Button mybtn;
    @FXML
    private Button invbtn;
    @FXML
    private Button SMbtn;
    @FXML
    private Label username_label;
    
    @FXML
    private void ToMyAperture(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) mybtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/MyAperture.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void ToRoomManagement(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) RMbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/RoomManagement.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private void ToInventory(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) invbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Inventory.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private void ToTickets(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        
        stage=(Stage) ticketbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Tickets.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private void BackToLogIn(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) hyperlog.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/LogInScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    private void ToStaffManagement(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) SMbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/StaffManagement.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public String getTeam(String sql)
    {
        Connection c = null;
        Statement stmt = null;
        String team = "";
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while ( rs.next() ) {
                team = rs.getString("EMP_TEAM");
            }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    }
    return team;
    }
    public void initialize(URL url, ResourceBundle rb) {
       acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
       username_label.setText("Welcome "+ acc_name);
       System.out.println("is this blank?"+ acc_name);
       String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
       
       switch(team)
       {
            case "Front":
                SMbtn.isDisabled();
                invbtn.isDisabled();
                break;
            case "Service":
                SMbtn.isDisabled();
                RMbtn.isDisabled();
                break;
       }
       
       
    }    
}
