package dao;

import entity.Kullanici;
import util.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author 1907h
 */
public class KullaniciDAO extends DataBase{
    
    private Connection connection;
    
    public KullaniciDAO(){
        
    }
    
    public List<Kullanici> getKullaniciList(){
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query = "SELECT * FROM kullanici";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                list.add(new Kullanici(rs.getShort("id"), rs.getShort("kullanici_id"), 
                    rs.getString("password"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("adres")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void createKullanici(Kullanici kullanici){
        try {
            String query = "INSERT INTO kullanici(kullanici_id, password, isim, soyisim, adres) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setShort(1, kullanici.getKullaniciId());
            pst.setString(2, kullanici.getPassword());
            pst.setString(3, kullanici.getIsim());
            pst.setString(4, kullanici.getSoyisim());
            pst.setString(5, kullanici.getAdres());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void updateKullanici(Kullanici kullanici){
        
    }
    
    public void deleteKullanici(Kullanici kullanici){
        
    }

    public Connection getConnection() {
        if(this.connection == null){
            connection = getConnect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    
    
    
    
}