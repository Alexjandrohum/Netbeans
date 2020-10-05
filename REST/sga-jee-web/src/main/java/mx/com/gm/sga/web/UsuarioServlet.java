/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioService;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet{
    
    @Inject
    UsuarioService usuarioService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        List<Usuario> usuarios = usuarioService.listaUsuario();
        System.out.println("Usuarios: "+usuarios);
        request.setAttribute("usuarios", usuarios);
        try {
            request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
        } catch (ServletException ex) {
            System.out.println("ServletException - Usuario servlet - doGet");
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            System.out.println("IOException - Usuario servlet - doGet");
            ex.printStackTrace(System.out);
        }
    }
    
}
