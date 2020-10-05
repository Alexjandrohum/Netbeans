<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="titulo" /></title>
    </head>
    <body>
        <h1><s:property value="titulo"/></h1>
        <s:form>
            <s:textfield key="form.usuario" name="user"/>
            <br>
            <s:password key="form.password" name="pass"/>
            <br>
            <s:submit key="form.boton" name="submit" />
        </s:form>
            <s:property value="valores" />
            <br>
            <s:property value="usuario"/> <s:property value="user"/>
            <br>
            <s:property value="password"/> <s:property value="pass"/>
            
    </body>
</html>
