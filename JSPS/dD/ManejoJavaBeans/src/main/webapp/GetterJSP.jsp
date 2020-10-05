<%-- 
    Document   : GetterJSP
    Created on : 9/06/2020, 09:00:52 PM
    Author     : alexjandrohum
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lectura de Java Bean</title>
    </head>
    <body>
        <h1>Lectura de Java Bean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/>
        Valor base: <jsp:getProperty name="rectangulo" property="base"/>
        <br/>
        Altura: <jsp:getProperty name="rectangulo" property="altura"/>
        <br/>
        Area: <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
