<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo inclusion din�mica</title>
    </head>
    <body>
        <h1>Inclusion Din�mica</h1>
        <br>
        <jsp:include page="paginas/RecursoPublicoJSP.jsp"/>
        <br>
        <jsp:include page="WEB-INF/RecursoPrivado.jsp">
            <jsp:param name="colorFondo" value="yellow"/>
        </jsp:include>
    </body>
</html>
