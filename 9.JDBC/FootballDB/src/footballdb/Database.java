/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * @author Cosmin
 */
public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "dba1";
    private static final String PASSWORD = "sql";
    private static Savepoint save1;
    private static Connection connection = null;
    
    private Database(){}
    public static Connection getConnection(){
     if(connection == null){
         createConnection();
     }
     return connection;
    }
    
    
    public static void createConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            save1 = connection.setSavepoint();
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    
    public static void commit(){
       try{
        connection.commit();
       }catch(SQLException ex){
           System.err.println(ex);
       } 
    }
    
    
    public static void rollback(){
        try{
            connection.rollback(save1);
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
}
