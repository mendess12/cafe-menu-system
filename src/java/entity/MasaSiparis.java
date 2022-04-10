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
    private Adisyon adisyon;
    private Urun urun;
    private int tutar;
    private boolean siparisDurumu;

    public MasaSiparis() {

    }

    public MasaSiparis(int siparisId, Adisyon adisyon, Urun urun, int tutar, boolean siparisDurumu) {
        this.siparisId = siparisId;
        this.adisyon = adisyon;
        this.urun = urun;
        this.tutar = tutar;
        this.siparisDurumu = siparisDurumu;
    }

    public int getSiparisId() {
        return siparisId;
    }

    public void setSiparisId(int siparisId) {
        this.siparisId = siparisId;
    }

    public Adisyon getAdisyon() {
        return adisyon;
    }

    public void setAdisyon(Adisyon adisyon) {
        this.adisyon = adisyon;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
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
        return "MasaSiparis{" + "siparisId=" + siparisId + ", adisyonId=" + adisyon + ", urunId=" + urun + ", tutar=" + tutar + ", siparisDurumu=" + siparisDurumu + '}';
    }

}
