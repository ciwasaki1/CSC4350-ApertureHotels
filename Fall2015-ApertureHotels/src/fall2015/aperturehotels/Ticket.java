/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Iwasaki
 */
public class Ticket {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty sub = new SimpleStringProperty();
        public SimpleStringProperty des = new SimpleStringProperty();
        public SimpleStringProperty stat = new SimpleStringProperty();
        
    public Ticket() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getSub() 
        {
            return sub.get();
        }
 
        public String getDes() 
        {
            return des.get();
        }
 
        public String getStat() 
        {
            return stat.get();
        }

    
}
