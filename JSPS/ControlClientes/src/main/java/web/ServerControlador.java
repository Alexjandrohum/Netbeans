/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import datos.ClienteDAO;
import dominio.ClienteDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author alexjandrohum
 */
@WebServlet("/ServerControlador")
public class ServerControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClienteDTO> clientes = new ClienteDAO().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalCLientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        //request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        response.sendRedirect("Clientes.jsp");
    }

    private double calcularSaldoTotal(List<ClienteDTO> clientes) {
        double saldoTotal = 0;
        for (ClienteDTO cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }

        return saldoTotal;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCliente(request, response);
                    break;
                case "modificar":
                    modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los datos el cliente
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente (modelo)
        ClienteDTO cliente = new ClienteDTO(nombre, apellido, email, telefono, saldo);

        //Insertamos los datos del CLiente
        int registrosModificados = new ClienteDAO().insertar(cliente);
        System.out.println("Registros modificados: " + registrosModificados);

        //Reedirección a la acción por default
        this.accionDefault(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperar el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        ClienteDTO cliente = new ClienteDAO().encontrar(new ClienteDTO(idCliente));
        System.out.println("Cliente: "+cliente);
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
        
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los datos  de editar el cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente (modelo)
        ClienteDTO cliente = new ClienteDTO(idCliente, nombre, apellido, email, telefono, saldo);
        //System.out.println("Modificar cliente: "+cliente);
        //Insertamos los datos del CLiente
        int registrosModificados = new ClienteDAO().actualizar(cliente);
        System.out.println("Registros modificados: " + registrosModificados);
 
        //Reedirección a la acción por default
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los datos  de editar el cliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        //Creamos el objeto de cliente (modelo)
        ClienteDTO cliente = new ClienteDTO(idCliente);
        //System.out.println("Modificar cliente: "+cliente);
        //Insertamos los datos del CLiente
        int eliminarCliente = new ClienteDAO().eliminar(cliente);
        System.out.println("Registros eliminados: " + eliminarCliente);
 
        //Reedirección a la acción por default
        this.accionDefault(request, response);
    }

}
