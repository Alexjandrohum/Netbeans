/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pelicula;
import exepciones.EscrituraDatosEx;
import exepciones.LecturaDatosEx;
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
public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> listaPelicula = new ArrayList<>();
        
        try {
            BufferedReader brObject = new BufferedReader(new FileReader(archivo));
            String lecturaArchivo = brObject.readLine();

            while (lecturaArchivo != null) {
                listaPelicula.add(new Pelicula(lecturaArchivo));
                lecturaArchivo = brObject.readLine();
            }
            brObject.close();

        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Archivo no encontrado");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error listar Pelicula: " + ex);
        }
        return listaPelicula;
    }

    @Override
    public void escribir(Pelicula pelicual, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter escribirArchivo = new PrintWriter(new FileWriter(archivo, anexar));
            escribirArchivo.println(pelicual.getNombre());
            escribirArchivo.close();
            System.out.println("La pelicula fué agregada correctamente.");
        } catch (FileNotFoundException ex) {
            throw new EscrituraDatosEx("Archivo no entontrado: " + ex);
        } catch (IOException ex) {
            throw new EscrituraDatosEx("Error en la escritura del archivo: " + ex);
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String lecturaArchivo;
        try {
            BufferedReader brObject = new BufferedReader(new FileReader(archivo));
            lecturaArchivo = brObject.readLine();
            while (lecturaArchivo != null) {
                if (lecturaArchivo.equals(buscar)) {
                    return "Pelicula: " + lecturaArchivo;
                } else {
                    lecturaArchivo = brObject.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            throw new LecturaDatosEx("Archivo no encontrado: " + ex);
        } catch (IOException ex) {
            throw new LecturaDatosEx("Error en la lectura: " + ex);
        }

        return lecturaArchivo;
    }

    @Override
    public void crear(String nombreArchivo) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            if (!this.existe(nombreArchivo)) {
                PrintWriter crearArchivo = new PrintWriter(archivo);
                System.out.println("Archivo creado correctamente");
            }

        } catch (FileNotFoundException ex) {
            throw new EscrituraDatosEx("Error al crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Archivo eliminado");
        } else {
            System.out.println("El archivo no existe");
        }
    }
}
