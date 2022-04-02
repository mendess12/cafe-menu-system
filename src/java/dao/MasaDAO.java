/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Masa;
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
public class MasaDAO extends DataBase {

    private Connection connection;

    public MasaDAO() {

    }

    public List<Masa> getMasaList() {

        List<Masa> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM masa";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Masa(rs.getInt("masa_no"),rs.getBoolean("musait_mi"), rs.getInt("kac_kisilik")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createMasa(Masa ms) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO (masa_no,musait_mi,kac_kisilik) VALUES ('" + ms.getMasaNo()+ "'"
                    + ",'" + ms.isMusaitMi() + "','" + ms.getKacKisilik() + "')";
            int r = st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateMasa(Masa ms) {

        try {
            
            String query = "UPDATE masa SET musait_mi=?,kac_kisilik=? WHERE masa_no=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
           
            pst.setBoolean(1,ms.isMusaitMi());
            pst.setInt(2,ms.getKacKisilik());
            pst.setInt(3,ms.getMasaNo());
            
            pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteMasa(Masa ms) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM masa WHERE masa_no=" + ms.getMasaNo();
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
