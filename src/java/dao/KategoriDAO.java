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
    public Kategori findByID(int kategoriId){
        Kategori kategori = null;

        try{
            Statement st = this.getConnection().createStatement();
            String query = "SELECT * FROM kategori where kategori_id="+kategoriId;
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                kategori = new Kategori(rs.getInt("kategori_id"),rs.getString("tur"));
            }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return kategori;
    }
    public void createKategori(Kategori kt) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO kategori VALUES ('" + kt.getKategoriId()+ "'"
                    + ",'" + kt.getTur()+ "')";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateKategori(Kategori kt) {

        try {
            
            String query = "update kategori set tur='"+kt.getTur()+"' where kategori_id="+kt.getKategoriId();
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            
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
