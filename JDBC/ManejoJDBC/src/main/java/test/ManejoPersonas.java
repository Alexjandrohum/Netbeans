/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaDAOJDBC;
import domain.PersonaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class ManejoPersonas {
    
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);//Para configurar que el autocomit no se realice automáticamente
            }
            
            PersonaDAO personaDAO = new PersonaDAOJDBC(conexion);
            
            List<PersonaDTO> personasLista = personaDAO.select();
            for(PersonaDTO persona : personasLista){
                System.out.println(persona);
            }
            
            conexion.commit();
            System.out.println("Se ha echo el comit de transaccion");
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
            System.out.println("Entramos al ROLLBACK");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
}
