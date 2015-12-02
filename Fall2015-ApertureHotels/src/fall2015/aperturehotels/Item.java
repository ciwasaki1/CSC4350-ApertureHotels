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
public class Item {
        public SimpleIntegerProperty id = new SimpleIntegerProperty();
        public SimpleStringProperty name = new SimpleStringProperty();
        public SimpleIntegerProperty cur = new SimpleIntegerProperty();
        public SimpleIntegerProperty rec = new SimpleIntegerProperty();
        public SimpleStringProperty loc = new SimpleStringProperty();
    public Item() {
    }  
        
        public int getId() 
        {
            return id.get();
        }
 
        public String getName() 
        {
            return name.get();
        }
 
        public int getCur() 
        {
            return cur.get();
        }
 
        public int getRec() 
        {
            return rec.get();
        }
        public String getLoc() 
        {
            return loc.get();
        }
    
}
