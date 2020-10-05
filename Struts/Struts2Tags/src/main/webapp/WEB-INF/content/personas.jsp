<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Personas</title>
        <s:head/>
    </head>
    <body>
        <h1>Formulario de Personas (OGNL)</h1>
        <s:form>
            <s:textfield label="Nombre" name="persona.nombre"/>
            <s:textfield label="Calle" name="persona.domicilio.calle"/>
            <s:textfield label="No. calle" name="persona.domicilio.numeroCalle"/>
            <s:textfield label="Pais" name="persona.domicilio.pais"/>
            <s:submit value="Enviar"/>
        </s:form>
        
        <br/>
        <h2>Valores proporcionados:</h2><br/>
        Nombre: <s:property value="persona.nombre"/><br/>
        Calle: <s:property value="persona.domicilio.calle"/><br/>
        No. Calle: <s:property value="persona.domicilio.numeroCalle"/><br/>
        Pais: <s:property value="persona.domicilio.pais"/>
        
        <s:if test="persona.nombre != null">
            <s:if test="persona.nombre == 'admin'">
                Es un usuario ADMINISTRADOR
            </s:if>
            <s:else>
                El usuario NO es ADMINISTRADOR
            </s:else>
        </s:if>
    </body>
</html>
