<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Modificador</title>
    </head>
    <body>
        <h1>JSP Modificador</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
        Modificamos los atributos
        <br/>
        <br/>
        <%
            int baseValor = 5;
            int altura = 10;
            
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=altura%>"/>
    </body>
</html>
