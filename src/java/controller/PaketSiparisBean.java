/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PaketSiparisDAO;
import entity.PaketSiparis;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "paketSiparisBean")
@SessionScoped
public class PaketSiparisBean implements Serializable {

    private PaketSiparis entity;
    private PaketSiparisDAO dao;
    private List<PaketSiparis> list;
    
    public PaketSiparisBean() {
    }
    
    public void create(){
        getDao().createPaketSiparis(getEntity());
    }
    
    public void delete(PaketSiparis paketSiparis){
        getDao().deletePaketSiparis(paketSiparis);
    }
    
    public void update(){
        getDao().updatePaketSiparis(getEntity());
    }

    public PaketSiparis getEntity() {
        if(this.entity == null){
            this.entity = new PaketSiparis();
        }
        return entity;
    }

    public void setEntity(PaketSiparis entity) {
        this.entity = entity;
    }

    public PaketSiparisDAO getDao() {
        if(this.dao == null){
            this.dao = new PaketSiparisDAO();
        }
        return dao;
    }

    public void setDao(PaketSiparisDAO dao) {
        this.dao = dao;
    }

    public List<PaketSiparis> getList() {
        this.list = getDao().getPaketSiparis();
        return list;
    }

    public void setList(List<PaketSiparis> list) {
        this.list = list;
    }
    
    
}
