/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author alexjandrohum
 */
public class TiendaDTO {
    private int idTienda;
    private String nombre;
    private String calle;
    private String telefono;

    public TiendaDTO(int idTienda) {
        this.idTienda = idTienda;
    }

    public TiendaDTO(String nombre, String calle, String telefono) {
        this.nombre = nombre;
        this.calle = calle;
        this.telefono = telefono;
    }

    public TiendaDTO(int idTienda, String nombre, String calle, String telefono) {
        this.idTienda = idTienda;
        this.nombre = nombre;
        this.calle = calle;
        this.telefono = telefono;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "TiendaDTO{" + "idTienda=" + idTienda + ", nombre=" + nombre + ", calle=" + calle + ", telefono=" + telefono + '}';
    }
    
     
}
