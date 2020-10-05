
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
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Variable contador
        int contador = 0;
        
        //Si ya existe el contador visitas
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(cookie.getValue());
                }
            }
        }
        //incrementar el contador en 1
        contador++;
        //agregamos la respuesta al navegador
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //La cookie se almacenara en el cliente por una hora es decir 3600sg
        c.setMaxAge(3600);
        response.addCookie(c);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contador de visitas: "+contador);
    }
}
