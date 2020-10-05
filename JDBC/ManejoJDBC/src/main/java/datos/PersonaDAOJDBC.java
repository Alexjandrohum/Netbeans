/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.PersonaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class PersonaDAOJDBC implements PersonaDAO{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "select idpersona, nombre, apellido, email, telefono from persona";
    private static final String SQL_INSERT = "insert into persona (nombre, apellido, email, telefono) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update persona set nombre=?, apellido=?, email=?, telefono=? where idpersona=?";
    private static final String SQL_DELETE = "delete from persona where idpersona=?";

    public PersonaDAOJDBC() {

    }

    public PersonaDAOJDBC(Connection con) {
        this.conexionTransaccional = con;
    }

    public List<PersonaDTO> select() throws SQLException{
        Connection connect = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            connect = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = connect.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            persona = new PersonaDTO();
            while (result.next()) {
                int idPersona = result.getInt("idpersona");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String telefono = result.getString("telefono");

                personas.add(new PersonaDTO(idPersona, nombre, apellido, email, telefono));
            }
        }finally {
            Conexion.close(stmt);
            Conexion.close(result);
            if (this.conexionTransaccional == null) {
                Conexion.close(connect);
            }
        }
        return personas;
    }

    public int insert(PersonaDTO persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());

            System.out.println("Wjecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
        return rows;
    }

    public int update(PersonaDTO persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecucando query: " + SQL_UPDATE);
            stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPErsona());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
        return rows;
    }

    public int delete(PersonaDTO persona) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPErsona());
            rows = stmt.executeUpdate();
            System.out.println("Numero de registros eliminados: " + rows);
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(con);
            }
        }
        return rows;
    }
}
