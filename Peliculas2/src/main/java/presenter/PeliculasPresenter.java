/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import contract.AccesoContract;
import contract.CatalogoPeliculasContract;
import dao.PeliculasDao;
import dto.PeliculaDTO;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class PeliculasPresenter implements CatalogoPeliculasContract {

    private final AccesoContract acceso;

    public PeliculasPresenter() {
        acceso = new PeliculasDao();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        boolean statusArchivo;
        try {
            statusArchivo = acceso.existe(nombreArchivo);
            acceso.escribir(new PeliculaDTO(nombrePelicula), nombreArchivo, statusArchivo);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            List<PeliculaDTO> peliculas = acceso.listar(nombreArchivo);
            if (!peliculas.isEmpty()) {
                System.out.println("Peliculas: ");
                for (PeliculaDTO pelicula : peliculas) {
                    System.out.println(pelicula.getNombre());
                }
            } else {
                System.out.println("Sin peliculas agregadas");
            }
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        try {
            System.out.println(acceso.buscar(nombreArchivo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            acceso.crear(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

}
