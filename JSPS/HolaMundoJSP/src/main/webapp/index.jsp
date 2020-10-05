<%-- 
    Document   : index
    Created on : 9/06/2020, 12:19:54 PM
    Author     : alexjandrohum
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola Mundo JSPS</title>
    </head>
    <body>
        <h1>Hello World! JSPS</h1>
    <ui>
        <li>
            <% out.print("Hola mundo con Scriptlets");%>
        </li>
        <li>
            ${"Hola mundo con expresion Language (EL)"}
        </li>
        <li>
            <%= "Hola mundo con expresiones" %>
        </li>
        <li>
            <c:out value="Hola Mundo desde JSTL"/>
        </li>
    </ui>
    </body>
</html>
