/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.Alumno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import servicio.ServicioAlumno;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/ServletModificar")
public class ServerModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        Alumno alumno = new Alumno();
        alumno = servicioAlumno.buscarAlumno(new Alumno(idAlumno));
        //request.setAttribute("alumnoModificar", alumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumnoModificar", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String modificar = request.getParameter("modificar");
        String eliminar = request.getParameter("eliminar");
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        if (modificar != null) {

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            int noCalle = Integer.parseInt(request.getParameter("noCalle"));
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumnoModificar");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);
            sesion.removeAttribute("alumnoModificar");
        }
        if (eliminar != null) {
            int idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            servicioAlumno.eliminarAlumno(new Alumno(idAlumno));
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
