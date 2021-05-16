<%-- 
    Document   : userList
    Created on : 16-may-2021, 13:48:27
    Author     : rober
--%>

<%@page import="java.util.List"%>
<%@page import="taw.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de usuarios</title>
    </head>
    <%
    Usuario sessionUser = (Usuario) session.getAttribute("user");
        if(sessionUser != null){
            if(!sessionUser.getRol().equals("admin")){
                response.sendRedirect("userHome.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    List<Usuario> userList = (List)request.getAttribute("userList");
    %>
    <body>
        <h1>Listado de usuarios</h1>
        <ul><li><a href="registro.jsp">Crear nuevo usuario</a></li></ul>
        <%
        if (userList == null || userList.isEmpty()) {
        %>          
            <h2>Ningún usuario ha sido creado o encontrado</h2>
         <%
        } else {
        %>
        <form action="UserListFilter" method="POST">
            Filtrar por: 
            <select name="filterType">
                <option>Correo</option>
                <option>Nombre</option>
                <option>Apellidos</option>
                <option>Domicilio</option>
                <option>Residencia</option>
                <option>Edad</option>
                <option>Sexo</option>
                <option>Rol</option>
                <option>Password</option>
            </select>
            <input type="text" name="filterValue"/>
            <input type="submit" value="Filtrar" />
        </form><br>
        <table border="1" style="width:100%">
        <tr>
            <th>Correo</th>
            <th>Contraseña</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Domicilio</th>
            <th>Residencia</th>
            <th>Edad</th>
            <th>Sexo</th>
            <th>Rol</th>
            <th></th>
            <th></th>
        </tr>
            <%    
            for (Usuario user : userList) {
            %>
        <tr>
            <td><%= user.getCorreo() %></td>
            <td><%= user.getPassword() %></td>
            <td><%= user.getNombre()  %></td>
            <td><%= user.getApellidos() %></td>
            <td><%= user.getDomicilio() %></td>
            <td><%= user.getResidencia() %></td>
            <td><%= user.getEdad() %></td>
            <td><%= user.getSexo() %></td>
            <td><%= user.getRol() %></td>
            <td><a href="UserEdit?email=<%= user.getCorreo() %>">Editar</a></td>
            <td><a href="UserDelete?email=<%= user.getCorreo() %>" onclick="return confirm('¿Estás seguro? Esta acción no se puede deshacer');">Eliminar</a></td>            
            <%
            }
            %>
        </table>
        <%
        }
        %>
        <ul>
            <li><a href="adminHome.jsp">Volver al menú de Administración</a> </li>
            <li><a href="Logout">Cerrar sesión</a></li>
            <li><a href="#top">Volver arriba</a></li>
        </ul>
    </body>
</html>