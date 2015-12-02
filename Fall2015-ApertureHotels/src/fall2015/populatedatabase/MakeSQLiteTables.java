/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fall2015.populatedatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Iwasaki
 */
public class MakeSQLiteTables {

    
    public static void main(String[] args) 
    {
        Connection c = null;
        Statement stmt = null;
        String sql;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");
            
            
            //HOTEL, GUEST, RESERVATION, TOOM

            // Employee
            stmt = c.createStatement();
            sql = "CREATE TABLE EMPLOYEE " +
                   "(EMP_ID              INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " EMP_USER            TEXT, " + 
                   " EMP_PASSWORD        TEXT, " + 
                   " EMP_FNAME           TEXT, " + 
                   " EMP_MNAME           TEXT, " + 
                   " EMP_LNAME           TEXT, " + 
                   " EMP_BDATE           INT, " + 
                   " EMP_ADDRESS1        CHAR(50), " + 
                   " EMP_ADDRESS2        CHAR(50), " + 
                   " EMP_CITY            TEXT, " + 
                   " EMP_STATE           TEXT, " +
                   " EMP_ZCODE           TEXT, " + 
                   " EMP_PHONE           TEXT, " + 
                   " EMP_EMAIL           TEXT, " + 
                   " EMP_TEAM            TEXT, " + 
                   " SALARY              REAL)"; 
            stmt.executeUpdate(sql);
            
            
            // Reservation
            stmt = c.createStatement();
            sql = "CREATE TABLE GUEST " +
                   "(G_ID                INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " G_FNAME             TEXT                NOT NULL," + 
                   " G_LNAME             TEXT                NOT NULL, " + 
                   " G_ADD1              TEXT, " + 
                   " G_ADD2              TEXT, " + 
                   " G_CITY              TEXT, " + 
                   " G_ZCODE             INT, " + 
                   " G_STATE             TEXT, " + 
                   " G_EMAIL             TEXT, " + 
                   " G_PNUM              TEXT, " +
                   " G_OFFERSTAT         BOOLEAN, " + 
                   " G_SIZE              INT)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            // Items
            stmt = c.createStatement();
            sql = "CREATE TABLE ITEM " +
                   "(ITEM_ID             INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " ITEM_NAME           TEXT                NOT NULL, " + 
                   " ITEM_CURRENT        INT                 NOT NULL, " + 
                   " ITEM_REC            INT                 NOT NULL, " + 
                   " ITEM_LOC            TEXT                NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            
            stmt = c.createStatement();
            sql = "CREATE TABLE TICKET " +
                   "(TICKET_ID           INTEGER PRIMARY KEY                AUTOINCREMENT," +
                   " TICKET_SUB          TEXT                          NOT NULL, " + 
                   " TICKET_DES          TEXT                          NOT NULL, " +
                   " TICKET_STAT         TEXT                          NOT NULL, " +
                   " TICKET_TO           TEXT                          NOT NULL, " + 
                   " FOREIGN KEY(TICKET_TO) REFERENCES EMPLOYEE(EMP_TEAM))"; 
                   
            stmt.executeUpdate(sql);
            stmt.close();
            
            
             // Services
            stmt = c.createStatement();
            sql = "CREATE TABLE SERVICE " +
                   "(SERV_ID             INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " SERV_NAME           TEXT                NOT NULL, " + 
                   " SERV_DESC           TEXT                NOT NULL, " + 
                   " SERV_EXPENSE        TEXT)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            stmt = c.createStatement();
            sql = "CREATE TABLE HOTEL " +
                   "(HOTEL_ID           INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " NAME                TEXT    NOT NULL, " + 
                   " AGE                 INT     NOT NULL, " + 
                   " ADDRESS             CHAR(50), " + 
                   " SALARY              REAL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            
            // Items
            stmt = c.createStatement();
            sql = "CREATE TABLE RESERVATION " +
                   "(RES_ID              INTEGER PRIMARY KEY     AUTOINCREMENT," +
                   " RES_NAME            TEXT    NOT NULL, " + 
                   " RES_SDATE           STRING     NOT NULL, " + 
                   " RES_EDATE           STRING, " + 
                   " RES_CONTACT         TEXT     NOT NULL, " + 
                   " RES_TYPE            TEXT     NOT NULL, " + 
                   " RES_ROOM            INT     NOT NULL, " +
                   " RES_FLOOR           INT     NOT NULL, " + 
                   " FOREIGN KEY(RES_ROOM) REFERENCES ROOM(ROOM_ID)" +
                   " FOREIGN KEY(RES_TYPE) REFERENCES ROOM(ROOM_TYPE)" +
                   " FOREIGN KEY(RES_FLOOR) REFERENCES ROOM(ROOM_FLOOR))"; 
            stmt.executeUpdate(sql);
            stmt.close();
            
            
            // Items
            stmt = c.createStatement();
            sql = "CREATE TABLE ROOM " +
                   "(ROOM_ID INT PRIMARY KEY     NOT NULL," +
                   " ROOM_TYPE           TEXT    NOT NULL, " + 
                   " ROOM_STATUS         TEXT    NOT NULL, " + 
                   " ROOM_FLOOR          INT     NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
          
            
            
            c.close();
        } catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table Created");
        
    }   
    
}
