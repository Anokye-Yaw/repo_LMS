/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ANOKYE
 */
public class DBConnection {
    
    static Connection conn = null;
    
    public static Connection getConnect(){
    
       try{
           String username = "root";
           String password = "test1";
           String url = "jdbc:mysql://localhost/library_ms";
           
           conn = DriverManager.getConnection(url, username, password);
       
       }catch(Exception ex){
         ex.printStackTrace();
       }
        return conn;
    }
}
