<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Alumno</title>
    </head>
    <body>
        <h1>Modificar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletModificar" method="POST">
            <input type="hidden" name="idAlumno" value="${alumnoModificar.idAlumno}"/>
            Nombre: <input type="text" name="nombre" value="${alumnoModificar.nombre}"/>
            <br/>
            Apellido: <input type="text" name="apellido" value="${alumnoModificar.apellido}"/>
            <br/>
            <br/>
            Datos Domicilio:
            <br/>
            Calle: <input type="text" name="calle" value="${alumnoModificar.domicilio.calle}"/>
            <br/>
            No. Calle: <input type="text" name="noCalle" value="${alumnoModificar.domicilio.noCalle}"/>
            <br/>
            Pais: <input type="text" name="pais" value="${alumnoModificar.domicilio.pais}"/>
            <br/>
            <br/>
            Datos de Contacto:
            <br/>
            Email: <input type="email" name="email" value="${alumnoModificar.contacto.email}"/>
            <br/>
            Telefono: <input type="tel" name="telefono" value="${alumnoModificar.contacto.telefono}"/>
            <br/>
            <input type="submit" name="modificar" value="Modificar" />
            <input type="submit" name="eliminar" value="Eliminar" />
        </form>
    </body>
</html>
