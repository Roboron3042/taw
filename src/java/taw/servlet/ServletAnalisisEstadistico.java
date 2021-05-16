/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taw.dao.EventosFacade;
import taw.dao.UsuarioFacade;
import taw.entity.Eventos;
import taw.entity.Usuario;

/**
 *
 * @author Francisco Cuadrado
 */
@WebServlet(name = "ServletAnalisisEstadistico", urlPatterns = {"/ServletAnalisisEstadistico"})
public class ServletAnalisisEstadistico extends HttpServlet {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    @EJB
    private EventosFacade eventosFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BigDecimal n;
        List<Usuario> listaUsuario;
        List<Eventos> listaEventos;
        String strEdadInicio = request.getParameter("edadInicio");
        Integer edadInicio = null;
        if(strEdadInicio.length() > 0){
           edadInicio  = Integer.parseInt(strEdadInicio);
        }
        String strEdadFin = request.getParameter("edadFin");
        Integer edadFin = null;
        if(strEdadFin.length() > 0){
           edadFin  = Integer.parseInt(strEdadFin);
        }
        
        
        String sexo = request.getParameter("sexo");
        if(sexo.length() == 0){
            sexo = null;
        }
        
        
        String strYear = request.getParameter("year");
        Integer year = null;
        if(strYear.length() == 4){
           year  = Integer.parseInt(strYear);
        }
        
        String strCosteInicio = request.getParameter("costeInicio");
        Double costeInicio = null;
        if(strCosteInicio.length() > 0){
           costeInicio  = Double.parseDouble(strCosteInicio);
        }
        
        String strCosteFin = request.getParameter("costeFin");
        Double costeFin = null;
        if(strCosteFin.length() > 0){
           costeFin  = Double.parseDouble(strCosteFin);
        }
        
        //USUARIO
        
        if ((edadInicio != null  && edadFin != null)  || sexo != null ) {// Estoy aplicando filtro
            listaUsuario = this.usuarioFacade.findByEdadOrResidenciaOrSexo(edadInicio, edadFin, sexo);
            
        }
        else {  // Todos los filtros de usuario estan en blanco
            listaUsuario = this.usuarioFacade.findAllUser();
            
        }
       
        
        //EVENTOS
        if( year != null  || (costeInicio != null  && costeFin != null) ) {// Estoy aplicando filtro
            listaEventos = this.eventosFacade.findByFechaOrCoste(year, costeInicio, costeFin);
        }
        else {  // Todos los filtros de eventos estan en blanco
            listaEventos = this.eventosFacade.findAll();
            
        }
       
        
        
        List<Usuario> listaUsuarioTotal = this.usuarioFacade.findAllUser();
        List<Eventos> listaEventosTotal = this.eventosFacade.findAll();
        
        
        Double porcentajeUsuarios = new Double(listaUsuario.size())/new Double(listaUsuarioTotal.size());
        porcentajeUsuarios = porcentajeUsuarios * 100;
        
        n=  BigDecimal.valueOf(porcentajeUsuarios);
        n = n.setScale(2, RoundingMode.HALF_UP);
        porcentajeUsuarios = n.doubleValue();
        
        Double mediaEdad;
        mediaEdad = 0.0;
        if(!listaUsuario.isEmpty()){
            for(Usuario u: listaUsuario){
                mediaEdad = u.getEdad() + mediaEdad;
            }
            mediaEdad = mediaEdad / listaUsuario.size();
            n=  BigDecimal.valueOf(mediaEdad);
            n = n.setScale(2, RoundingMode.HALF_UP);
            mediaEdad = n.doubleValue();
        }
        
        Double porcentajeEventos = new Double(listaEventos.size())/new Double(listaEventosTotal.size());
        porcentajeEventos = porcentajeEventos * 100;
        
        n=  BigDecimal.valueOf(porcentajeEventos);
        n = n.setScale(2, RoundingMode.HALF_UP);
        porcentajeEventos = n.doubleValue();
        
        
       Double mediaPrecio;
        mediaPrecio = 0.0;
        if(!listaEventos.isEmpty()){
            for(Eventos e : listaEventos){
                mediaPrecio = e.getCoste() + mediaPrecio;
            }
            mediaPrecio = mediaPrecio / listaEventos.size();
            n=  BigDecimal.valueOf(mediaPrecio);
            n = n.setScale(2, RoundingMode.HALF_UP);
            mediaPrecio = n.doubleValue();
        } 
        
        
        request.setAttribute("porcentajeUsuarios", porcentajeUsuarios);
        request.setAttribute("mediaEdad", mediaEdad);
        
        request.setAttribute("porcentajeEventos", porcentajeEventos);
        request.setAttribute("mediaPrecio", mediaPrecio);   
        
        
        RequestDispatcher rd = request.getRequestDispatcher("analisisEstadistico.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
