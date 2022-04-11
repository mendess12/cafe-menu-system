/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KullaniciDAO;
import entity.Kullanici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 1907h
 */
@FacesConverter("kullaniciConverter")
public class KullaniciConverter implements Converter{

    private KullaniciDAO kullaniciDAO;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        return getKullaniciDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kullanici kullanici = (Kullanici)t;
        return String.valueOf(kullanici.getId());
    }

    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO == null)
            this.kullaniciDAO = new KullaniciDAO();
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }
    
    
    
}
