/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Safa
 */
public class Kategori {

    private int kategoriId;
    private String tur;

    public Kategori() {

    }

    public Kategori(int kategoriId, String tur) {
        this.kategoriId = kategoriId;
        this.tur = tur;

    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    @Override
    public String toString() {
        return "Kategori{" + "kategoriId=" + kategoriId + ", tur=" + tur + '}';
    }
    
}
