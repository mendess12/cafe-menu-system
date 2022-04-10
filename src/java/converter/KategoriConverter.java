/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Yusuf
 */
@FacesConverter("kategoriConverter")
public class KategoriConverter implements Converter {

    private KategoriDAO kategoriDao;
    
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        
        int kategoriId = Integer.valueOf(arg2);
        Kategori kategori = this.getKategoriDao().findByID(kategoriId);
        return kategori;
        
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
  
        Kategori kategori = (Kategori)arg2;
        return String.valueOf(kategori.getKategoriId());
    }

    public KategoriDAO getKategoriDao() {
        if(kategoriDao == null){
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }
    
    
}
