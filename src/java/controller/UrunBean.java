/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UrunDAO;
import entity.Urun;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Yusuf
 */
@Named(value = "urunBean")
@SessionScoped
public class UrunBean implements Serializable {
    final String absolutePath = "C:/Users/seyfettin/Desktop/internet_programciligi/cafe-menu-system/web/resources/images/";

    private UrunDAO dao;
    private List<Urun> list;
    private Urun entity; 
    private Part file;
    private int page = 1;
    private int pageSize = 6;
    private int pageCount;
    
    private List<Urun> selectedList;
    
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

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Urun> getSelectedList() {
        if(selectedList == null){
            selectedList = new ArrayList<>();
        }
        return selectedList;
    }

    public void setSelectedList(List<Urun> selectedList) {
        this.selectedList = selectedList;
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
        if(file != null && file.getSize() > 0){
            System.out.println("---109Dao");
            try{
                
            System.out.println("---112Dao");
                InputStream input = getFile().getInputStream();
                String temp = absolutePath+file.getSubmittedFileName();
                File f = new File(temp);
                Files.copy(input, f.toPath());
                this.entity.setImgUrl(file.getSubmittedFileName());
                
            System.out.println("---119Dao");
            } catch(Exception e){
                this.entity.setImgUrl("meyve_suyu.jpg"); 
                System.out.println(e.getMessage());
            }
        } else{
          this.entity.setImgUrl("meyve_suyu.jpg");  
        }
        
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
