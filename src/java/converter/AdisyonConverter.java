/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.AdisyonDAO;
import entity.Adisyon;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Yusuf
 */
@FacesConverter("adisyonConverter")
public class AdisyonConverter implements Converter{
    
    private AdisyonDAO adisyonDao;
    
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        
        int adisyonId = Integer.valueOf(arg2);
        Adisyon adisyon = this.getAdisyonDao().findByID(adisyonId);
        return adisyon;
        
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
            
          Adisyon adisyon = (Adisyon)arg2;
        return String.valueOf(adisyon.getAdisyonId());
    
    }

    public AdisyonDAO getAdisyonDao() {
        if(adisyonDao == null){
            this.adisyonDao = new AdisyonDAO();
        }
        return adisyonDao;
    }

    public void setAdisyonDao(AdisyonDAO adisyonDao) {
        this.adisyonDao = adisyonDao;
    }
    
    
    
}
