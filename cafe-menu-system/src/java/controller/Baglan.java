/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import util.DataBase;



/**
 *
 * @author 1907h
 */
@Named("baglan")
@SessionScoped
public class Baglan implements Serializable{

    private String sonuc;
    private DataBase db;

    public Baglan() {

        this.sonuc = "String";
        //sonuc += getConnect();
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

   
    
}
