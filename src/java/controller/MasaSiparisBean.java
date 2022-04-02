/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MasaSiparisDAO;
import entity.MasaSiparis;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yusuf
 */
@Named(value = "masaSiparisBean")
@SessionScoped
public class MasaSiparisBean implements Serializable {

    private MasaSiparisDAO dao;
    private List<MasaSiparis> list;
    private MasaSiparis entity;

    public MasaSiparisBean() {

    }

    public void create() {
        this.getDao().createMasaSiparis(getEntity());
        this.entity = new MasaSiparis();
    }

    public void update() {
        this.getDao().updateMasaSiparis(getEntity());
    }

    public void delete() {
        this.getDao().deleteMasaSiparis(getEntity());
    }

    public MasaSiparis getEntity() {
        if (this.entity == null) {
            this.entity = new MasaSiparis();
        }
        return entity;
    }

    public void setEntity(MasaSiparis entity) {
        this.entity = entity;
    }

    public MasaSiparisDAO getDao() {

        if (this.dao == null) {
            this.dao = new MasaSiparisDAO();
        }
        return dao;
    }

    public void setDao(MasaSiparisDAO dao) {
        this.dao = dao;
    }

    public List<MasaSiparis> getList() {
        list = getDao().getMasaSiparisList();
        return list;
    }

    public void setList(List<MasaSiparis> list) {
        this.list = list;
    }

}
