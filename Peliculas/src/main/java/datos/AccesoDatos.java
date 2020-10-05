/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import exepciones.EscrituraDatosEx;
import exepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface AccesoDatos {
    
    boolean existe(String nombreArchivo);
    
    List<Pelicula> listar(String nombre)throws LecturaDatosEx;
    
    void escribir(Pelicula pelicual, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;
    
    void crear(String nombreArchivo) throws EscrituraDatosEx;
    
    void borrar(String nombreArchivo);
    
}
