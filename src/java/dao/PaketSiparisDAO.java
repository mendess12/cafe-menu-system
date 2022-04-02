/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import entity.PaketSiparis;
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
public class PaketSiparisDAO extends DataBase{
    
    private Connection connection;
    
    public PaketSiparisDAO(){
        
    }
    
    public List<PaketSiparis> getPaketSiparis(){
        List<PaketSiparis> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query = "SELECT * FROM paket_siparis";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                list.add(new PaketSiparis(rs.getShort("siparis_no"), rs.getInt("kullanici_id"), 
                    rs.getInt("urun_id"), rs.getInt("tutar")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void createPaketSiparis(PaketSiparis paketSiparis){
        try {
            String query = "INSERT INTO paket_siparis(kullanici_id, urun_id, tutar) VALUES (?, ?, ?)";
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setInt(1, paketSiparis.getKullaniciId());
            pst.setInt(2, paketSiparis.getUrunId());
            pst.setInt(3, paketSiparis.getTutar());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    public void updatePaketSiparis(PaketSiparis paketSiparis){

        String query = "UPDATE paket_siparis SET kullanici_id=?, urun_id=?, tutar=? WHERE siparis_no=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setInt(1, paketSiparis.getKullaniciId());
            pst.setInt(2, paketSiparis.getUrunId());
            pst.setInt(3, paketSiparis.getTutar());
            pst.setShort(4, paketSiparis.getSiparisNo());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deletePaketSiparis(PaketSiparis paketSiparis){
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("DELETE FROM paket_siparis WHERE id=" + paketSiparis.getSiparisNo());
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
