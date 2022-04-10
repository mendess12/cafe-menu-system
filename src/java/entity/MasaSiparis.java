/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Yusuf
 */
public class MasaSiparis {

    private int siparisId;
    private int adisyonId;
    private int urunId;
    private int tutar;
    private boolean siparisDurumu;

    public MasaSiparis() {

    }

    public MasaSiparis(int siparisId, int adisyonId, int urunId, int tutar, boolean siparisDurumu) {
        this.siparisId = siparisId;
        this.adisyonId = adisyonId;
        this.urunId = urunId;
        this.tutar = tutar;
        this.siparisDurumu = siparisDurumu;
    }

    public int getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    public int getAdisyonId() {
        return adisyonId;
    }

    public void setAdisyonId(int adisyonId) {
        this.adisyonId = adisyonId;
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

    public boolean isSiparisDurumu() {
        return siparisDurumu;
    }

    public void setSiparisDurumu(boolean siparisDurumu) {
        this.siparisDurumu = siparisDurumu;
    }

    @Override
    public String toString() {
        return "MasaSiparis{" + "siparisId=" + siparisId + ", adisyonId=" + adisyonId + ", urunId=" + urunId + ", tutar=" + tutar + ", siparisDurumu=" + siparisDurumu + '}';
    }

}
