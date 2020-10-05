/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class UsuariosJDBC {

    private static PreparedStatement stmt = null;
    private static ResultSet result = null;
    private static int rows = 0;

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    public UsuariosJDBC() {
        
    }

    public static List<Usuario> select() {
        List<Usuario> user = new ArrayList<>();
        Connection userConnection = null;
        try {
            userConnection = Conexion.getConecction();
            stmt = userConnection.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idUsuario = result.getInt("id_usuario");
                String usuario = result.getString("usuario");
                String password = result.getString("password");

                user.add(new Usuario(idUsuario, usuario, password));
            }
            System.out.println("Ejecutando query: " + SQL_SELECT);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(userConnection);
            Conexion.close(stmt);
            Conexion.close(result);
        }
        return user;
    }

    public static int insert(Usuario user) {

        Connection userConnection = null;
        try {
            userConnection = Conexion.getConecction();
            stmt = userConnection.prepareStatement(SQL_INSERT);
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getPassword());

            System.out.println("Ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Elementos insertados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(userConnection);
            Conexion.close(stmt);
        }
        return rows;
    }

    public static int update(Usuario user) {
        Connection userConnection = null;
        try {
            userConnection = Conexion.getConecction();
            stmt = userConnection.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getId_usuario());
            
            System.out.println("Ejecutando query: "+SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Elementos modificados: "+rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(userConnection);
            Conexion.close(stmt);
        }
        return rows;
    }

    public static int delete(Usuario user) {
        Connection userConnection = null;
        try {
            userConnection = Conexion.getConecction();
            stmt = userConnection.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_usuario());
            
            System.out.println("Ejecutando query: "+SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Elementos eliminados: "+rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(userConnection);
            Conexion.close(stmt);
        }
        return rows;
    }
}
