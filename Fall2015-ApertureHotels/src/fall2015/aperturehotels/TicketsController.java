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
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class TicketsController implements Initializable {
    /*
    public class Ticket 
    {
        public SimpleIntegerProperty id = new SimpleIntegerProperty();
        public SimpleStringProperty sub = new SimpleStringProperty();
        public SimpleStringProperty des = new SimpleStringProperty();
        public SimpleStringProperty stat = new SimpleStringProperty();
        
        public int getId() {
            return id.get();
        }
 
        public String getSub() {
            return sub.get();
        }
 
        public String getDes() {
            return des.get();
        }
 
        public String getStat() {
            return stat.get();
        }

    }
    */
    String acc_name = "";
    
    @FXML
    private Button backbtn;
    @FXML
    private TableColumn stat_col;
    @FXML
    private TableColumn id_col;
    @FXML
    private TableColumn des_col;
    @FXML
    private TableColumn sub_col;
    @FXML
    private TableView table;
    
    @FXML
    private TextField tnum_field;
    @FXML
    private Button comp_btn;
    @FXML
    private Button incomp_btn;
    @FXML
    private Button red_btn;
    @FXML
    private Button del_btn;
            
    @FXML
    private ComboBox send_cbox;
    @FXML
    private TextField sub_field;
    @FXML
    private TextArea des_area;
    @FXML
    private ComboBox pri_cbox;
    @FXML
    private Button send_btn;
    
    
    @FXML
    private void BackToHomepage(ActionEvent event) throws IOException {
        
        Stage stage; 
        Parent root;

        stage=(Stage) backbtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fall2015/resources/fxml/Homepage.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void MarkComplete(ActionEvent event) throws IOException {
        acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
        String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
        UpdateTicket("UPDATE TICKET set TICKET_STAT='Compelete' where TICKET_ID=" +tnum_field.getText()+";");
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
    }
    @FXML
    private void MarkIncomplete(ActionEvent event) throws IOException {
        acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
        String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
        UpdateTicket("UPDATE TICKET set TICKET_STAT='Incompelete' where TICKET_ID=" +tnum_field.getText()+";");
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
    }
    @FXML
    private void MarkRed(ActionEvent event) throws IOException {
        acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
        String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
        UpdateTicket("UPDATE TICKET set TICKET_STAT='STATUS RED' where TICKET_ID=" +tnum_field.getText()+";");
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
    }
    @FXML
    private void CreateTicket(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
            String sql;
            acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
            String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
            System.out.println(team);
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                sql = "INSERT INTO TICKET (TICKET_SUB, TICKET_DES, TICKET_STAT, TICKET_TO) " +
                        "VALUES "
                        + "('" + sub_field.getText() + "', "
                        + "'" + des_area.getText() + "', "
                        + "'" + pri_cbox.getValue() + "', "
                        + "'" + send_cbox.getValue() + "');";
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
    catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
         
    }
    private void UpdateTicket(String sql) {
        Connection c = null;
        Statement stmt = null;
        acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
        String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            c.commit();

            
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        System.out.println(team);
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
    }
    public void PopulateTickets(String sql)
    {
        ObservableList<Ticket> data;
        
        
        id_col.setCellValueFactory(
            new PropertyValueFactory<Ticket,Integer>("id")
        );
        sub_col.setCellValueFactory(
            new PropertyValueFactory<Ticket,String>("sub")
        );
        des_col.setCellValueFactory(
            new PropertyValueFactory<Ticket,String>("des")
        );
        stat_col.setCellValueFactory(
            new PropertyValueFactory<Ticket,String>("stat")
        );

 
        data = FXCollections.observableArrayList();
        table.setItems(data);
        
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
                while ( rs.next() ) {
                        Ticket ticket = new Ticket();
                        ticket.id.setValue(rs.getInt("TICKET_ID"));
                        ticket.sub.setValue(rs.getString("TICKET_SUB"));
                        ticket.des.setValue(rs.getString("TICKET_DES"));
                        ticket.stat.setValue(rs.getString("TICKET_STAT"));
                        data.add(ticket);
                }  
            
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        acc_name = AccountContext.getInstance().currentCountry().getCurrentAccount();
        String team= getTeam("SELECT EMP_TEAM FROM EMPLOYEE WHERE EMP_USER="+ "'" + acc_name + "';");
        System.out.println(team);
        PopulateTickets("SELECT * FROM TICKET WHERE TICKET_TO = "+ "'" + team + "';");
        
        send_cbox.getItems().addAll(
        "Management",
        "Front",
        "Service"
        );
        
        pri_cbox.getItems().addAll(
        "GREEN",
        "RED"
        );
    }    
    
}
