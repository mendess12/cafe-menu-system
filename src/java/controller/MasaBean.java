/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MasaDAO;
import entity.Masa;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Safa
 */
@Named(value = "masaBean")
@SessionScoped
public class MasaBean implements Serializable {
    
    private MasaDAO dao;
    private List<Masa> list;
    private Masa entity;
    
    public MasaBean() {
        
    }
    
    public Masa getEntity() {
        if (this.entity == null) {
            this.entity = new Masa();
        }
        return entity;
    }
    
    public void setEntity(Masa entity) {
        this.entity = entity;
    }
    
    public void create() {
        this.getDao().createMasa(getEntity());
        this.entity = new Masa();
    }
    
    public void update() {
        this.getDao().updateMasa(entity);
        entity = new Masa();
    }
    
    public void delete(Masa entity) {
        this.getDao().deleteMasa(entity);
        entity = new Masa();

    }
    
    public MasaDAO getDao() {
        
        if (dao == null) {
            this.dao = new MasaDAO();
        }
        return dao;
    }
    
    public void setDao(MasaDAO dao) {
        this.dao = dao;
    }
    
    public List<Masa> getList() {
        list = getDao().getMasaList();
        return list;
    }
    
    public void setList(List<Masa> list) {
        this.list = list;
    }
    
}
