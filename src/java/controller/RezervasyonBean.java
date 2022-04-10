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
 * @author Safa
 */
@Named(value = "rezervasyonBean")
@SessionScoped
public class RezervasyonBean implements Serializable {

    private RezervasyonDAO dao;
    private List<Rezervasyon> list;
    private Rezervasyon entity;

    public RezervasyonBean() {

    }

    public Rezervasyon getEntity() {
        if (this.entity == null) {
            this.entity = new Rezervasyon();
        }
        return entity;
    }

    public void setEntity(Rezervasyon entity) {
        this.entity = entity;
    }

    public void create() {
        this.getDao().createRezervasyon(getEntity());
        this.entity = new Rezervasyon();
    }

    public void update() {
        this.getDao().updateRezervasyon(entity);
        entity = new Rezervasyon();
    }

    public void delete(Rezervasyon entity) {
        this.getDao().deleteRezervasyon(entity);
        entity = new Rezervasyon();

    }

    public RezervasyonDAO getDao() {

        if (dao == null) {
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
