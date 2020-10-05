
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    protected void doPost(HttpServletRequest reques, HttpServletResponse response) throws IOException{
        //Simulando los datos correctos
        String usuarioOk = "Juan";
        String passwordOk = "123";
        
        String usuario = reques.getParameter("usuario");
        String password = reques.getParameter("password");
        
        PrintWriter out = response.getWriter();
        if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
            out.print("<h1>Datos Correctos</h1>");
            out.print("<br/>Usuarios: "+usuario);
            out.print("<br/>Password: "+password);
            
        }else{
            response.sendError(404,"Usuario inhautorizado");
        }
        out.close();
    }
    
}
