<%-- 
    Document   : regristro
    Created on : 11-may-2021, 18:34:14
    Author     : rober
--%>

<%@page import="taw.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form method="post" action="Registro">
           <h1>Formulario de Registro</h1>
           
            Correo:<br>
            <input type="text" name="email" maxlength ="50" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/><br><br>
            Contraseña:<br>
            <input type="text" name="password" minlength="8" maxlength ="50" required/><br><br>
            Nombre:<br>
            <input type="text" name="name" maxlength ="50" pattern="[A-Za-z]+" required/><br><br>
            Apellidos:<br>
            <input type="text" name="surname" maxlength ="50" pattern="[A-Za-z]+" required/><br><br>
            Domicilio:<br>
            <input type="text" name="address" maxlength ="50" pattern="[A-Za-z0-9]+" required/><br><br>
            Residencia:<br>
            <input type="text" name="home" maxlength ="50" pattern="[A-Za-z0-9]+" required/><br><br>
            Edad:<br>
            <input type="number" name="age" value="20" pattern="[0-9]" required/><br><br>
            Sexo:<br>
            <input type="text" name="sex" maxlength ="50" pattern="[A-Za-z]+" required/><br><br>
            <%
            Usuario usuario = (Usuario) session.getAttribute("user");
            if(usuario != null){
                if(usuario.getRol().equals("admin")){
            %>
            Rol:<br>
            <select name="rol">
                <option>user</option>
                <option>admin</option>
                <option>creator</option>
                <option>teleoperator</option>
                <option>analyst</option>
            </select><br><br>
            <%
                } else {
                response.sendRedirect("UserHome");
                }
            } else {
                request.setAttribute("rol", "user");
            }
            %>
            <input type="submit" value="Registrar"/>
        </form>
    </body>
</html>
