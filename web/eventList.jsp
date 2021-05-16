<%-- 
    Document   : eventList
    Created on : 16-may-2021, 17:54:02
    Author     : rober
--%>

<%@page import="taw.entity.Eventos"%>
<%@page import="java.util.List"%>
<%@page import="taw.entity.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de eventos</title>
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
    List<Eventos> eventList = (List)request.getAttribute("eventList");
    %>
    <body>
        <h1>Listado de eventos</h1>
        <ul><li><a href="EventCreate">Crear nuevo usuario</a> (No disponible actualmente)</li></ul>
        <%
        if (eventList == null || eventList.isEmpty()) {
        %>          
            <h2>Ningún evento ha sido creado todavía</h2>
         <%
        } else {
        %>
        <table border="1" style="width:100%">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Descripción</th>
            <th>Fecha</th>
            <th>Fecha Límite</th>
            <th>Coste</th>
            <th>Aforo</th>
            <th>Entradas máximas</th>
            <th>Asientos</th>
            <th></th>
            <th></th>
        </tr>
            <%    
            for (Eventos event : eventList) {
            %>
        <tr>
            <td><%= event.getIdeventos() %></td>
            <td><%= event.getTitulo() %></td>
            <td><%= event.getDescripcion()  %></td>
            <td><%= event.getFecha() %></td>
            <td><%= event.getFechalim() %></td>
            <td><%= event.getCoste() %></td>
            <td><%= event.getAforo() %></td>
            <td><%= event.getNmaxentradas() %></td>
            <td><%= event.getAsientos() %></td>
            <td><a href="EventEdit?id=<%= event.getIdeventos() %>">Editar</a> (No disponible actualmente)</td>
            <td><a href="EventDelete?id=<%= event.getIdeventos() %>" onclick="return confirm('¿Estás seguro? Esta acción no se puede deshacer');">Eliminar</a></td>            
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
