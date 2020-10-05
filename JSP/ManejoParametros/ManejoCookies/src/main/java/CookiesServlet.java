
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
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        boolean nuevoUsuario = true;
        
        //Obtener el arreglo de cookies
        Cookie[] cookies = request.getCookies();
        
        //buscando cookie existente creada con anterioridad
        //llamada visitante concurrente
        
        if(cookies != null){
            for(Cookie co : cookies){
                if(co.getName().equals("visitanteConcurrente") && co.getValue().equals("si")){
                    //Si ya existe la cookie es un usuario concurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio web por primera vez";
        }else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        
        response.setContentType("txt/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: "+mensaje);
        out.close();
        
    }
    
}
