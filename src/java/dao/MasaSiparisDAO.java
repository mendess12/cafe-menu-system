/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.MasaSiparis;
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

    public MasaSiparisDAO() {

    }

    public List<MasaSiparis> getMasaSiparisList() {

        List<MasaSiparis> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM masa_siparis";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new MasaSiparis(rs.getShort("siparis_id"), rs.getInt("adisyon_id"),
                        rs.getInt("urun_id"), rs.getInt("tutar"), rs.getBoolean("siparis_durum")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createMasaSiparis(MasaSiparis ms) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO (siparis_id,adisyon_id,urun_id,tutar,siparis_durum) VALUES ('" + ms.getSiparisId() + "'"
                    + ",'" + ms.getAdisyonId() + "','" + ms.getUrunId() + "','" + ms.getTutar() + "','" + ms.isSiparisDurumu() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateMasaSiparis(MasaSiparis ms) {

        try {
            
            String query = "UPDATE masa_siparis SET adisyon_id=?,urun_id=?,tutar=?,siparis_durumu=? WHERE siparis_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
           
            pst.setInt(1,ms.getAdisyonId());
            pst.setInt(2,ms.getUrunId());
            pst.setInt(3,ms.getTutar());
            pst.setBoolean(4,ms.isSiparisDurumu());
            pst.setShort(5,ms.getSiparisId());
            
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

}
