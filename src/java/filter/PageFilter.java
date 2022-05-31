/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.Kullanici;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;



/**
 *
 * @author https://github.com/cbozan
 */
@WebFilter("/*")
public class PageFilter implements Filter{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest)sr;
        HttpServletResponse response = (HttpServletResponse)sr1;
        
        String uri = request.getRequestURI();
        
        Kullanici mevcutKullanici = null;
        HttpSession mevcutOturum = request.getSession();
        
        if(mevcutOturum != null){
            mevcutKullanici = (Kullanici)mevcutOturum.getAttribute("currentUser");
        }

        
        if(mevcutKullanici == null){
            if(uri.contains("index") || uri.contains("adisyon") || uri.contains("kategori")
                    || uri.contains("kullanici") || uri.contains("kullaniciTuru") || uri.contains("masa")
                    || uri.contains("masaSiparis") || uri.contains("paketSiparis") ||uri.contains("rezervasyon") 
                    || uri.contains("urunler")){
                

                response.sendRedirect(request.getContextPath() + "/panel/giris.xhtml");
                
            } else{
                fc.doFilter(sr, sr1);
            }
            
        } else{
            if(uri.contains("logout")){
                System.out.println("logout");
                mevcutOturum.invalidate();
                response.sendRedirect(request.getContextPath() + "/panel/giris.xhtml");
            } else{
                fc.doFilter(sr, sr1);
            }
            
        }

        
    }
//
//    HttpServletRequest request = (HttpServletRequest)sr;
//        HttpServletResponse response = (HttpServletResponse) sr1;
//        
//        String uri = request.getRequestURI();
//        
//        HttpSession session = request.getSession();
//        
//        Kullanici kullanici = null;
//        
//        if(session != null){
//           // System.out.println("session != null giris");
//            kullanici = (Kullanici)session.getAttribute("currentUser");
//        }
//        
////        
////        
//        if(kullanici == null){
//            //System.out.println("kullanici == null giris");
//            if(uri.contains("adisyon") || uri.contains("kategori") || uri.contains("kullanici")
//                    || uri.contains("kullaniciTuru") || uri.contains("masa") || uri.contains("masaSiparis")
//                    || uri.contains("paketSiparis") || uri.contains("rezervasyon") || uri.contains("urunler")
//                    || uri.contains("index")){
//               // System.out.println("kullanici == null giris icerisindkei if");
//                response.sendRedirect(request.getContextPath() + "/panel/giris");
//            }else{
//                //System.out.println("kullanici == null giris icerisindkei else");
//                fc.doFilter(sr, sr1);
//            }
//        } else{
//            //System.out.println("kullanici != null (else) giris");
//            if(uri.contains("logout")){
//               // System.out.println("kullanici != null (else) giris icerisndeki if (logout)");
//                session.invalidate();
//                response.sendRedirect(request.getContextPath() + "/panel/giris");
//            } else{
//               //System.out.println("kullanici != null (else) giris icerisndeki else");
//                fc.doFilter(sr, sr1);
//            }   
//        }
//        
//        System.out.println("::" + uri.toString());
    
}
