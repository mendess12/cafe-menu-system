/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.RezervasyonDAO;
import entity.Rezervasyon;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "rezervasyonBean")
@SessionScoped
public class RezervasyonBean implements Serializable {
    private Rezervasyon entity;
    private RezervasyonDAO dao;
    private List<Rezervasyon> list;
    
    public RezervasyonBean(){
        
    }
    public void create(){
        getDao().createRezervasyon(getEntity());
    }
    public Rezervasyon getEntity() {
        if(this.entity == null){
            this.entity = new Rezervasyon();
        }
        return entity;
    }

    public void setEntity(Rezervasyon entity) {
        this.entity = entity;
    }

    public RezervasyonDAO getDao() {
        if(this.dao == null){
            this.dao = new RezervasyonDAO();
        }
        return dao;
    }

    public void setDao(RezervasyonDAO dao) {
        this.dao = dao;
    }

    public List<Rezervasyon> getList() {
        list = getDao().getRezervasyonList();
        return list;
    }

    public void setList(List<Rezervasyon> list) {
        this.list = list;
    }
    
    
    
}
