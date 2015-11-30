/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import java.sql.*;
import java.sql.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Iwasaki
 */
public class LogInScreenController implements Initializable {
    
    @FXML
    private Label message_label;
    @FXML
    private Button btn1;
    @FXML
    private Hyperlink hyperguest;
    @FXML
    private PasswordField password_field;
    @FXML
    private TextField username_field;

    
    
    @FXML
    private void ToGuestRegistration(ActionEvent event) throws IOException {   
        Stage stage; 
        Parent root;
  

        stage=(Stage) hyperguest.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/CustomerSelfRegistration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 

        
    }
    @FXML
    private void ToHome(ActionEvent event) throws IOException {
        String acc_name;
        Stage stage; 
        Parent root;
  
        stage=(Stage) btn1.getScene().getWindow();
        
        if(isValidCredentials())
        {
            AccountContext.getInstance().currentCountry().setCurrentAccount(username_field.getText());
            acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
            System.out.println(acc_name);
            
            root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Homepage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            password_field.clear();
            message_label.setText("ID and Password Combination is incorrect!");
        }
        
    }

    
    private boolean isValidCredentials()
    {
        boolean let_in = false;
        System.out.println( "SELECT * FROM EMPLOYEE WHERE EMP_USER= " + "'" + username_field.getText() + "'" 
            + " AND EMP_PASSWORD= " + "'" + password_field.getText() + "'" );
    
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE WHERE EMP_USER= " + "'" + username_field.getText() + "'" + " AND EMP_PASSWORD= " + "'" + password_field.getText() + "'"); 
                while ( rs.next() ) {
                    if (rs.getString("EMP_USER") != null && rs.getString("EMP_PASSWORD") != null) {
                        String id = rs.getString("EMP_USER");
                        System.out.println( "EMP_USER = " + id );
                        String password = rs.getString("EMP_PASSWORD");
                        System.out.println("EMP_PASSWORD = " + password);
                        let_in = true;
                    }
                }  
            
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
            return let_in; 

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
