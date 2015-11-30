/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import java.sql.Date;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Iwasaki
 */
public class Guest {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty fname = new SimpleStringProperty();
        public SimpleStringProperty lname = new SimpleStringProperty();
        public SimpleStringProperty add1 = new SimpleStringProperty();
        public SimpleStringProperty add2 = new SimpleStringProperty(); 
        public SimpleStringProperty city = new SimpleStringProperty();
        public SimpleIntegerProperty zcode = new SimpleIntegerProperty();
        public SimpleStringProperty state = new SimpleStringProperty();
        public SimpleStringProperty email = new SimpleStringProperty();
        public SimpleStringProperty pnum = new SimpleStringProperty();
        public SimpleBooleanProperty offer = new SimpleBooleanProperty();
        public SimpleIntegerProperty size = new SimpleIntegerProperty();
        
    public Guest() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getFname() 
        {
            return fname.get();
        }
 
        public String getLname() 
        {
            return lname.get();
        }
 
        public String getAdd1() 
        {
            return add1.get();
        }
        public String getAdd2() 
        {
            return add2.get();
        }
 
        public String getCity() 
        {
            return city.get();
        }
 
        public Integer getZcode() 
        {
            return zcode.get();
        }
 
        public String getState() 
        {
            return state.get();
        }
        public String getEmail() 
        {
            return email.get();
        }
        public String getPnum() 
        {
            return pnum.get();
        }
 
        public Boolean getOffer() 
        {
            return offer.get();
        }
        public Integer getSize() 
        {
            return size.get();
        }

    
}