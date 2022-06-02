/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kullanici;
import entity.KullaniciTuru;
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
public class PaketSiparisDAO extends DataBase {

    private Connection connection;
    private KullaniciDAO kullaniciDAO;
    private UrunDAO urunDAO;
    private KategoriDAO kategoriDAO;

    public PaketSiparisDAO() {

    }

    public List<PaketSiparis> getPaketSiparis() {
        List<PaketSiparis> list = new ArrayList<>();
        try {
            Kullanici kullanici;
            KullaniciTuru kullaniciTuru;

            Statement st = getConnection().createStatement();
            Statement st2 = getConnection().createStatement();
            String fk1Query = "SELECT kullanici_id as k FROM paket_siparis GROUP BY kullanici_id";

            ResultSet fk1Rs = st.executeQuery(fk1Query);
            ResultSet mainRs;

            while (fk1Rs.next()) {
                
                kullanici = getKullaniciDAO().findById(fk1Rs.getShort("k"));
                    
                System.out.println("--" + kullanici.getIsim() + "--" + fk1Rs.getShort("k"));
                fk1Query = "SELECT * FROM paket_siparis WHERE kullanici_id=" + kullanici.getId();
                mainRs = st2.executeQuery(fk1Query);
                
                List<Urun> urunler = new ArrayList<>();
                int tutar = 0;

                while (mainRs.next()) {
                    urunler.add(getUrunDAO().findByID(mainRs.getShort("urun_id")));
                    tutar += Integer.valueOf(urunler.get(urunler.size() - 1).getFiyat());
                }

                list.add(new PaketSiparis(kullanici, tutar, urunler));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("list.size():" + list.size());
        return list;
    }

    public void createPaketSiparis(Kullanici kullanici, List<Urun> selectedList) {
        
        try {
            String query = "INSERT INTO paket_siparis(kullanici_id, urun_id, tutar) VALUES (?, ?, ?)";
            
            for(Urun u : selectedList){
                PreparedStatement pst = getConnection().prepareStatement(query);
                pst.setShort(1, kullanici.getId());
                pst.setInt(2, u.getUrunId());
                pst.setInt(3, Integer.valueOf(u.getFiyat()));
                pst.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updatePaketSiparis(PaketSiparis paketSiparis) {

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

    public void deletePaketSiparis(Kullanici kullanici) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("DELETE FROM paket_siparis WHERE kullanici_id=" + kullanici.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = getConnect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }
    
    public UrunDAO getUrunDAO() {
        if (this.urunDAO == null) {
            this.urunDAO = new UrunDAO();
        }
        return urunDAO;
    }

    public void setUrunDAO(UrunDAO urunDAO) {
        this.urunDAO = urunDAO;
    }

    public KategoriDAO getKategoriDAO() {
        if (this.kategoriDAO == null) {
            this.kategoriDAO = new KategoriDAO();
        }
        return kategoriDAO;
    }

    public void setKategoriDAO(KategoriDAO kategoriDAO) {
        this.kategoriDAO = kategoriDAO;
    }

}
