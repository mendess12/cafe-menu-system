/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author https://github.com/cbozan
 */
@Named(value = "loginKullaniciBean")
@SessionScoped
public class LoginKullaniciBean implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    
    public LoginKullaniciBean() {
    }
    
    public String login(){
        
        if(getDao().verifyLogin(getEntity())){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", getEntity());
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre yanlış"));
        }
        
        return "/panel/giris?faces-redirect=true";
        
    }

    public KullaniciDAO getDao() {
        if(dao == null){
            this.dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }

    public Kullanici getEntity() {
        if(entity == null){
            entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }
    
}
