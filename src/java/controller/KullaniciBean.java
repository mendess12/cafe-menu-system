package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 1907h
 */
@Named(value = "kullaniciBean")
@SessionScoped
public class KullaniciBean implements Serializable {

    private Kullanici entity;
    private KullaniciDAO dao;
    private List<Kullanici> list;
     
    public KullaniciBean(){
        
    }
    
    public boolean validateName(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Name Alanı Boş Olamaz!"));
        }
        return true;
    }
    public boolean validateSurname(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Surname Alanı Boş Olamaz!"));
        }
        return true;
    }
    
    public boolean validateAddress(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Adres Alanı Boş Olamaz!"));
        }
        return true;
    }
    
    public boolean validatePassword(FacesContext context,UIComponent cmp,Object value) throws ValidatorException{
        String val = (String) value;
        
        if(val.isEmpty()){
            throw new ValidatorException(new FacesMessage("Password Alanı Boş Olamaz!"));
        }
        return true;
    }

    public void create(){
        getDao().createKullanici(getEntity());
        setEntity(null);
    }
    
    public void delete(Kullanici kullanici){
        getDao().deleteKullanici(kullanici);
    }
    
    
    public void update(){
        getDao().updateKullanici(getEntity());
        setEntity(null);
    }
    
    public void clear(){
        setEntity(null);
    }
    
    public Kullanici getEntity() {
        if(this.entity == null){
            this.entity = new Kullanici();
        }
        return entity;
    }

    public void setEntity(Kullanici entity) {
        this.entity = entity;
    }

    
    
    public KullaniciDAO getDao() {
        if(this.dao == null){
            this.dao = new KullaniciDAO();
        }
        return dao;
    }

    public void setDao(KullaniciDAO dao) {
        this.dao = dao;
    }

    public List<Kullanici> getList() {
        list = getDao().getKullaniciList();
        return list;
    }

    public void setList(List<Kullanici> list) {
        this.list = list;
    }
    
    
    
}