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
public class StaffManagementController implements Initializable {

    @FXML
    private Button backbtn;
    
    @FXML
    private TextField e_addfname;
    @FXML
    private TextField e_addlname;
    @FXML
    private ComboBox e_addteam;
    @FXML
    private TextField e_addsal;
    @FXML
    private TextField e_adduser;
    @FXML
    private TextField e_addcont;
    @FXML
    private TextField e_addpass;
    @FXML
    private Button e_addbtn;
    @FXML
    private TextField e_delid;
    @FXML
    private Button e_delbtn;
    @FXML
    private TextField e_modid;
    @FXML
    private ComboBox e_modatt;
    @FXML
    private TextArea e_modchanges;
    @FXML
    private Button e_modbtn;
    
    @FXML
    private TextField i_addname;
    @FXML
    private TextField i_addcur;
    @FXML
    private TextField i_addrec;
    @FXML
    private TextField i_addloc;
    @FXML
    private Button i_addbtn;
    @FXML
    private TextField i_delid;
    @FXML
    private Button i_delbtn;
    
    @FXML
    private TextField s_addname;
    @FXML
    private TextArea s_adddes;
    @FXML
    private TextField s_addexp;
    @FXML
    private Button s_addcreate;
    @FXML
    private TextField s_delid;
    @FXML
    private Button s_delbtn;
    @FXML
    private TextField s_modid;
    @FXML
    private ComboBox s_modatt;
    @FXML
    private TextArea s_modchanges;
    @FXML
    private Button s_modbtn;
    
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
    private TableColumn i_num_col;
    @FXML
    private TableColumn i_name_col;
    @FXML
    private TableColumn i_cur_col;
    @FXML
    private TableColumn i_rec_col;
    @FXML
    private TableColumn i_loc_col;
    @FXML
    private TableView i_table;
    
    @FXML
    private TableColumn e_id_col;
    @FXML
    private TableColumn e_fname_col;
    @FXML
    private TableColumn e_lname_col;
    @FXML
    private TableColumn e_team_col;
    @FXML
    private TableColumn e_user_col;
    @FXML
    private TableColumn e_cont_col;
    @FXML
    private TableColumn e_sal_col;
    @FXML
    private TableView e_table;
    
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
    public void PopulateInventory(String sql)
    {
        ObservableList<Item> data;
        i_num_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("id")
        );
        i_name_col.setCellValueFactory(
            new PropertyValueFactory<Item,String>("name")
        );
        i_cur_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("cur")
        );
        i_rec_col.setCellValueFactory(
            new PropertyValueFactory<Item,Integer>("rec")
        );
        i_loc_col.setCellValueFactory(
            new PropertyValueFactory<Item,String>("loc")
        );
 
        data = FXCollections.observableArrayList();
        i_table.setItems(data);
        
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
    public void PopulateEmployee(String sql)
    {
        ObservableList<Employee> data;
        e_id_col.setCellValueFactory(
            new PropertyValueFactory<Employee,Integer>("id")
        );
        e_fname_col.setCellValueFactory(
            new PropertyValueFactory<Employee,String>("fname")
        );
        e_lname_col.setCellValueFactory(
            new PropertyValueFactory<Employee,Integer>("lname")
        );
        e_team_col.setCellValueFactory(
            new PropertyValueFactory<Employee,Integer>("team")
        );
        e_user_col.setCellValueFactory(
            new PropertyValueFactory<Employee,String>("user")
        );
        e_cont_col.setCellValueFactory(
            new PropertyValueFactory<Employee,String>("cont")
        );
        e_sal_col.setCellValueFactory(
            new PropertyValueFactory<Employee,Double>("sal")
        );
 
        data = FXCollections.observableArrayList();
        e_table.setItems(data);
        
        Connection c = null;
        Statement stmt = null;
        try {
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            
            System.out.println("Opened database successfully");
            stmt = (Statement) c.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql); 
                while ( rs.next() ) {
                        Employee employee = new Employee();
                        employee.id.setValue(rs.getInt("EMP_ID"));
                        employee.fname.setValue(rs.getString("EMP_FNAME"));
                        employee.lname.setValue(rs.getString("EMP_LNAME"));
                        employee.team.setValue(rs.getString("EMP_TEAM"));
                        employee.user.setValue(rs.getString("EMP_USER"));
                        employee.cont.setValue(rs.getString("EMP_PHONE"));
                        employee.sal.setValue(rs.getDouble("SALARY"));
                        data.add(employee);
                }  
            
            c.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
    }
    @FXML
    private void UpdateService(ActionEvent event) throws IOException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
     
            
            stmt = c.createStatement();
            String sql = "UPDATE SERVICE set " +s_modatt.getValue()+" = '" +s_modchanges.getText()+"' where SERV_ID='" +s_modid.getText()+"';";
            stmt.executeUpdate(sql);
            c.commit();

            
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            System.out.println("Operation done successfully");

        PopulateServices("SELECT * FROM SERVICE;");
    }
    @FXML
    private void UpdateEmployee(ActionEvent event) throws IOException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
     
            
            stmt = c.createStatement();
            String sql = "UPDATE EMPLOYEE set " +e_modatt.getValue()+" = '" +e_modchanges.getText()+"' where EMP_ID='" +e_modid.getText()+"';";
            stmt.executeUpdate(sql);
            c.commit();

            
            c.close();
            } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            System.out.println("Operation done successfully");

        PopulateEmployee("SELECT * FROM EMPLOYEE;");
    }
    @FXML
    private void CreateService(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "INSERT INTO SERVICE (SERV_NAME, SERV_DESC, SERV_EXPENSE) " +
                        "VALUES "
                        + "('" + s_addname.getText() + "', "
                        + "'" + s_adddes.getText() + "', "
                        + "'" + s_addexp.getText() + "');";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateServices("SELECT * FROM SERVICE;");
         
    }
    @FXML
    private void CreateInventory(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "INSERT INTO ITEM (ITEM_NAME, ITEM_CURRENT, ITEM_REC, ITEM_LOC) " +
                        "VALUES "
                        + "('" + i_addname.getText() + "', "
                        + "'" + i_addcur.getText() + "', "
                        + "'" + i_addrec.getText() + "', "
                        + "'" + i_addloc.getText() + "');";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateInventory("SELECT * FROM ITEM;");
         
    }
    @FXML
    private void CreateEmployee(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "INSERT INTO EMPLOYEE (EMP_FNAME, EMP_LNAME, EMP_TEAM, EMP_USER, EMP_PASSWORD, EMP_PHONE, SALARY) " +
                        "VALUES "
                        + "('" + e_addfname.getText() + "', "
                        + "'" + e_addlname.getText() + "', "
                        + "'" + e_addteam.getValue() + "', "
                        + "'" + e_adduser.getText() + "', "
                        + "'" + e_addpass.getText() + "', "
                        + "'" + e_addcont.getText() + "', "
                        + "'" + e_addsal.getText() + "');";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateEmployee("SELECT * FROM EMPLOYEE;");
         
    }
    @FXML
    private void DeleteService(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "DELETE from SERVICE where SERV_ID="+s_delid.getText()+";";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateServices("SELECT * FROM SERVICE;");
         
    }
     @FXML
    private void DeleteEmployee(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "DELETE from EMPLOYEE where EMP_ID="+e_delid.getText()+";";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateServices("SELECT * FROM EMPLOYEE;");
         
    }
     @FXML
    private void DeleteInventory(ActionEvent event) throws IOException {
            Connection c = null;
            Statement stmt = null;
        try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:test.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                String sql = "DELETE from ITEM where ITEM_ID="+i_delid.getText()+";";
       
                stmt.executeUpdate(sql);

                stmt.close();
                c.commit();
                c.close();
            } 
            catch ( Exception e ) 
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        PopulateInventory("SELECT * FROM ITEM;");
         
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PopulateServices("SELECT * FROM SERVICE;");
        PopulateEmployee("SELECT * FROM EMPLOYEE;");
        PopulateInventory("SELECT * FROM ITEM;");
        
         s_modatt.getItems().addAll(
        "SERV_ID",
        "SERV_NAME",
        "SERV_DESC",
        "SERV_EXPENSE"
        );
         e_modatt.getItems().addAll(
        "EMP_ID",
        "EMP_FNAME",
        "EMP_LNAME",
        "EMP_TEAM",
        "EMP_USER",
        "EMP_PHONE",
        "SALARY"
        );
        e_addteam.getItems().addAll(
        "Management",
        "Front",
        "Service"
        );
    }    
    
}
