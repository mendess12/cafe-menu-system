package dao;

import entity.Kullanici;
import entity.KullaniciTuru;
import util.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author 1907h
 */
public class KullaniciDAO extends DataBase {

    private Connection connection;
    private KullaniciTuruDAO kullaniciTuruDAO;

    public KullaniciDAO() {

    }
    
    public Kullanici findById(int kullanici){
        Kullanici k = new Kullanici();
        try {
            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM kullanici WHERE id="+kullanici;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                KullaniciTuru kt = getKullaniciTuruDAO().findById(rs.getShort("kullanici_id"));
                k = new Kullanici(rs.getShort("id"), kt, rs.getString("password"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("adres"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return k;
    }
    
    public boolean verifyLogin(Kullanici k){
        try {
            Statement st = getConnection().createStatement();
            String query = "SELECT * FROM kullanici WHERE isim='"+k.getIsim()+"' AND password='"+k.getPassword()+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                KullaniciTuru kt = getKullaniciTuruDAO().findById(rs.getShort("kullanici_id"));
                k.setId(rs.getShort("id")); 
                k.setKullaniciTuru(kt);
                k.setSoyisim(rs.getString("soyisim"));
                k.setAdres(rs.getString("adres"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(k.getId() != 0){
            return true;
        }
        return false;
    }

    public List<Kullanici> getKullaniciList() {
        List<Kullanici> list = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();

            String query = "SELECT * FROM kullanici";
            ResultSet rs = st.executeQuery(query);
            
            KullaniciTuru kullaniciTuru;
            while (rs.next()) {
                kullaniciTuru = getKullaniciTuruDAO().findById(rs.getShort("kullanici_id"));
                list.add(new Kullanici(rs.getShort("id"), kullaniciTuru,
                        rs.getString("password"), rs.getString("isim"), rs.getString("soyisim"), rs.getString("adres")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void createKullanici(Kullanici kullanici) {
        try {
            String query = "INSERT INTO kullanici(kullanici_id, password, isim, soyisim, adres) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = getConnection().prepareStatement(query);

            pst.setShort(1, kullanici.getKullaniciTuru().getKullaniciId());
            pst.setString(2, kullanici.getPassword());
            pst.setString(3, kullanici.getIsim());
            pst.setString(4, kullanici.getSoyisim());
            pst.setString(5, kullanici.getAdres());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void updateKullanici(Kullanici kullanici) {

        String query = "UPDATE kullanici SET kullanici_id=?, password=?, isim=?, soyisim=?, adres=? WHERE id=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(query);

            pst.setInt(1, kullanici.getKullaniciTuru().getKullaniciId());
            pst.setString(2, kullanici.getPassword());
            pst.setString(3, kullanici.getIsim());
            pst.setString(4, kullanici.getSoyisim());
            pst.setString(5, kullanici.getAdres());
            pst.setInt(6, kullanici.getId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteKullanici(Kullanici kullanici) {
        try {
            Statement st = getConnection().createStatement();
            st.executeUpdate("DELETE FROM kullanici WHERE id=" + kullanici.getId());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connection getConnection() {
        if (this.connection == null) {
            connection = getConnect();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public KullaniciTuruDAO getKullaniciTuruDAO() {
        if (this.kullaniciTuruDAO == null) {
            kullaniciTuruDAO = new KullaniciTuruDAO();
        }
        return kullaniciTuruDAO;
    }

    public void setKullaniciTuruDAO(KullaniciTuruDAO kullaniciTuruDAO) {
        this.kullaniciTuruDAO = kullaniciTuruDAO;
    }

}
