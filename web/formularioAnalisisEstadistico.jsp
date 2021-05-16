<%-- 
    Document   : formularioAnalisisEstadistico
    Created on : 12-may-2021, 18:25:33
    Author     : Francisco Cuadrado
--%>

<%@page import="taw.entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario analisis estadístico</title>
    </head>
    
    <body>
        <form action="ServletAnalisisEstadistico">
            <h2>Datos usuario:</h2>
            Edad: <input type="number" name="edadInicio"  maxlength="10" size="10" /> - 
            <input type="number" name="edadFin" maxlength="10" size="10" /> <br/>
            Sexo:  <br/>
            <input type="radio" name="sexo" value="Masculino"/>Masculino <br/>  
            <input type="radio" name="sexo" value="Femenino"/>Femenino <br/>
            <input type="radio" name="sexo" value="" checked/>Ambos <br/>
            
            <h2>Datos eventos:</h2>
            
            Fecha:  <input type="number" name="year"  maxlength="10" size="10"  /><br/>
            
            Precio: <input type="number" name="costeInicio"  maxlength="52" size="52" /> - 
            <input type="number" name="costeFin" maxlength="52" size="52" /> <br/>
            
            <input type="submit" value="Enviar"/>
            
        </form>
    </body>

