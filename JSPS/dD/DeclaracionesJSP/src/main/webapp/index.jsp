<%-- Agregamos una declaración JSP--%>

<%!
    //Declaramos una variable con su método get
    private String suario = "Alberto";

    public String getUsuario() {
        return this.suario;
    }

//Declaramos un contador de visitas
    private int contadorVisitas = 1;
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones JSP</title>
    </head>
    <body>
        <h1>Declaraciones JSP</h1>
        Valor usuario por medio del atributo: <%= this.suario %>
        <br>
        Valor usuario por medio del método: <%= this.getUsuario() %>
        <br>
        Contador visitas: <%= this.contadorVisitas++ %>
    </body>
</html>
