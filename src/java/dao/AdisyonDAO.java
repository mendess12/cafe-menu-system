/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Adisyon;
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

    public AdisyonDAO() {

    }

    public List<Adisyon> getAdisyonList() {

        List<Adisyon> list = new ArrayList();

        try {

            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM adisyon";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Adisyon(rs.getShort("adisyon_id"), rs.getInt("masa_no"),
                        rs.getInt("tutar")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void createAdisyon(Adisyon adisyon) {

        try {

            Statement st = this.getConnection().createStatement();
            String query = "INSERT INTO (adisyon_id,masa_no,tutar) VALUES ('" + adisyon.getAdisyonId() + "','" + adisyon.getMasaNo() + "','" + adisyon.getTutar() + "')";
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
       public void updateAdisyon(Adisyon adisyon) {

        try {
            
            String query = "UPDATE adisyon SET masa_no=?,tutar=? WHERE adisyon_id=?";
            PreparedStatement pst = this.getConnection().prepareStatement(query);
           
            pst.setInt(1,adisyon.getMasaNo());
            pst.setInt(2,adisyon.getTutar());
            pst.setShort(3,adisyon.getAdisyonId());
            
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

}
