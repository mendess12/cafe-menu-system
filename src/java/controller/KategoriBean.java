/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Safa
 */
@Named(value = "kategoriBean")
@SessionScoped
public class KategoriBean implements Serializable {
    
    private KategoriDAO dao;
    private List<Kategori> list;
    private Kategori entity;
    
    public KategoriBean() {
        
    }
    
    public Kategori getEntity() {
        if (this.entity == null) {
            this.entity = new Kategori();
        }
        return entity;
    }
    
    public void setEntity(Kategori entity) {
        this.entity = entity;
    }
    
    public void create() {
        this.getDao().createKategori(getEntity());
        this.entity = new Kategori();
    }
    
    public void update() {
        this.getDao().updateKategori(getEntity());
    }
    
    public void delete() {
        this.getDao().deleteKategori(getEntity());
    }
    
    public KategoriDAO getDao() {
        
        if (dao == null) {
            this.dao = new KategoriDAO();
        }
        return dao;
    }
    
    public void setDao(KategoriDAO dao) {
        this.dao = dao;
    }
    
    public List<Kategori> getList() {
        list = getDao().getKategoriList();
        return list;
    }
    
    public void setList(List<Kategori> list) {
        this.list = list;
    }
    
}
