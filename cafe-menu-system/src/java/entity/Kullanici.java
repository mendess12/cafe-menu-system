/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author 1907h
 */
public class Kullanici {
    
    private short id;
    private short kullaniciId;
    private String password;
    private String isim;
    private String soyisim;
    private String adres;
    
    public Kullanici(){
        
    }

    public Kullanici(short kullaniciId, String password, String isim, String soyisim, String adres) {
        this.kullaniciId = kullaniciId;
        this.password = password;
        this.isim = isim;
        this.soyisim = soyisim;
        this.adres = adres;
    }
    
    

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(short kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
    
}
