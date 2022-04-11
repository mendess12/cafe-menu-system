/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KullaniciTuruDAO;
import entity.KullaniciTuru;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author 1907h
 */
@FacesConverter("kullaniciTuruConverter")
public class KullaniciTuruConverter implements Converter{

    private KullaniciTuruDAO kullaniciTuruDAO;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        short id = Short.valueOf(string);
        return getKullaniciTuruDAO().findById(id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        KullaniciTuru kullaniciTuru = (KullaniciTuru)t;
        return String.valueOf(kullaniciTuru.getKullaniciId());
    }

    public KullaniciTuruDAO getKullaniciTuruDAO() {
        if(kullaniciTuruDAO == null)
            kullaniciTuruDAO = new KullaniciTuruDAO();
        return kullaniciTuruDAO;
    }

    public void setKullaniciTuruDAO(KullaniciTuruDAO kullaniciTuruDAO) {
        this.kullaniciTuruDAO = kullaniciTuruDAO;
    }
    
    
    
}
