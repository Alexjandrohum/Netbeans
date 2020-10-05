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
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Pedir el atributo contador visitas al contador session
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        //Si es nullo accedemos por primera vez a la aplicación
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        }else{
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Mandamos la respuesta al cliente
        
        PrintWriter out = response.getWriter();
        
        out.print(titulo);
        out.print("<br/>");
        out.print("Contador de las sessiones: "+contadorVisitas);
        out.print("<br/>");
        out.print("Id de la sesión: "+sesion.getId());
        out.close();
    }
}
