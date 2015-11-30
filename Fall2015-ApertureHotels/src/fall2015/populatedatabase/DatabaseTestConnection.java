/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.populatedatabase;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseTestConnection {

    public static void main(String[] args) 
    {
        Connection c = null;
    try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } 
    catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    System.out.println("The Database is working.");
    }
}
    

