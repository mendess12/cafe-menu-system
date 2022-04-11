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
    private KullaniciTuru kullaniciTuru;
    private String password;
    private String isim;
    private String soyisim;
    private String adres;

    public Kullanici() {

    }

    public Kullanici(short id, KullaniciTuru kullaniciTuru, String password, String isim, String soyisim, String adres) {
        this.id = id;
        this.kullaniciTuru = kullaniciTuru;
        this.password = password;
        this.isim = isim;
        this.soyisim = soyisim;
        this.adres = adres;
    }

    public KullaniciTuru getKullaniciTuru() {
        if(kullaniciTuru == null)
            this.kullaniciTuru = new KullaniciTuru();
        return kullaniciTuru;
    }

    public void setKullaniciTuru(KullaniciTuru kullaniciTuru) {
        this.kullaniciTuru = kullaniciTuru;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kullanici other = (Kullanici) obj;
        return this.id == other.id;
    }

    
    
    
    @Override
    public String toString() {
        return "Kullanici{" + "id=" + id + ", kullaniciTuru=" + kullaniciTuru + ", password=" + password + ", isim=" + isim + ", soyisim=" + soyisim + ", adres=" + adres + '}';
    }

    

}
