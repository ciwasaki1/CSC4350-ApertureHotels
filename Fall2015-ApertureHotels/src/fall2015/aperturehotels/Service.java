/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.aperturehotels;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Iwasaki
 */
public class Service {
        public SimpleIntegerProperty id = new SimpleIntegerProperty(); 
        public SimpleStringProperty name = new SimpleStringProperty();
        public SimpleStringProperty des = new SimpleStringProperty();
        public SimpleDoubleProperty exp = new SimpleDoubleProperty();
        
    public Service() {
    }
        public int getId() 
        {
            return id.get();
        }
 
        public String getName() 
        {
            return name.get();
        }
 
        public String getDes() 
        {
            return des.get();
        }
 
        public Double getExp() 
        {
            return exp.get();
        }

    
}
