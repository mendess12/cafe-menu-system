package dao;


import entity.Rezervasyon;
import util.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


/**
 *
 * @author 1907h
 */
public class RezervasyonDAO extends DataBase{
    
    private Connection connection;
    
    public RezervasyonDAO(){
        
    }
    
    public List<Rezervasyon> getRezervasyonList(){
        List<Rezervasyon> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            
            String query = "SELECT * FROM rezervasyon";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                list.add(new Rezervasyon(rs.getShort("rezervasyon_id"), rs.getShort("masa_no"), 
                    rs.getDate("tarih"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("tel_no")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void createRezervasyon(Rezervasyon rezervasyon){
        
        try{
            String query = "INSERT INTO rezervasyon(masa_no,tarih,isim,soyisim,tel_no) Values (?,?,?,?,?)";
            PreparedStatement pst = getConnection().prepareStatement(query);
            //System.out.println("tryin 1");
            pst.setInt(1,rezervasyon.getMasaNo());
            //System.out.println("tryin 2i"+rezervasyon.getTarih().toString());
            
            
            pst.setDate(2, new java.sql.Date(rezervasyon.getTarih().getTime()));
            System.out.println("tryin 3");
            pst.setString(3,rezervasyon.getIsim());
            System.out.println("tryin 4");
            pst.setString(4,rezervasyon.getSoyisim());
            System.out.println("tryin 5");
            pst.setString(5,rezervasyon.getTelNo());
            System.out.println("tryin 6");
            pst.executeUpdate();
            System.out.println("tryin 7");
        }catch(SQLException ex){
            System.out.println("catch ici");
        }
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

    public void deleteRezervasyon(Rezervasyon rezervasyon) {
        
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("DELETE FROM rezervasyon WHERE id=" + rezervasyon.getRezervasyonId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void updateRezervasyon(Rezervasyon rezervasyon) {
        String query = "UPDATE kullanici SET masa_no=?, tarih=?, isim=?, soyisim=? tel_no=? WHERE rezervasyon_id=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(query);
            
            pst.setInt(1, rezervasyon.getMasaNo());
            pst.setDate(2, new Date(rezervasyon.getTarih().getTime()));
            pst.setString(3, rezervasyon.getIsim());
            pst.setString(4, rezervasyon.getSoyisim());
            pst.setString(5, rezervasyon.getTelNo());
            pst.setInt(6, rezervasyon.getRezervasyonId());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
