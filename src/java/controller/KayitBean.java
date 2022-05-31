/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Yusuf
 */
@Named(value = "kayitBean")
@SessionScoped
public class KayitBean implements Serializable {

   
    private Kullanici entity;
    private KullaniciDAO dao;
    
    public KayitBean() {
    }

    public Kullanici getEntity() {
        if(this.entity == null){
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    public KullaniciDAO getDao() {
         if(this.dao == null){
            this.dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }
    
    public String create(){
        getDao().createKullanici(getEntity());
        setEntity(null);
        return "giris";
    }
    
}
