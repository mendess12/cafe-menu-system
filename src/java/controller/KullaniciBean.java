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
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "kullaniciBean")
@SessionScoped
public class KullaniciBean implements Serializable {

    private KullaniciDAO dao;
    private List<Kullanici> list;
    
    public KullaniciBean(){
        
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

    public List<Kullanici> getList() {
        list = getDao().getKullaniciList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }
    
    
    
}
