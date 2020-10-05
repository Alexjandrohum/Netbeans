/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import datos.UsuariosJDBC;
import domain.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class ManejoUsuarios {

    public static void main(String... args) {

        //Creando la instancia del acceso a los datos
        //UsuariosJDBC usuarioDatos = new UsuariosJDBC();
        //Creamos un objeto de sipo Usuarios
        //INSERTAR USUARIO
        //UsuariosJDBC.insert(new Usuario("maria","1234"));
        //UPDATE USUARIO
        //UsuariosJDBC.update(new Usuario("alexjandrohum","password"));
        //DELETE USUARIO
        //UsuariosJDBC.delete(new Usuario(2));
        // SELECT USUARIOS
        /*
        List<Usuario> user = UsuariosJDBC.select();
        
        for(Usuario usuario : user){
            System.out.println(usuario);
        }
         */
        Connection con;
        con = Conexion.getConecction();
        
        System.out.println(con);
    }

}
