<%-- 
    Document   : adminHome
    Created on : 16-may-2021, 13:35:25
    Author     : rober
--%>

<%@page import="taw.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página del Administrador</title>
    </head>
    <%
    Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario != null){
            if(!usuario.getRol().equals("admin")){
                response.sendRedirect("userHome.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
    <body>
        <h1>Bienvenido, Administrador</h1>
        <ul>
            <li><a href="UserList">Acceder al listado de usuarios</a></li>
            <li><a href="EventList">Acceder al listado de eventos</a></li>
        </ul>
    </body>
</html>
