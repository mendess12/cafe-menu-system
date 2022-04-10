/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yusuf
 */
public class Adisyon {

    private short adisyonId;
    private int masaNo;
    private int tutar;

    public Adisyon() {

    }

    public Adisyon(short adisyonId, int masaNo, int tutar) {
        this.adisyonId = adisyonId;
        this.masaNo = masaNo;
        this.tutar = tutar;
    }

    public short getAdisyonId() {
        return adisyonId;
    }

    public void setAdisyonId(short adisyonId) {
        this.adisyonId = adisyonId;
    }

    public int getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(int masaNo) {
        this.masaNo = masaNo;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Adisyon{" + "adisyonId=" + adisyonId + ", masaNo=" + masaNo + ", tutar=" + tutar + '}';
    }

}
