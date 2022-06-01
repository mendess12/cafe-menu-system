/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PaketSiparisDAO;
import entity.Kullanici;
import entity.PaketSiparis;
import entity.Urun;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "paketSiparisBean")
@SessionScoped
public class PaketSiparisBean implements Serializable {

    private PaketSiparisDAO dao;
    private boolean updateState = false;
    private List<PaketSiparis> list;
    private List<Urun> viewData;
    
    public PaketSiparisBean() {
        
    }
    
    public void create(Kullanici kullanici, List<Urun> selectedList){
        getDao().createPaketSiparis(kullanici, selectedList);
    }
    
    public void delete(Kullanici kullanici){
        getDao().deletePaketSiparis(kullanici);
    }
    
    public void update(Kullanici kullanici, List<Urun> selectedList){
        setUpdateState(false);
        delete(kullanici);
        getDao().createPaketSiparis(kullanici, selectedList);
    }
    
    public void updateCase(PaketSiparis ps, KullaniciBean kb, UrunBean ub){
        setUpdateState(true);
        kb.setEntity(ps.getKullanici());
        ub.setList(ps.getSelectedList());
//        getDao().updatePaketSiparis();
    }
    
    
    public void clearForm(){
        setUpdateState(false);
    }
    
    
    public void view(List<Urun> viewData){
        setViewData(viewData);
    }

    public List<Urun> getViewData() {
        if(viewData == null){
            viewData = new ArrayList();
        }
        return viewData;
    }

    public void setViewData(List<Urun> viewData) {
        this.viewData = viewData;
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

    public boolean isUpdateState() {
        return updateState;
    }

    public void setUpdateState(boolean updateState) {
        this.updateState = updateState;
    }

    
    
    
}
