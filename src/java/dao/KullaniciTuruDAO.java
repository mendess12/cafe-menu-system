/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KullaniciTuru;
import util.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1907h
 */
public class KullaniciTuruDAO extends DataBase{
    
    private Connection connection;
    
    public KullaniciTuruDAO(){
        
        
        
    }

    public List<KullaniciTuru> getKullaniciTuruList(){
        List<KullaniciTuru> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query = "SELECT * FROM kullanici_turu";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                list.add(new KullaniciTuru(rs.getShort("kullanici_id"), rs.getString("kullanici")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void createKullaniciTuru(KullaniciTuru kullaniciTuru){
        try {
            String query = "INSERT INTO kullanici_turu(kullanici_id, kullanici) VALUES (?, ?)";
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setShort(1, kullaniciTuru.getKullaniciId());
            pst.setString(2, kullaniciTuru.getKullanici());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void updateKullanici(KullaniciTuru kullaniciTuru){

        String query = "UPDATE kullanici_turu SET kullanici=? WHERE kullanici_id=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setString(1, kullaniciTuru.getKullanici());
            pst.setInt(2, kullaniciTuru.getKullaniciId());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteKullanici(KullaniciTuru kullaniciTuru){
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("DELETE FROM kullanici_turu WHERE id=" + kullaniciTuru.getKullaniciId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public Connection getConnection() {
        if(this.connection == null){
            this.connection = getConnect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
