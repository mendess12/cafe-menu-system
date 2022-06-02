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

    private int urunId;
    private Kategori kategori;
    private String isim;
    private int fiyat;
    private String aciklama,imgUrl;

    public Urun() {

    }

    public Urun(int urunId, Kategori kategori, String isim, int fiyat, String aciklama,String imgUrl) {
        this.urunId = urunId;
        this.kategori = kategori;
        this.isim = isim;
        this.fiyat = fiyat;
        this.aciklama = aciklama;
        this.imgUrl = imgUrl;
    }

   

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getFiyat() {
        if(fiyat == 0){
            return "";
        }
        return String.valueOf(fiyat);
    }

    public void setFiyat(String fiyat) {
        this.fiyat = Integer.valueOf(fiyat);
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Urun{" + "urunId=" + urunId + ", kategori=" + kategori + ", isim=" + isim + ", fiyat=" + fiyat + ", aciklama=" + aciklama + ", imgUrl=" + imgUrl + '}';
    }
    
    

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.urunId;
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
        final Urun other = (Urun) obj;
        return this.urunId == other.urunId;
    }

   
    

}
