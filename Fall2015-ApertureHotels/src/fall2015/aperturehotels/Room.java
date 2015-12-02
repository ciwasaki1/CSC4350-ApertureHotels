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
public class Room {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty type = new SimpleStringProperty();
        public SimpleStringProperty stat = new SimpleStringProperty();
        public SimpleIntegerProperty floor = new SimpleIntegerProperty();
        
    public Room() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getType() 
        {
            return type.get();
        }
        public String getStat() 
        {
            return stat.get();
        }
        public Integer getFloor() 
        {
            return floor.get();
        }

    
}
