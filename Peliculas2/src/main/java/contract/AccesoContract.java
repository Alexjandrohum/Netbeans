/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import dto.PeliculaDTO;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface AccesoContract {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<PeliculaDTO> listar(String nombreArchivo) throws LecturaDatosEx;

    void escribir(PeliculaDTO pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;

    void crear(String nombreArchivo) throws AccesoDatosEx;

    void borrar(String nombreArchivo) throws AccesoDatosEx;

}
