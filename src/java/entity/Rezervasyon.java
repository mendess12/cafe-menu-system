/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Timestamp;

/**
 *
 * @author hp
 */
public class Rezervasyon {
    private short rezervasyonId;
    private int masaNo;
    private Timestamp tarih;
    private String isim;
    private String soyisim;
    private String telNo;
    
    public Rezervasyon(){
        
    }

    public Rezervasyon(int masaNo, Timestamp tarih, String isim, String soyisim, String telNo) {
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

    public Timestamp getTarih() {
        return tarih;
    }

    public void setTarih(Timestamp tarih) {
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
    
}
