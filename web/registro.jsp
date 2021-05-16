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
    <%
        String emailEdit = "", passwordEdit = "", nameEdit = "", surnameEdit = "", addressEdit = "",
            homeEdit = "", ageEdit = "18", sexEdit = "", rolEdit ="user";
        Usuario userEdit = (Usuario) request.getAttribute("userEdit");
        
        if(userEdit != null){
            emailEdit = userEdit.getCorreo(); 
            passwordEdit = userEdit.getPassword();
            nameEdit = userEdit.getNombre();
            surnameEdit = userEdit.getApellidos();
            addressEdit = userEdit.getDomicilio();
            homeEdit = userEdit.getResidencia();
            ageEdit = userEdit.getEdad().toString();
            sexEdit = userEdit.getSexo();
            rolEdit = userEdit.getRol();
        }
        
        String hidden = "hidden";
        Usuario sessionUser = (Usuario) session.getAttribute("user");
        if(sessionUser != null){
            if(sessionUser.getRol().equals("admin")){
                hidden = "";
            } else {
            response.sendRedirect("userHome.jsp");
            }
        }
        
    %>
    <body>
        <form method="post" action="Registro">
            <h1>Formulario de Registro</h1>
           
            Correo:<br>
            <input type="text" name="email" value="<%=emailEdit%>" maxlength ="50" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/><br><br>
            Contraseña:<br>
            <input type="text" name="password" value="<%=passwordEdit%>" minlength="8" maxlength ="50" required/><br><br>
            Nombre:<br>
            <input type="text" name="name" value="<%=nameEdit%>" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d1]+" required/><br><br>
            Apellidos:<br>
            <input type="text" name="surname" value="<%=surnameEdit%>" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d1]+" required/><br><br>
            Domicilio:<br>
            <input type="text" name="address" value="<%=addressEdit%>" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d10-9]+" required/><br><br>
            Residencia:<br>
            <input type="text" name="home" value="<%=homeEdit%>" maxlength ="50" pattern="[A-Za-zÀ-ÿ\u00f1\u00d10-9]+" required/><br><br>
            Edad:<br>
            <input type="number" name="age" value="<%=ageEdit%>" pattern="[0-9]" required/><br><br>
            Sexo:<br>
            <select name="sex">
                <%  if(sexEdit.equals("Masculino")){ %>
                <option selected>Masculino</option>
                <%  } else { %>
                <option>Masculino</option>
                <%  } if(sexEdit.equals("Femenino")){ %>
                <option selected>Femenino</option>
                <%  } else {    %>
                <option>Femenino</option>
                <%  }   %>
            </select><br><br>
            <p <%=hidden%>>Rol:<br>
            <select name="rol">
                <%  if(rolEdit.equals("user")){ %>
                <option selected>user</option>
                <%  } else { %>
                <option>user</option>
                <%  } if(rolEdit.equals("admin")){ %>
                <option selected>admin</option>
                <%  } else {    %>
                <option>admin</option>
                <%  } if(rolEdit.equals("creator")){ %>
                <option selected>creator</option>
                <%  } else {    %>
                <option>creator</option>
                <%  } if(rolEdit.equals("teleoperator")){%>
                <option selected>teleoperator</option>
                <%  } else {    %>
                <option>teleoperator</option>
                <%  } if(rolEdit.equals("analyst")){ %>
                <option selected>analyst</option>
                <%  } else {    %>
                <option>analyst</option>
                <%  }   %>
            </select></p>
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
