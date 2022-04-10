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

    private int adisyonId;
    private Masa masa;
    private int tutar;

    public Adisyon() {

    }

    public Adisyon(int adisyonId, Masa masa, int tutar) {
        this.adisyonId = adisyonId;
        this.masa = masa;
        this.tutar = tutar;
    }

    public int getAdisyonId() {
        return adisyonId;
    }

    public void setAdisyonId(int adisyonId) {
        this.adisyonId = adisyonId;
    }

    public Masa getMasa() {
        return masa;
    }

    public void setMasa(Masa masa) {
        this.masa = masa;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Adisyon{" + "adisyonId=" + adisyonId + ", masaNo=" + masa + ", tutar=" + tutar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.adisyonId;
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
        final Adisyon other = (Adisyon) obj;
        return this.adisyonId == other.adisyonId;
    }

    
}
