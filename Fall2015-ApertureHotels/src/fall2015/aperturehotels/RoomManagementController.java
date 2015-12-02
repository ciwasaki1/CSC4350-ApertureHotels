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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class RoomManagementController implements Initializable {

    @FXML
    private Button backbtn;
    @FXML
    private Button assign_btn;
    @FXML
    private Button delete_btn;
    @FXML
    private TableColumn rnum_col;
    @FXML
    private TableColumn rfloor_col;
    @FXML
    private TableColumn rtype_col;
    @FXML
    private TableColumn rstatus_col;
    @FXML
    private TableView r_table;
    
    @FXML
    private TableColumn s_id_col;
    @FXML
    private TableColumn s_name_col;
    @FXML
    private TableColumn s_des_col;
    @FXML
    private TableColumn s_exp_col;
    @FXML
    private TableView s_table;
    
    @FXML
    private TableColumn g_id_col;
    @FXML
    private TableColumn g_fname_col;
    @FXML
    private TableColumn g_lname_col;
    @FXML
    private TableColumn g_pnum_col;
    @FXML
    private TableColumn g_zcode_col;
    @FXML
    private TableColumn g_size_col;
    @FXML
    private TableView g_table;

 
    
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
    private void PopulateRoomTable(String sql)
    {
        ObservableList<Room> data;
        rnum_col.setCellValueFactory(
            new PropertyValueFactory<Room,Integer>("id")
        );
        rfloor_col.setCellValueFactory(
            new PropertyValueFactory<Room,String>("type")
        );
        rtype_col.setCellValueFactory(
            new PropertyValueFactory<Room,Integer>("floor")
        );
        rstatus_col.setCellValueFactory(
            new PropertyValueFactory<Room,String>("stat")
        );

 
        data = FXCollections.observableArrayList();
        r_table.setItems(data);
        
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql); 
                while ( rs.next() ) {
                        Room room = new Room();
                        room.id.setValue(rs.getInt("ROOM_ID"));
                        room.type.setValue(rs.getString("ROOM_TYPE"));
                        room.stat.setValue(rs.getString("ROOM_STATUS"));
                        room.floor.setValue(rs.getInt("ROOM_FLOOR"));

                        data.add(room);
                }  
            
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
    }
    public void PopulateServices(String sql)
    {
        ObservableList<Service> data;
        s_id_col.setCellValueFactory(
            new PropertyValueFactory<Service,Integer>("id")
        );
        s_name_col.setCellValueFactory(
            new PropertyValueFactory<Service,String>("name")
        );
        s_des_col.setCellValueFactory(
            new PropertyValueFactory<Service,String>("des")
        );
        s_exp_col.setCellValueFactory(
            new PropertyValueFactory<Service,Double>("exp")
        );
 
        data = FXCollections.observableArrayList();
        s_table.setItems(data);
        
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql); 
                while ( rs.next() ) {
                        Service service = new Service();
                        service.id.setValue(rs.getInt("SERV_ID"));
                        service.name.setValue(rs.getString("SERV_NAME"));
                        service.des.setValue(rs.getString("SERV_DESC"));
                        service.exp.setValue(rs.getDouble("SERV_EXPENSE"));
                        data.add(service);
                }  
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
    }
    public void PopulateGuest(String sql)
    {
        ObservableList<Guest> data;
        g_id_col.setCellValueFactory(
            new PropertyValueFactory<Guest,Integer>("id")
        );
        g_fname_col.setCellValueFactory(
            new PropertyValueFactory<Guest,String>("fname")
        );
        g_lname_col.setCellValueFactory(
            new PropertyValueFactory<Guest,String>("lname")
        );
        g_pnum_col.setCellValueFactory(
            new PropertyValueFactory<Guest,String>("pnum")
        );
        g_zcode_col.setCellValueFactory(
            new PropertyValueFactory<Guest,Integer>("zcode")
        );
        g_size_col.setCellValueFactory(
            new PropertyValueFactory<Guest,Integer>("size")
        );
 
        data = FXCollections.observableArrayList();
        g_table.setItems(data);
        
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql); 
                while ( rs.next() ) {
                        Guest guest = new Guest();
                        guest.id.setValue(rs.getInt("G_ID"));
                        guest.fname.setValue(rs.getString("G_FNAME"));
                        guest.lname.setValue(rs.getString("G_LNAME"));
                        guest.pnum.setValue(rs.getString("G_PNUM"));
                        guest.zcode.setValue(rs.getInt("G_ZCODE"));
                        guest.size.setValue(rs.getInt("G_SIZE"));
                        data.add(guest);
                }  
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PopulateRoomTable("SELECT * FROM ROOM;");
        PopulateServices("SELECT * FROM SERVICE;");
        PopulateGuest("SELECT * FROM GUEST;");
    }    
    
}
