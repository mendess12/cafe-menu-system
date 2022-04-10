/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Safa
 */
public class Masa {

    private int masaNo;
    private boolean musaitMi;
    private int kacKisilik;

    public Masa() {

    }

    

    public Masa(int masaNo, boolean musaitMi,  int kacKisilik) {
        this.masaNo = masaNo;
        this.musaitMi = musaitMi;
        this.kacKisilik = kacKisilik;

    }

    @Override
    public String toString() {
        return "Masa{" + "masaNo=" + masaNo + ", musaitMi=" + musaitMi + ", kacKisilik=" + kacKisilik + '}';
    }

    public int getMasaNo() {
        return masaNo;
    }

    public void setMasaNo(int masaNo) {
        this.masaNo = masaNo;
    }

    public boolean isMusaitMi() {
        return musaitMi;
    }

    public void setMusaitMi(boolean musaitMi) {
        this.musaitMi = musaitMi;
    }

    public int getKacKisilik() {
        return kacKisilik;
    }

    public void setKacKisilik(int kacKisilik) {
        this.kacKisilik = kacKisilik;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.masaNo;
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
        final Masa other = (Masa) obj;
        return this.masaNo == other.masaNo;
    }
}
