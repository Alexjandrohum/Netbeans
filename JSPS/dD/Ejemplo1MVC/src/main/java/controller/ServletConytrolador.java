/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Rectangulo;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/ServletConytrolador")
public class ServletConytrolador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest reques, HttpServletResponse response) throws ServletException, IOException {

        /*
        //1.- Procesamos parametros
        
        //2.- Creamos el JavaBeans
        Rectangulo rec = new Rectangulo(3,6);
        
        //3.- Agregamos el JavaBEans un alcance 
        reques.setAttribute("mensaje", "Saludos desde el servlet");
        HttpSession sesion = reques.getSession();
        sesion.setAttribute("rectangulo", rec);
        // 4.- Redireccionar a la vista seleccionada
        
        RequestDispatcher rd = reques.getRequestDispatcher("view/DesplegarVariables.jsp");
        rd.forward(reques, response);
         */
        //1.- Procesamos parametros
        String accion = reques.getParameter("accion");

        //2.- Creamos los java Beans
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 5);
        Rectangulo recApplication = new Rectangulo(5, 6);

        //3.- Agregamos los Java Beans a algún alcance
        //Revisamos la accion proporcionada
        if ("agregarVariables".equals(accion)) {
            //Alcance Request
            reques.setAttribute("rectanguloRequest", recRequest);
            //Alcance de Session
            HttpSession sesion = reques.getSession();
            sesion.setAttribute("rectanguloSession", recSession);
            //Alcance de Aplicacion
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplication", recApplication);

            //Agregamos un mensaje
            reques.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //Redireccionamos al jsp de index
            reques.getRequestDispatcher("index.jsp").forward(reques, response);
            
        } else if ("listarVariables".equals(accion)) {
            //4.- Redireccionar al JSP que despliega las variables
            reques.getRequestDispatcher("WEB-INF/AlcanceVariables.jsp").forward(reques, response);
        }else{
            //4.- Redireccionamos a la página de inicio
            reques.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            reques.getRequestDispatcher("index.jsp").forward(reques, response);
        }

    }

}
