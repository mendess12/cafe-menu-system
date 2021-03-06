/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciTuruDAO;
import entity.KullaniciTuru;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "kullaniciTuruBean")
@SessionScoped
public class KullaniciTuruBean implements Serializable {
    
    private KullaniciTuru entity;
    private KullaniciTuruDAO dao;
    private List<KullaniciTuru> list;
    
    public KullaniciTuruBean() {
        
    }
    
    public void create(){
        getDao().createKullaniciTuru(getEntity());
        setEntity(null);
    }
    
    public void clear(){
        setEntity(null);
    }
    
    public void update(){
        getDao().updateKullaniciTuru(getEntity());
        setEntity(null);
    }

    public void delete(KullaniciTuru kullaniciTuru){
        getDao().deleteKullaniciTuru(kullaniciTuru);
    }
    
    public KullaniciTuru getEntity() {
        if(this.entity == null){
            this.entity = new KullaniciTuru();
        }
        return entity;
    }

    public void setEntity(KullaniciTuru entity) {
        this.entity = entity;
    }

    public KullaniciTuruDAO getDao() {
        if(this.dao == null){
            this.dao = new KullaniciTuruDAO();
        }
        return dao;
    }

    public void setDao(KullaniciTuruDAO dao) {
        this.dao = dao;
    }

    public List<KullaniciTuru> getList() {
        this.list = getDao().getKullaniciTuruList();
        return list;
    }

    public void setList(List<KullaniciTuru> list) {
        this.list = list;
    }
    
}
