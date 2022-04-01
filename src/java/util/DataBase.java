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
    
    public Connection getConnect(){
        Connection conn = null;
        
        try{
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cmsdb", "root", "12345");
            return conn;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
}
