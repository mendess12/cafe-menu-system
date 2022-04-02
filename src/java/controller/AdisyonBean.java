/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.AdisyonDAO;
import entity.Adisyon;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.jms.Connection;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yusuf
 */
@Named(value = "adisyonBean")
@SessionScoped
public class AdisyonBean implements Serializable {

    private AdisyonDAO dao;
    private List<Adisyon> list;
    private Adisyon entity;

    public AdisyonBean() {

    }

    public void create() {
        this.getDao().createAdisyon(getEntity());
        this.entity = new Adisyon();
    }

    public void update() {
        this.getDao().updateAdisyon(getEntity());
    }

    public void delete() {
        this.getDao().deleteAdisyon(getEntity());
    }

    public AdisyonDAO getDao() {
        if (this.dao == null) {
            this.dao = new AdisyonDAO();
        }
        return dao;
    }

    public void setDao(AdisyonDAO dao) {
        this.dao = dao;
    }

    public List<Adisyon> getList() {
        list = getDao().getAdisyonList();
        return list;
    }

    public void setList(List<Adisyon> list) {
        this.list = list;
    }

    public Adisyon getEntity() {
        if (this.entity == null) {
            this.entity = new Adisyon();
        }
        return entity;
    }

    public void setEntity(Adisyon entity) {
        this.entity = entity;
    }

}
