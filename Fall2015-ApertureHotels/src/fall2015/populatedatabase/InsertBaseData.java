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
public class InsertBaseData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Connection c = null;
        Statement stmt = null;
        String sql;
    try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            sql = "INSERT INTO EMPLOYEE (EMP_USER, EMP_FNAME, EMP_FNAME, EMP_TEAM, EMP_PASSWORD, SALARY) " +
                   "VALUES ('username', 'Paul', 'BBQ', 'Management', 'password', 20000.00 );"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO ITEM (ITEM_ID, ITEM_NAME, ITEM_CURRENT, ITEM_REC, ITEM_LOC) " +
            "VALUES (1, 'Pens', 50, 50, '5th Floor Inv Room');"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO TICKET (TICKET_SUB, TICKET_DES, TICKET_STAT, TICKET_TO) " +
            "VALUES ('Need more Pens', 'we need more pens', 'Incomplete', 'Management');"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO SERVICE (SERV_ID, SERV_NAME, SERV_DESC, SERV_EXPENSE) " +
            "VALUES (1, 'Pens', 'we need more pens', 'blah');"; 
            stmt.executeUpdate(sql);
            
            //1ST FLOOR          ///////////////////////////////////////////////////////////////////////////////////////
            
             sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (100, 'LOBBY', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (101, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (102, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (103, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (104, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (105, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (106, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (107, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (108, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (109, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (110, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (111, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (112, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (113, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (114, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (115, 'SINGLE KING BR', 'EMPTY', 1);"; 
            stmt.executeUpdate(sql);
            
            //2-4ST FLOOR          ///////////////////////////////////////////////////////////////////////////////////////
            
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (201, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (202, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (203, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (204, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (205, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (206, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (207, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (208, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (209, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (210, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (211, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (212, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (213, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (214, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (215, 'DOUBLE KING BR', 'EMPTY', 2);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (301, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (302, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (303, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (304, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (305, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (306, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (307, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (308, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (309, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (310, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (311, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (312, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (313, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (314, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (315, 'DOUBLE KING BR', 'EMPTY', 3);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (401, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (402, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (403, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (404, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (405, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (406, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (407, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (408, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (409, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (410, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (411, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (412, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (413, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (414, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (415, 'DOUBLE KING BR', 'EMPTY', 4);"; 
            stmt.executeUpdate(sql);
            
            //5TH FLOOR PREMIUM ////////////////////////////////////////////////////////////////////////////////////////
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (501, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (502, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (503, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (504, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (505, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (506, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (507, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (508, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (509, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (510, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (511, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (512, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (513, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (514, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO ROOM (ROOM_ID, ROOM_TYPE, ROOM_STATUS, ROOM_FLOOR) " +
            "VALUES (515, 'VIP SUITE', 'EMPTY', 5);"; 
            stmt.executeUpdate(sql);
            /*
            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
            "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
            "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
            stmt.executeUpdate(sql);
            */
            stmt.close();
            c.commit();
            c.close();
        } 
    catch ( Exception e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    System.out.println("The Database is working.");
    }
    
}
