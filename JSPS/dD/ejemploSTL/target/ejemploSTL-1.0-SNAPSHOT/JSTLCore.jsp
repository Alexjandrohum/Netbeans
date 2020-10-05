<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <!-- Manipulaci�n de variables -->
        <!--Definimos la variable-->
        <c:set var="nombre" value="Ernesto"/>
        Variable nombre: <c:out value="${nombre}"/> 
        <br/>
        <br/>
        Variable de c�digo Html
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        <br/>
        <br/>
        <c:set var="bandera" value="true"/>

        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>

        <!-- C�digo condicionado uso de Switch-->

        <c:if  test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <br/>
                    Opci�n uno seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <br/>
                    Opci�n dos seleccionada
                </c:when>
                <c:otherwise>
                    <br/>
                    Opcion proporcionada desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>

        <!-- Iteraci�n de un arreglo -->

        <%
            String nombres[] = {"Alex", "Juan", "Pedro"};
            request.setAttribute("nombres", nombres);
            
        %>
        <br/>
        <br/>
        Lista de nombres:
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
        <br/>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
