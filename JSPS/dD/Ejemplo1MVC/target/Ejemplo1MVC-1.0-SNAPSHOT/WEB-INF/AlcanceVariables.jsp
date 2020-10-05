<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance VAriables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/><br/>
        Variables Request:
        Base: ${rectanguloRequest.base}
        Altura: ${rectanguloRequest.altura}
        Area: ${rectanguloRequest.area}
        <br/><br/>
        Variables Session:
        Base: ${rectanguloSession.base}
        Altura: ${rectanguloSession.altura}
        Area: ${rectanguloSession.area}
        <br/><br/>
        Variables Application:
        Base: ${rectanguloAplication.base}
        Altura: ${rectanguloAplication.altura}
        Area: ${rectanguloAplication .area}
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Link para regresar al inicio</a>
    </body>
</html>
