/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();

        //Recuperamos la lista de articulos agregados si ya existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulo");

        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulo", articulos);
        }
        //Procesamos en nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //Revisar el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        try (PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br/>");
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            out.print("<br/>");
            out.print("<a href='/CarritoCompras'>Regresar al inicio</a>");
        }

    }

}
