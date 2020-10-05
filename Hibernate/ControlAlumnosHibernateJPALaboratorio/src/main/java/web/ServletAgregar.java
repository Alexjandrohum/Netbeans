/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import servicio.ServicioAlumno;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        int noCalle = Integer.parseInt(request.getParameter("noCalle"));
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        ServicioAlumno alumnoServicio = new ServicioAlumno();
        Domicilio domicilio = new Domicilio(calle, noCalle, pais);
        Contacto contacto = new Contacto(telefono, email);

        alumnoServicio.guardarAlumno(new Alumno(nombre, apellido, domicilio, contacto));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
