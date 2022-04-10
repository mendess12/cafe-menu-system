/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.MasaDAO;
import entity.Masa;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author Yusuf
 */
@FacesConverter("masaConverter")
public class MasaConverter implements Converter {

    private MasaDAO masaDao;
    
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
    
        int masaNo = Integer.valueOf(arg2);
        Masa masa = this.getMasaDao().findByID(masaNo);
        return masa;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
     
        Masa masa = (Masa)arg2;
        return String.valueOf(masa.getMasaNo());
    }

    public MasaDAO getMasaDao() {
        if(masaDao == null){
            this.masaDao = new MasaDAO();
        }
        return masaDao;
    }

    public void setMasaDao(MasaDAO masaDao) {
        this.masaDao = masaDao;
    }
 
    
}
