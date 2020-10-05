/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.servlet;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.sga.domain.Persoma;
import mx.com.sga.service.PersonaService;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("personas")
public class PersonaServlet extends HttpServlet{
    
    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Persoma> listaPersona = personaService.listarPersonas();
        
        System.out.println("Personas: "+listaPersona);
        request.setAttribute("personas", listaPersona);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
    
}
