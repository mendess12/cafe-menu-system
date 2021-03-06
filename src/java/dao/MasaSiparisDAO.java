/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Adisyon;
import entity.MasaSiparis;
import entity.Urun;
import java.util.List;
import util.DataBase;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author Yusuf
 */
public class MasaSiparisDAO extends DataBase {

    private Connection connection;
    private AdisyonDAO adisyonDao;
    private UrunDAO urunDao;

    public MasaSiparisDAO() {

    }

    public List<MasaSiparis> getMasaSiparisList() {

        List<MasaSiparis> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM masa_siparis";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Adisyon adisyon = this.getAdisyonDao().findByID(rs.getInt("adisyon_id"));
                Urun urun = this.getUrunDao().findByID(rs.getInt("urun_id"));

                list.add(new MasaSiparis(rs.getInt("siparis_id"), adisyon,
                        urun, rs.getInt("tutar"), rs.getBoolean("siparis_durumu")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createMasaSiparis(MasaSiparis ms) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO masa_siparis(adisyon_id,urun_id,tutar,siparis_durumu) VALUES ('" + ms.getAdisyon().getAdisyonId() + "','" + ms.getUrun().getUrunId() + "','"
                    + ms.getTutar() + "','" + ms.isSiparisDurumu() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateMasaSiparis(MasaSiparis ms) {

        try {

            String query = "UPDATE masa_siparis SET adisyon_id=?,urun_id=?,tutar=?,siparis_durumu=? WHERE siparis_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);

            pst.setInt(1, ms.getAdisyon().getAdisyonId());
            pst.setInt(2, ms.getUrun().getUrunId());
            pst.setInt(3, ms.getTutar());
            pst.setBoolean(4, ms.isSiparisDurumu());
            pst.setInt(5, ms.getSiparisId());

            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteMasaSiparis(MasaSiparis ms) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM masa_siparis WHERE siparis_id=" + ms.getSiparisId();
            st.executeUpdate(query);

        } catch (Exception ex) {
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

    public AdisyonDAO getAdisyonDao() {
        if (adisyonDao == null) {
            this.adisyonDao = new AdisyonDAO();
        }
        return adisyonDao;
    }

    public void setAdisyonDao(AdisyonDAO adisyonDao) {
        this.adisyonDao = adisyonDao;
    }

    public UrunDAO getUrunDao() {
        if (urunDao == null) {
            this.urunDao = new UrunDAO();
        }
        return urunDao;
    }

    public void setUrunDao(UrunDAO urunDao) {
        this.urunDao = urunDao;
    }

}
