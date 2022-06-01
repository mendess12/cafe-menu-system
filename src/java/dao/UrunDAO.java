/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import entity.Urun;
import java.util.List;
import util.DataBase;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import java.sql.Connection;

/**
 *
 * @author Yusuf
 */
public class UrunDAO extends DataBase {

    private Connection connection;
    private KategoriDAO kategoriDao;

    public UrunDAO() {

    }

    public Urun findByID(int urunId) {
        Urun urun = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM urun where urun_id=" + urunId;
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Kategori kategori = this.getKategoriDao().findByID(rs.getInt("kategori_id"));
                urun = new Urun(rs.getInt("urun_id"), kategori, rs.getString("isim"), rs.getInt("fiyat"), rs.getString("aciklama"), rs.getString("imgurls"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return urun;
    }

    public List<Urun> getUrunList() {

        List<Urun> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM urun order by urun_id";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kategori kategori = this.getKategoriDao().findByID(rs.getInt("kategori_id"));

                list.add(new Urun(
                        rs.getInt("urun_id"),
                        kategori,
                        rs.getString("isim"),
                        rs.getInt("fiyat"),
                        rs.getString("aciklama"),
                        rs.getString("imgurls")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Urun> findAll(int page, int pageSize) {

        List<Urun> list = new ArrayList();
        int start = (page - 1) * pageSize;

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM urun order by urun_id asc limit " + pageSize + " offset " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {

                Kategori kategori = this.getKategoriDao().findByID(rs.getInt("kategori_id"));

                list.add(new Urun(
                        rs.getInt("urun_id"),
                        kategori,
                        rs.getString("isim"),
                        rs.getInt("fiyat"),
                        rs.getString("aciklama"),
                        rs.getString("imgurls")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public int count() {

        int count = 0;

        try {

            Statement st = getConnection().createStatement();
            String query = "select count(urun_id) as urun_count from urun";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("urun_count");

            System.out.println("-------------- count -----------" + count);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void createUrun(Urun urun) {

        try {
            
            Connection c = this.getConnect();

            String sql = "insert into urun(kategori_id,isim,fiyat,aciklama,imgurls) values (?, ?, ?, ?, ?)";
            PreparedStatement st = c.prepareStatement(sql);
            st.setInt(1, urun.getKategori().getKategoriId());
            st.setString(2, urun.getIsim());
            st.setInt(3, urun.getFiyat());
            st.setString(4, urun.getAciklama());
            st.setString(5, urun.getImgUrl());
            st.executeUpdate();

    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(urun.getIsim());
        }
    }

    public void updateUrun(Urun urun) {

        try {

            String query = "UPDATE urun SET kategori_id=?,isim=?,fiyat=?,aciklama=? WHERE urun_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);

            pst.setInt(1, urun.getKategori().getKategoriId());
            pst.setString(2, urun.getIsim());
            pst.setInt(3, urun.getFiyat());
            pst.setString(4, urun.getAciklama());
            pst.setInt(5, urun.getUrunId());

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

    public KategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

}
