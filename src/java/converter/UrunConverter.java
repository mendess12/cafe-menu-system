/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.UrunDAO;
import entity.Urun;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Yusuf
 */
@FacesConverter("urunConverter")
public class UrunConverter implements Converter{
    
    private UrunDAO urunDao;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
       
         int urunId = Integer.valueOf(arg2);
        Urun urun = this.getUrunDao().findByID(urunId);
        return urun;
    
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
   
         
        
         Urun urun = (Urun)arg2;
        return String.valueOf(urun.getUrunId());
    
    }

    public UrunDAO getUrunDao() {
        if(urunDao == null){
            this.urunDao = new UrunDAO();
        }
        return urunDao;
    }

    public void setUrunDao(UrunDAO urunDao) {
        this.urunDao = urunDao;
    }
    
    
    
}
