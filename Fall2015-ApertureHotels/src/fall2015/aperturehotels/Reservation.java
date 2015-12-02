/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import java.sql.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Iwasaki
 */
public class Reservation {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty name = new SimpleStringProperty();
        public SimpleStringProperty sdate = new SimpleStringProperty();
        public SimpleStringProperty edate = new SimpleStringProperty();
        public SimpleIntegerProperty cont = new SimpleIntegerProperty(); 
        public SimpleStringProperty type = new SimpleStringProperty();
        public SimpleStringProperty room = new SimpleStringProperty();
        public SimpleStringProperty floor = new SimpleStringProperty();
        public SimpleStringProperty serv = new SimpleStringProperty();
        
    public Reservation() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getName() 
        {
            return name.get();
        }
 
        public String getSdate() 
        {
            return sdate.get();
        }
 
        public String getEdate() 
        {
            return edate.get();
        }
        public int getCont() 
        {
            return cont.get();
        }
 
        public String getType() 
        {
            return type.get();
        }
 
        public String getRoom() 
        {
            return room.get();
        }
 
        public String getFloor() 
        {
            return floor.get();
        }
        public String getServ() 
        {
            return serv.get();
        }

    
}
