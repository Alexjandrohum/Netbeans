/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;

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
            
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            
            personaJDBC.update(new Persona(2, "Carlos", "Perez", "emialCarlos", "234234"));
            personaJDBC.insert(new Persona("Manuela", "Mari","ma@","8768"));
            
            conexion.commit();
            
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
