/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Adisyon;
import entity.Masa;
import util.DataBase;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author Yusuf
 */
public class AdisyonDAO extends DataBase {

    private Connection connection;
    private MasaDAO masaDao;

    public AdisyonDAO() {

    }

    public Adisyon findByID(int adisyonId) {
        Adisyon adisyon = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM adisyon where adisyon_id=" + adisyonId;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Masa masa = this.getMasaDao().findByID(rs.getInt("masa_no"));

                adisyon = new Adisyon(rs.getInt("adisyon_id"), masa, rs.getInt("tutar"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return adisyon;
    }

    public List<Adisyon> getAdisyonList() {

        List<Adisyon> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM adisyon";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Masa masa = this.getMasaDao().findByID(rs.getInt("masa_no"));

                list.add(new Adisyon(rs.getInt("adisyon_id"), masa, rs.getInt("tutar")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createAdisyon(Adisyon adisyon) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO adisyon(adisyon_id,masa_no,tutar) VALUES ('" + adisyon.getAdisyonId() + "','" + adisyon.getMasa().getMasaNo() + "','" + adisyon.getTutar() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateAdisyon(Adisyon adisyon) {

        try {

            String query = "UPDATE adisyon SET masa_no=?,tutar=? WHERE adisyon_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);

            pst.setInt(1, adisyon.getMasa().getMasaNo());
            pst.setInt(2, adisyon.getTutar());
            pst.setInt(3, adisyon.getAdisyonId());

            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteAdisyon(Adisyon adisyon) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM adisyon WHERE adisyon_id=" + adisyon.getAdisyonId();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public java.sql.Connection getConnection() {
        if (this.connection == null) {
            this.connection = getConnect();
        }
        return connection;
    }

    public void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }

    public MasaDAO getMasaDao() {
        if (masaDao == null) {
            this.masaDao = new MasaDAO();
        }
        return masaDao;
    }

    public void setMasaDao(MasaDAO masaDao) {
        this.masaDao = masaDao;
    }

}
