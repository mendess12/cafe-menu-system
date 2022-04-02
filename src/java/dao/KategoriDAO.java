/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import java.util.List;
import util.DataBase;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author Safa
 */
public class KategoriDAO extends DataBase {

    private Connection connection;

    public KategoriDAO() {

    }

    public List<Kategori> getKategoriList() {

        List<Kategori> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM kategori";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kategori(rs.getInt("kategori_id"),rs.getString("tur")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createKategori(Kategori kt) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO (kategori_id,tur) VALUES ('" + kt.getKategoriId()+ "'"
                    + ",'" + kt.getTur()+ "')";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateKategori(Kategori kt) {

        try {
            
            String query = "UPDATE kategori SET tur=? WHERE kategori_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
           
            pst.setString(1,kt.getTur());
            pst.setInt(3,kt.getKategoriId());
            
            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteKategori(Kategori kt) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM kategori WHERE kategori_id=" + kt.getKategoriId();
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
