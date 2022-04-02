/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UrunDAO;
import entity.Urun;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Yusuf
 */
@Named(value = "urunBean")
@SessionScoped
public class UrunBean implements Serializable {

    private UrunDAO dao;
    private List<Urun> list;
    private Urun entity;

    public UrunBean() {

    }

    public void create() {
        this.getDao().createUrun(getEntity());
        this.entity = new Urun();
    }

    public void update() {
        this.getDao().updateUrun(getEntity());
    }

    public void delete() {
        this.getDao().deleteUrun(getEntity());
    }

    public UrunDAO getDao() {
        if (this.dao == null) {
            this.dao = new UrunDAO();
        }
        return dao;
    }

    public void setDao(UrunDAO dao) {
        this.dao = dao;
    }

    public List<Urun> getList() {
        list = getDao().getUrunList();

        return list;
    }

    public void setList(List<Urun> list) {
        this.list = list;
    }

    public Urun getEntity() {
        if (this.entity == null) {
            this.entity = new Urun();
        }
        return entity;
    }

    public void setEntity(Urun entity) {
        this.entity = entity;
    }

}
