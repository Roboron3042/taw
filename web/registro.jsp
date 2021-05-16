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
            <input type="text" name="name" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d1]+" required/><br><br>
            Apellidos:<br>
            <input type="text" name="surname" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d1]+" required/><br><br>
            Domicilio:<br>
            <input type="text" name="address" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d10-9]+" required/><br><br>
            Residencia:<br>
            <input type="text" name="home" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d10-9]+" required/><br><br>
            Edad:<br>
            <input type="number" name="age" value="20" pattern="[0-9]" required/><br><br>
            Sexo:<br>
            <input type="text" name="sex" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d1]+" required/><br><br>
            Rol:<br>
            <select name="rol">
                <option>user</option>
                <%
                Usuario usuario = (Usuario) session.getAttribute("user");
                if(usuario != null){
                    if(usuario.getRol().equals("admin")){
                %>
                <option>admin</option>
                <option>creator</option>
                <option>teleoperator</option>
                <option>analyst</option>
                <%
                    } else {
                        response.sendRedirect("userHome.jsp");
                    }
                }
                %>
            </select><br><br>
            <%
            String status = (String) request.getAttribute("status");
            if (status == null) {
                status = "Rellena todos los campos para continuar";
            } 
            %>
            <%=status%><br><br>
            <input type="submit" value="Registrar usuario"/>
        </form>
    </body>
</html>
