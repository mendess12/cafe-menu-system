/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.util.Date;

/**
 *
 * @author hp
 */
public class Rezervasyon {
    private short rezervasyonId;
    private int masaNo;
    private Date tarih;
    private String isim;
    private String soyisim;
    private String telNo;
    
    public Rezervasyon(){
        
    }

    public Rezervasyon(short rezervasyonId,int masaNo, Date tarih, String isim, String soyisim, String telNo) {
        this.rezervasyonId=rezervasyonId;
        this.masaNo = masaNo;
        this.tarih = tarih;
        this.isim = isim;
        this.soyisim = soyisim;
        this.telNo = telNo;
    }

    public short getRezervasyonId() {
        return rezervasyonId;
    }

    public void setRezervasyonId(short rezervasyonId) {
        this.rezervasyonId = rezervasyonId;
    }

    public int getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(int masaNo) {
        this.masaNo = masaNo;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
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

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" + "rezervasyonId=" + rezervasyonId + ", masaNo=" + masaNo + ", tarih=" + tarih + ", isim=" + isim + ", soyisim=" + soyisim + ", telNo=" + telNo + '}';
    }
    
}
