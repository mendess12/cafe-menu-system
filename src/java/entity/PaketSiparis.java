/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author 1907h
 */
public class PaketSiparis {
    private Kullanici kullanici;
    private int tutar;
   
    private List<Urun> selectedList;
    
    public PaketSiparis(){
        
        
    }

    public PaketSiparis(Kullanici kullanici, int tutar, List<Urun> selectedList) {
        this.kullanici = kullanici;
        this.tutar = tutar;
        this.selectedList = selectedList;
    }

    

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    
    
    public List<Urun> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Urun> selectedList) {
        this.selectedList = selectedList;
    }

    
    
    
    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    
    
    
    
}
