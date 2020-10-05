/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import contract.AccesoContract;
import dto.PeliculaDTO;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class PeliculasDao implements AccesoContract {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivoExiste = new File(nombreArchivo);
        return archivoExiste.exists();
    }

    @Override
    public List<PeliculaDTO> listar(String nombreArchivo) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        List<PeliculaDTO> peliculas = new ArrayList<>();
        try {
            BufferedReader brObject = new BufferedReader(new FileReader(archivo));
            String lectura = brObject.readLine();

            while (lectura != null) {
                peliculas.add(new PeliculaDTO(lectura));
                lectura = brObject.readLine();
            }
            brObject.close();
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Error al encontrar el archivo: " + ex);
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error al leer el archivo: " + ex);
        }
        return peliculas;
    }

    @Override
    public void escribir(PeliculaDTO pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escribirPelicula = new PrintWriter(new FileWriter(archivo, anexar));
            escribirPelicula.println(pelicula.getNombre());
            escribirPelicula.close();
            System.out.println("Pelicula agregada correctamente");
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Error al escribir en el archivo: " + ex);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader brObject = new BufferedReader(new FileReader(archivo));
            String lectura = brObject.readLine();

            while (lectura != null) {
                if (lectura.equals(buscar)) {
                    return "Pelicula encontrada: " + lectura;
                }
                lectura = brObject.readLine();
                brObject.close();
            }
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Error al encontrar el archivo: " + ex);
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error al leer el archivo: " + ex);
        }
        return "Pelicula no encontrada";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter crearArchivo = new PrintWriter(archivo);
            crearArchivo.close();
            System.out.println("Se creó correctamente el catalogo de peliculas.");
        } catch (FileNotFoundException ex) {
            throw new AccesoDatosEx("Error al crear el archivo: " + ex);
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if (this.existe(nombreArchivo)) {
            archivo.delete();
            System.out.println("Archivo borrado correctamente");
        } else {
            throw new AccesoDatosEx("El archivo no existe");
        }

    }

}
