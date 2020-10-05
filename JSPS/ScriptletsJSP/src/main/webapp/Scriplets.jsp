<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scrptlets</title>
    </head>
    <body>
        <h1>JSP con Scrptlets</h1>
        <br>
        <%-- Scriplet para enviar informacion al nevegador --%>
        <%
            out.print("Saludos desde un scriplet");
        %>
        <%--Scrpts para manipular los objetos implicitos--%>

        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la aplicación: " + nombreAplicacion);
        %>
        <br>
        <%-- Scriplet con codigo condicionado--%>
        <%
            if (session != null && session.isNew()) {
        %>
        la sesion si es nueva
        <%
        } else if (session != null) {
        %>
        la sesion no es nueva
        <%
            }
        %>
        
        <a href="index.html">regresar al inicio</a>
    </body>
</html>
