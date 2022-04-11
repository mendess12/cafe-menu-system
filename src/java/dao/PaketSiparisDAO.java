/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.Kategori;
import entity.Kullanici;
import entity.PaketSiparis;
import entity.Urun;
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
    private KullaniciDAO kullaniciDAO;
    private UrunDAO urunDAO;
    private KategoriDAO kategoriDAO;
    
    public PaketSiparisDAO(){
        
    }
    
    public List<PaketSiparis> getPaketSiparis(){
        List<PaketSiparis> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query_1 = "SELECT kullanici_id as k,  FROM paket_siparis GROUP BY kullanici_id";
            String query_2;
            
            ResultSet rs_1 = st.executeQuery(query_1);
            ResultSet rs_2;
            
            Urun u;
            Kullanici kullanici;
            Kategori k;
            PaketSiparis ps;
            
            int tutar = 0;
            int id;
            
            while(rs_1.next()){
                ps = new PaketSiparis();
                id = rs_1.getInt("k");
                query_2 = "SELECT * FROM urun WHERE kullanici_id=" + id;
                rs_2 = st.executeQuery(query_2);
                while(rs_2.next()){
                    k = kategoriDAO.findByID(rs_2.getInt("kategori_id"));
                    u = new Urun(rs_2.getShort("urun_id"), k, rs_2.getString("isim"), rs_2.getInt("fiyat"), rs_2.getString("aciklama"));
                    ps.getSelectedList().add(u);
                    tutar += rs_2.getInt("fiyat");
                }
                
                ps.setKullanici(kullaniciDAO.findById(id));
                ps.setTutar(tutar);
                list.add(ps);
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
            
            pst.setShort(1, paketSiparis.getKullanici().getId());
            pst.setInt(2, paketSiparis.getUrun().getUrunId());
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
            /*
            pst.setInt(1, paketSiparis.getKullaniciId());
            pst.setInt(2, paketSiparis.getUrunId());
            pst.setInt(3, paketSiparis.getTutar());
            pst.setShort(4, paketSiparis.getSiparisNo());
            */
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

    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO == null)
            this.kullaniciDAO = new KullaniciDAO();
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public UrunDAO getUrunDAO() {
        if(this.urunDAO == null)
            this.urunDAO = new UrunDAO();
        return urunDAO;
    }

    public void setUrunDAO(UrunDAO urunDAO) {
        this.urunDAO = urunDAO;
    }

    public KategoriDAO getKategoriDAO() {
        if(this.kategoriDAO == null){
            this.kategoriDAO = new KategoriDAO();
        }
        return kategoriDAO;
    }

    public void setKategoriDAO(KategoriDAO kategoriDAO) {
        this.kategoriDAO = kategoriDAO;
    }
    
    
    
}
