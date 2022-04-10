/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Rezervasyon;
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
public class RezervasyonDAO extends DataBase {

    private Connection connection;

    public RezervasyonDAO() {

    }

    public List<Rezervasyon> getRezervasyonList() {

        List<Rezervasyon> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM rezervasyon";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Rezervasyon(rs.getShort("rezervasyon_id"), rs.getShort("masa_no"),
                        rs.getString("tarih"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("tel_no")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createRezervasyon(Rezervasyon rz) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO rezervasyon VALUES ('" + rz.getMasaNo() + "'"
                    + ",'" + rz.getTarih() +",'" + rz.getIsim() +",'" + rz.getSoyisim() + "','" + rz.getTelNo() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateRezervasyon(Rezervasyon rz) {

        try {

            String query = "update masa set masa_no='" + rz.getMasaNo() + "',tarih='" + rz.getTarih() + "',isim='" + rz.getIsim() + "',soyisim='" + rz.getSoyisim() + "',tel_no='" + rz.getTelNo() + "' where rezervasyon_id=" + rz.getRezervasyonId();
            PreparedStatement pst = this.getConnection().prepareStatement(query);

            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteRezervasyon(Rezervasyon rz) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM rezervasyon WHERE rezervasyon_id=" + rz.getRezervasyonId();
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
