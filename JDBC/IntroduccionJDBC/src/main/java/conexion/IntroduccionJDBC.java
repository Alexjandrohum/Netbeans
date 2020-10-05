/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexjandrohum
 */
public class IntroduccionJDBC {
    public static void main(String[] args) {
        
         // 1.- Creamos nuestra cadena de conexión a mysql
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
        
        try {
            // 2.- Creamos el objeto de conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, "root", "password");
            
            // 3.- Creamos un objeto de tipo Stament
            Statement instruccion = conexion.createStatement();
            
            //4.- Creamos el query
            String sql = "select idpersona, nombre, apellido, email, telefono from persona";
            
            // 5.- Ejecución del query
            ResultSet resultado = instruccion.executeQuery(sql);
            
            // 6.- Procesamos el resultado
            while(resultado.next()){
                System.out.println("Id Persona: "+resultado.getInt(1));
                System.out.println("Nombre: "+resultado.getString(2));
                System.out.println("Apellido: "+resultado.getString(3));
                System.out.println("Email: "+resultado.getString(4));
                System.out.println("Telefono: "+resultado.getString(5));
                
            }
            
            // 7.- Se deben de cerrar las conexiones a la base de datos
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
