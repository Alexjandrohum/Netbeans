<%-- 
    Document   : DesplegarVariables
    Created on : 10/06/2020, 10:12:26 AM
    Author     : alexjandrohum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliege de variables </title>
    </head>
    <body>
        <h1>Despliege de Variables</h1>
        Variable en alcance de Request:
        ${mensaje}
        <br/>
        <br/>
        Variable en alcance de sesion
        <br/>
        Rectangulo
        Base: ${rectangulo.base}
        <br/>
        Altura: ${rectangulo.altura}
        <br/>
        Area: ${rectangulo.area}
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al inicio</a>
    </body>
</html>
