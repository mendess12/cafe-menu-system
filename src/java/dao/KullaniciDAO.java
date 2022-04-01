/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import util.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;


/**
 *
 * @author 1907h
 */
public class KullaniciDAO extends DataBase{
    
    private Connection connection;
    
    public KullaniciDAO(){
        
    }
    
    public List<Kullanici> getKullaniciList(){
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query = "SELECT * FROM kullanici";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                list.add(new Kullanici(rs.getShort("id"), rs.getShort("kullanici_id"), 
                    rs.getString("password"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("adres")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }

    public Connection getConnection() {
        if(this.connection == null){
            connection = getConnect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    
    
    
    
}
