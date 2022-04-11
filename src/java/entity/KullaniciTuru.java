/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author 1907h
 */
public class KullaniciTuru {
    
    private short kullaniciId;
    private String kullanici;
    
    public KullaniciTuru(){
        
    }

    public KullaniciTuru(short kullaniciId, String kullanici) {
        this.kullaniciId = kullaniciId;
        this.kullanici = kullanici;
    }
    
    public short getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(short kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.kullaniciId;
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
        final KullaniciTuru other = (KullaniciTuru) obj;
        return this.kullaniciId == other.kullaniciId;
    }
    
    
    
}
