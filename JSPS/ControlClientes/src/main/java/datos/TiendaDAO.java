/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.TiendaDTO;
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
public class TiendaDAO {
    
    private static final String SQL_SELECT = "SELECT id_tienda, nombre, calle, telefono FROM tienda";
    private static final String SQL_SELECT_BY_ID = " SELECT id_tienda, nombre, calle, telefono FROM tienda WHERE id_tienda=?";
    private static final String SQL_INSERT = "INSERT INTO tienda (nombre, calle, telefono) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tienda SET nombre=?, calle=?, telefono=? WHERE id_tienda=?";
    private static final String SQL_DELETE = "DELETE FROM tienda WHERE id_tienda=?";
    
    public List<TiendaDTO> listarTienda() throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<TiendaDTO> tiendas = new ArrayList<>();
        
        con = Conexion.getConecction();
        stmt = con.prepareStatement(SQL_SELECT);
        result = stmt.executeQuery();
        while(result.next()){
            int idTienda = result.getInt("id_tienda");
            String nombre = result.getString("nombre");
            String calle = result.getString("calle");
            String telefono = result.getString("telefono");
            
            tiendas.add(new TiendaDTO(idTienda, nombre, calle, telefono));
        }
        
        Conexion.close(con);
        Conexion.close(stmt);
        Conexion.close(result);
        
        return tiendas;
    }
    
    public TiendaDTO buscar(TiendaDTO tienda) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        
        con = Conexion.getConecction();
        stmt = con.prepareStatement(SQL_SELECT_BY_ID);
        stmt.setInt(1, tienda.getIdTienda());
        result = stmt.executeQuery();
        result.next();
        
        String nombre = result.getString("nombre");
        String calle = result.getString("calle");
        String telefono = result.getString("telefono");
        
        tienda.setNombre(nombre);
        tienda.setCalle(calle);
        tienda.setTelefono(telefono);
        
        Conexion.close(con);
        Conexion.close(stmt);
        Conexion.close(result);
        
        return tienda;
        
    }
    
    public int insertar(TiendaDTO tienda) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        
        con = Conexion.getConecction();
        stmt = con.prepareStatement(SQL_INSERT);
        stmt.setString(1, tienda.getNombre());
        stmt.setString(2, tienda.getCalle());
        stmt.setString(3, tienda.getTelefono());
        
        contador = stmt.executeUpdate();
        
        Conexion.close(con);
        Conexion.close(stmt);
        
        return contador;
    }
    
    public int actualizar(TiendaDTO tienda) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        
        con = Conexion.getConecction();
        stmt = con.prepareStatement(SQL_UPDATE);
        stmt.setString(1, tienda.getNombre());
        stmt.setString(2, tienda.getCalle());
        stmt.setString(3, tienda.getTelefono());
        stmt.setInt(4, tienda.getIdTienda());
        
        contador = stmt.executeUpdate();
        
        Conexion.close(con);
        Conexion.close(stmt);
        
        return contador;
    }
    
    public int eliminar(TiendaDTO tienda) throws SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        
        con = Conexion.getConecction();
        stmt = con.prepareStatement(SQL_DELETE);
        stmt.setInt(1, tienda.getIdTienda());
        
        contador = stmt.executeUpdate();
        
        Conexion.close(con);
        Conexion.close(stmt);
        
        return contador;
    }
    
}
