
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC!</h1>
        <br/>
        <!--<a href="${pageContext.request.contextPath}/ServletConytrolador">Link al Servlet Controlador</a>-->
        <div style="color: red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletConytrolador">Link al Servlet controlador SIN parametros</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletConytrolador?accion=agregarVariables">
            Link al Servlet controlador para agregar las variables</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletConytrolador?accion=listarVariables">
            Link al Servlet controlador para listar Variables</a>
    </body>
</html>

