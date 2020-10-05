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
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String metodoHttp = request.getMethod();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Servlets Cabeceros</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers Http</h1>");
        out.print("Metodo Http: "+metodoHttp);
        out.print("</body>");
        out.print("</html>");
        out.close();
        
    }
    
}
