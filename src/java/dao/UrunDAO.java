/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
public class UrunDAO extends DataBase {

    private Connection connection;

    public UrunDAO() {

    }

    public List<Urun> getUrunList() {

        List<Urun> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM urun";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Urun(rs.getShort("urun_id"), rs.getInt("kategori_id"),
                        rs.getString("isim"), rs.getInt("fiyat"), rs.getString("aciklama")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createUrun(Urun urun) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO (urun_id,kategori_id,isim,fiyat,aciklama) VALUES ('" + urun.getUrunId() + "'"
                    + ",'" + urun.getKategoriId() + "','" + urun.getIsim() + "','" + urun.getFiyat() + "','" + urun.getAciklama() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateUrun(Urun urun) {

        try {

            String query = "UPDATE urun SET kategori_id=?,isim=?,fiyat=?,aciklama=? WHERE urun_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);

            pst.setInt(1, urun.getKategoriId());
            pst.setString(2, urun.getIsim());
            pst.setInt(3, urun.getFiyat());
            pst.setString(4, urun.getAciklama());
            pst.setShort(5, urun.getUrunId());

            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteUrun(Urun urun) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM urun WHERE urun_id=" + urun.getUrunId();
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
