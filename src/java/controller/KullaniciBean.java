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

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;
    
    public KullaniciBean(){
        
    }

    public void create(){
        getDao().createKullanici(getEntity());
    }
    
    public void delete(){
        getDao().deleteKullanici(getEntity());
    }
    
    public void update(){
        getDao().updateKullanici(getEntity());
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

    public List<Kullanici> getList() {
        list = getDao().getKullaniciList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }
    
    
    
}