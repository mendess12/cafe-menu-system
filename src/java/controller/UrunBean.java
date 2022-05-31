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
     
    private int page = 1;
    private int pageSize = 3;
    private int pageCount;
    
    public void next(){
        if(this.getPage() == this.getPageCount())
            this.page = 1;
        else
            this.page++;
    }

    public void previous(){
        if(this.page != 1)
           this.page--;
        
    }    
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        
        this.pageCount = (int) Math.ceil(this.getDao().count()/(double)pageSize);
        
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public UrunBean() {

    }
    
    public List<Urun> getUrunler(){
        this.list = this.getDao().findAll(page, pageSize);
        return list;
    }

    public void create() {
        this.getDao().createUrun(getEntity());
        this.entity = new Urun();
    }

    public void update() {
        this.getDao().updateUrun(getEntity());
        this.entity = new Urun();
    }

    public void delete(Urun urun) {
        this.getDao().deleteUrun(urun);
        
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
        this.list = this.getDao().getUrunList();

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
