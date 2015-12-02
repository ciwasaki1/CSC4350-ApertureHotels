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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class CustSelfRegistration2Controller implements Initializable {

    @FXML
    private Button regbtn;
    @FXML
    private Hyperlink hyperback;
    @FXML
    private TextField fname_field;
    @FXML
    private TextField lname_field;
    @FXML
    private TextField add1_field;
    @FXML
    private TextField add2_field;
    @FXML
    private TextField city_field;
    @FXML
    private TextField zcode_field;
    @FXML
    private TextField email_field;
    @FXML
    private TextField pnum_field;
    @FXML
    private CheckBox offer_check;
    @FXML
    private ComboBox state_cbox;
    @FXML
    private ComboBox size_cbox;

    
    @FXML
    private void ToRegistrationConfirm(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) regbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/RegistrationConfirm.fxml"));

        if(isValidEntry())
        {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            //m_label.setText("Please fill in all Required Fields!");
        }
    }
    @FXML
    private void BackToRegistration(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;

        stage=(Stage) hyperback.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/CustomerSelfRegistration.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    private boolean isValidEntry()
    {
        boolean let_in = false;
        /*System.out.println( "SELECT * FROM EMPLOYEE WHERE EMP_ID= " + "'" + username_field.getText() + "'" 
            + " AND EMP_PASSWORD= " + "'" + password_field.getText() + "'" );
                */
    
        Connection c = null;
        Statement stmt = null;
        String sql;
        int gnumber = 0;
        try {
            
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            Class.forName("org.sqlite.JDBC");
            Statement st = c.createStatement();
            System.out.println("Opened database successfully");
            
            ResultSet res = st.executeQuery("SELECT COUNT(*) FROM GUEST");
            while (res.next()){
            gnumber = res.getInt(1);
            }
            
            stmt = c.createStatement();
            sql = "INSERT INTO GUEST (G_ID, G_FNAME, G_LNAME, G_ADD1, G_ADD2, G_CITY, G_ZCODE, G_STATE, G_EMAIL, G_PNUM, G_OFFERSTAT, G_SIZE) " +
                   "VALUES "
                    + "('" + gnumber++ + "', "
                    + "'" + fname_field.getText() + "', "
                    + "'" + lname_field.getText() + "', "
                    + "'" + add1_field.getText() + "', "
                    + "'" + add2_field.getText() + "', "
                    + "'" + city_field.getText() + "', "
                    + "'" + zcode_field.getText() + "', "
                    + "'" + state_cbox.getValue() + "', "
                    + "'" + email_field.getText() + "', "
                    + "'" + pnum_field.getText() + "', "
                    + "'" + offer_check.isSelected() + "', "
                    + size_cbox.getValue() + ");";
            let_in = true;
            stmt.executeUpdate(sql);

            /*ResultSet rs = stmt.executeQuery( "SELECT * FROM EMPLOYEE WHERE EMP_ID= " + "'" + username_field.getText() + "'" + " AND EMP_PASSWORD= " + "'" + password_field.getText() + "'"); 
                while ( rs.next() ) {
                    if (rs.getString("EMP_ID") != null && rs.getString("EMP_PASSWORD") != null) {
                        String id = rs.getString("EMP_ID");
                        System.out.println( "EMP_ID = " + id );
                        String password = rs.getString("EMP_PASSWORD");
                        System.out.println("EMP_PASSWORD = " + password);
                        let_in = true;
                    }
                }
            */
            stmt.close();
            c.commit();
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
        state_cbox.getItems().addAll(
        "AL - Alabama",
        "AK - Alaska",
        "AZ - Arizona",
        "AR - Arkansas",
        "CA - California",
        "CO - Colorado",
        "CT - Connecticut",
        "DE - Delaware",
        "FL - Florida",
        "GA - Georgia",
        "HI - Hawaii",
        "ID - Idaho",
        "IL - Illinois",
        "IN - Indiana",
        "IA - Iowa",
        "KS - Kansas",
        "KY - Kentucky",
        "LA - Louisiana",
        "ME - Maine",
        "MD - Maryland",
        "MA - Massachusetts",
        "MI - Michigan",
        "MN - Minnesota",
        "MS - Mississippi",
        "MO - Missouri",
        "MT - Montana",
        "NE - Nebraska",
        "NV - Nevada",
        "NH - New Hampshire",
        "NJ - New Jersey",
        "NM - New Mexico",
        "NY - New York",
        "NC - North Carolina",
        "ND - North Dakota",
        "OH - Ohio",
        "OK - Oklahoma",
        "OR - Oregon",
        "PA - Pennsylvania",
        "RI - Rhode Island",
        "SC - South Carolina",
        "SD - South Dakota",
        "TN - Tennessee",
        "TX - Texas",
        "UT - Utah",
        "VT - Vermont",
        "VA - Virginia",
        "WA - Washington",
        "WV - West Virginia",
        "WI - Winsconsin",
        "WY - Wyoming"
        );
        size_cbox.getItems().addAll(
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7"
        );
    }    
    
}
