/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import taw.dao.UsuarioFacade;
import taw.entity.Usuario;

/**
 *
 * @author rober
 */
public class Registro extends HttpServlet {

    
    @EJB
    UsuarioFacade usuarioFacade;
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
        response.setContentType("text/html;charset=UTF-8");

        String status = "Usuario creado satisfactoriamente, inicie sesión para continuar.";
        String url = "login.jsp";
        HttpSession sesion = request.getSession();
        Usuario sesionUser = (Usuario) sesion.getAttribute("user");
        if(sesionUser != null && sesionUser.getRol().equals("admin")){
            url = "userList.jsp";
        }
        Usuario user = usuarioFacade.findByEmail((String) request.getParameter("email"));
        
        if(user != null){
            if(sesionUser != null && sesionUser.getRol().equals("admin")){
                user.setCorreo(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                user.setNombre(request.getParameter("name"));
                user.setApellidos(request.getParameter("surname"));
                user.setDomicilio(request.getParameter("address"));
                user.setResidencia(request.getParameter("home"));
                user.setEdad(Integer.parseInt(request.getParameter("age")));
                user.setSexo(request.getParameter("sex"));
                user.setRol(request.getParameter("rol"));
                usuarioFacade.edit(user);
            } else {
                status = "Este correo ya está en uso";
            }
        } else {
            user = new Usuario();
            System.out.println((String) request.getParameter("email"));
            user.setCorreo(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setNombre(request.getParameter("name"));
            user.setApellidos(request.getParameter("surname"));
            user.setDomicilio(request.getParameter("address"));
            user.setResidencia(request.getParameter("home"));
            user.setEdad(Integer.parseInt(request.getParameter("age")));
            user.setSexo(request.getParameter("sex"));
            user.setRol(request.getParameter("rol"));
            usuarioFacade.create(user);
        }
        
        
        request.setAttribute("status", status);
        RequestDispatcher  rd = request.getRequestDispatcher(url);
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
