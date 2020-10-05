/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.AccesoDatosImpl;
import domain.Pelicula;
import exepciones.EscrituraDatosEx;
import exepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatosImpl datos;
    
    public CatalogoPeliculasImpl(){
        this.datos  = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        try {
            datos.escribir(new Pelicula(nombrePelicula), nombreArchivo, true);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            List<Pelicula> peliculas =  datos.listar(nombreArchivo);
            System.out.println("Peliculas:");
            for(Pelicula pelicula : peliculas){
                System.out.println(pelicula.getNombre());
            }
          
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            System.out.println(datos.buscar(nombreArchivo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            datos.crear(nombreArchivo);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }
}