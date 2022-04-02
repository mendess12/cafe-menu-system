/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author 1907h
 */
public class PaketSiparis {
    private short siparisNo;
    private int kullaniciId;
    private int urunId;
    private int tutar;
    
    public PaketSiparis(){
        
        
    }

    public PaketSiparis(short siparisNo, int kullaniciId, int urunId, int tutar) {
        this.siparisNo = siparisNo;
        this.kullaniciId = kullaniciId;
        this.urunId = urunId;
        this.tutar = tutar;
    }
    
    public short getSiparisNo() {
        return siparisNo;
    }

    public void setSiparisNo(short siparisNo) {
        this.siparisNo = siparisNo;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }
    
    
    
}
