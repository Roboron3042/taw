<%-- 
    Document   : analisisEstadistico
    Created on : 11-may-2021, 18:40:30
    Author     : Francisco Cuadrado
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        
        Double porcentajeUsuarios = (Double)request.getAttribute("porcentajeUsuarios");
        Double mediaEdad = (Double)request.getAttribute("mediaEdad");
        
        Double porcentajeEventos = (Double)request.getAttribute("porcentajeEventos");
        Double mediaPrecio = (Double)request.getAttribute("mediaPrecio");      

        
    %>
    
    <body>
        <h1>Datos del analisis:</h1>
        <table border="1">
            <caption>USUARIOS</caption>
            <tr>
                <th>Porcentaje sobre el total de usuarios:</th>
                <th><%=porcentajeUsuarios%>%</th>
            </tr>
            <tr>
                <th>Edad media de los usuarios:</th>
                <th><%=mediaEdad%> años</th>
            </tr>
        </table>
          
        <table border="1">
         <caption>EVENTOS</caption>
         <tr>
             <th>Porcentaje sobre el total de eventos:</th>
             <th><%=porcentajeEventos%>%</th>
         </tr>
         <tr>
             <th>Coste medio de los eventos:</th>
             <th><%=mediaPrecio%> euros</th>
         </tr>
        </table>
         <br/>
         <ul>
            <li><a href="formularioAnalisisEstadistico.jsp">Nuevo analisis ...</a></li>
            <li><a href="adminHome.jsp">Volver a la página principal</a></li>
        </ul>
          
    </body>
</html>
