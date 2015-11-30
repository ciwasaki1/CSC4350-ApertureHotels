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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iwasaki
 */
public class InventoryController implements Initializable {
     
    @FXML
    private Button backbtn;
    
    @FXML
    private Button search_btn;
    @FXML
    private TextField search_field;
    @FXML
    private Button reset_btn;
    @FXML
    private ComboBox query_cbox;
    
    @FXML
    private Button apply_btn;
    @FXML
    private TextField list_field;
    @FXML
    private TextField value_field;
    @FXML
    private ComboBox update_cbox;
    
    
    @FXML
    private TableColumn list_col;
    @FXML
    private TableColumn name_col;
    @FXML
    private TableColumn sup_col;
    @FXML
    private TableColumn rec_col;
    @FXML
    private TableColumn loc_col;
    @FXML
    private TableView table;

    
    
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
    private void ResetTable(ActionEvent event) throws IOException {
        PopulateInventory("SELECT * FROM ITEM;");
    }
    @FXML
    private void QueryTable(ActionEvent event) throws IOException {

        PopulateInventory("SELECT * FROM ITEM WHERE " +query_cbox.getValue()+"='"+search_field.getText()+"';");
        System.out.println("SELECT * FROM ITEM WHERE " +query_cbox.getValue()+"='"+search_field.getText()+"';");
    }
    @FXML
    private void UpdateInventory(ActionEvent event) throws IOException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "UPDATE ITEM set " +update_cbox.getValue()+" = " +value_field.getText()+" where ITEM_ID=" +list_field.getText()+";";
            stmt.executeUpdate(sql);
            c.commit();

            
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            System.out.println("Operation done successfully");

        PopulateInventory("SELECT * FROM ITEM;");
    }
    public void PopulateInventory(String sql)
    {
        ObservableList<Item> data;
        list_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("id")
        );
        name_col.setCellValueFactory(
            new PropertyValueFactory<Item,String>("name")
        );
        sup_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("cur")
        );
        rec_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("rec")
        );
        loc_col.setCellValueFactory(
            new PropertyValueFactory<Item,String>("loc")
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
                        Item item = new Item();
                        item.id.setValue(rs.getInt("ITEM_ID"));
                        item.name.setValue(rs.getString("ITEM_NAME"));
                        item.cur.setValue(rs.getInt("ITEM_CURRENT"));
                        item.rec.setValue(rs.getInt("ITEM_REC"));
                        item.loc.setValue(rs.getString("ITEM_LOC"));
                        data.add(item);
                }  
            
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PopulateInventory("SELECT * FROM ITEM;");
        
        query_cbox.getItems().addAll(
        "ITEM_ID",
        "ITEM_NAME",
        "ITEM_CURRENT",
        "ITEM_REC",
        "ITEM_LOC"
        );
        
        update_cbox.getItems().addAll(
        "ITEM_CURRENT",
        "ITEM_REC"
        );
                
        
    }   
}
    

