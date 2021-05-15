<%-- 
    Document   : login
    Created on : 11-may-2021, 18:16:28
    Author     : rober
--%>

<%@page import="taw.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesión</title>
    </head>
    <%
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario != null){
            if(usuario.getRol().equals("admin")){
                response.sendRedirect("AdminHome");
            } else {
                response.sendRedirect("UserHome");
            }
            return;
        }
        
        String status = (String) request.getAttribute("status");
        if (status == null) {
            status = "Introduce tu usuario y contraseña para continuar";
        } 

    %>
    <body>
        <h1>Inicia sesión en la plataforma</h1>
        
        <form method="POST" action="Login">
            Correo:<br>
            <input type="text" name="email" required/><br><br>
            Contraseña: <br>
            <input type="text" name="password" required/><br><br>
            <input type="submit" value="Iniciar sesión"/><br><br>
        </form>
        
        <%=status%><br><br>
        
        <a href="registro.jsp">¿No tienes cuenta? Regístrate aquí.</a>
        
        
    </body>
</html>
