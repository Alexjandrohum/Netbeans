/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.TiendaDAO;
import dominio.TiendaDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/TiendaControlador")
public class TiendaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editarTienda":
                    this.editarTienda(request, response);
                    break;
                case "eliminarTienda":
                    this.eliminarTienda(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "modificarTienda":
                    this.actualizarTienda(request, response);
                    break;
                case "insertarTienda":
                    this.insertarTienda(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<TiendaDTO> tiendas = new TiendaDAO().listarTienda();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("tiendas", tiendas);
            response.sendRedirect("Tienda.jsp");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al mostrar las tiendas");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error en reederigir a Tienda.jsp");
        }
    }

    private void editarTienda(HttpServletRequest request, HttpServletResponse response) {

        String editarTienda = "/WEB-INF/paginas/tienda/EditarTienda.jsp";
        try {
            //Recuperación de la información de la tienda elegida
            int idTienda = Integer.parseInt(request.getParameter("idTienda"));
            TiendaDTO tienda = new TiendaDAO().buscar(new TiendaDTO(idTienda));
            request.setAttribute("tienda", tienda);
            request.getRequestDispatcher(editarTienda).forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Excepciones .editarTienda");
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            System.out.println("Excepcion encontrar Tienda");
            ex.printStackTrace(System.out);
        }
    }

    private void actualizarTienda(HttpServletRequest request, HttpServletResponse response) {
        int idTienda = Integer.parseInt(request.getParameter("idTienda"));
        String nombre = request.getParameter("nombre");
        String calle = request.getParameter("calle");
        String telefono = request.getParameter("telefono");

        try {
            int registrosActualizados = new TiendaDAO().actualizar(new TiendaDTO(idTienda, nombre, calle, telefono));
            System.out.println("Registros Actulizados: " + registrosActualizados);
            this.accionDefault(request, response);
        } catch (SQLException ex) {
            System.out.println("Actualizar tienda actualizarTienda");
            ex.printStackTrace(System.out);
        }
    }

    private void insertarTienda(HttpServletRequest request, HttpServletResponse response) {
        //Recuperación de los datos de la Tienda
        String nombre = request.getParameter("nombre");
        String calle = request.getParameter("calle");
        String telefono = request.getParameter("telefono");

        try {
            //Insertamos los datos en la TiendaDTO
            int registrosInsertados = new TiendaDAO().insertar(new TiendaDTO(nombre, calle, telefono));
            System.out.println("Registros insertados: " + registrosInsertados);
            this.accionDefault(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private void eliminarTienda(HttpServletRequest request, HttpServletResponse response) {
        //Recuperamos el id de la Tienda
        int idTienda = Integer.parseInt(request.getParameter("idTienda"));

        try {
            //Insertamos y accedemos al método para eliminar la Tienda
            int eliminarTienda = new TiendaDAO().eliminar(new TiendaDTO(idTienda));
            System.out.println("Registros eliminados: "+eliminarTienda);
            this.accionDefault(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
