/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;
import java.sql.Date;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Iwasaki
 */
public class Employee {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty fname = new SimpleStringProperty();
        public SimpleStringProperty lname = new SimpleStringProperty();
        public SimpleStringProperty team = new SimpleStringProperty();
        public SimpleStringProperty user = new SimpleStringProperty(); 
        public SimpleStringProperty cont = new SimpleStringProperty();
        public SimpleDoubleProperty sal = new SimpleDoubleProperty();
       
        
    public Employee() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getFname() 
        {
            return fname.get();
        }
 
        public String getSdate() 
        {
            return lname.get();
        }
 
        public String getEdate() 
        {
            return team.get();
        }
        public String getCont() 
        {
            return user.get();
        }
 
        public String getType() 
        {
            return cont.get();
        }
 
        public Double getRoom() 
        {
            return sal.get();
        }


    
}