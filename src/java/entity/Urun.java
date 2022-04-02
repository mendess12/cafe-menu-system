/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yusuf
 */
public class Urun {
    
    private short urunId ;
    private int kategoriId;
    private String isim;
    private int fiyat;
    private String aciklama;

    public Urun() {
        
    }

    public Urun(short urunId, int kategoriId, String isim, int fiyat, String aciklama) {
        this.urunId = urunId;
        this.kategoriId = kategoriId;
        this.isim = isim;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
    }

   

    public short getUrunId() {
        return urunId;
    }

    public void setUrunId(short urunId) {
        this.urunId = urunId;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "Urun{" + "urunId=" + urunId + ", kategoriId=" + kategoriId + ", isim=" + isim + ", fiyat=" + fiyat + ", aciklama=" + aciklama + '}';
    }
    
    
    
}
