/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest reques, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = reques.getParameter("usuario");
        String password = reques.getParameter("password");
        String tecnologias[] = reques.getParameterValues("tecnologia");
        String genero = reques.getParameter("genero");
        String ocupacion = reques.getParameter("ocupacion");
        String musica[] = reques.getParameterValues("musica");
        String comentario = reques.getParameter("comentarios");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet</h1>");
        out.print("<table border='1'>");

        out.print("<tr>");
        out.print("<td>Usuario</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Contraseña</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Tecnologías</td>");
        out.print("<td>");
        for (String tecnologia : tecnologias) {
            out.print(tecnologia + " / ");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Genero</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Ocupacion</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Musica</td>");
        out.print("<td>");
        if (musica != null) {
            for (String musicas : musica) {
                out.print(musicas + " / ");
            }
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>Comentario</td>");
        out.print("<td>");
        out.print(comentario);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table>");
        out.print("</body>");
        out.print("</html>");

    }

}
