/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author 1907h
 */
public abstract class DataBase {
    
    protected Connection getConnect(){
        Connection conn = null;
        
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmsdb", "root", "12345");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
}
