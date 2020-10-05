/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofinal;

import java.util.Scanner;
import negocio.CatalogoPeliculasImpl;

/**
 *
 * @author alexjandrohum
 */
public class LaboratorioFinal {

    public static void main(String... args) {

        int opcion;
        String nombreArchivo;
        String rutaArchivo = "/Users/alexjandrohum/files/peliculas.txt";
        CatalogoPeliculasImpl peliculas = new CatalogoPeliculasImpl();

        
        Scanner sc = new Scanner(System.in);

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    peliculas.iniciarArchivo(rutaArchivo);
                    System.out.println("Bienvenido al catalogo de peliculas");
                    break;
                case 2:
                    Scanner nuevaPelicula = new Scanner(System.in);
                    System.out.println("Introduce el nombre de una pelicula a agregar: ");
                    nombreArchivo = nuevaPelicula.nextLine();
                    peliculas.agregarPelicula(nombreArchivo, rutaArchivo);
                    break;
                case 3:
                   
                    peliculas.listarPeliculas(rutaArchivo);
                    
                    break;
                case 4:
                    Scanner scBuscar = new Scanner(System.in);
                    System.out.println("Introduce el nombre de una pelicula a buscar: ");
                    nombreArchivo = scBuscar.nextLine();
                    peliculas.buscarPelicula(rutaArchivo, nombreArchivo);
                    break;
                case 0:
                    System.out.println("########### Finalizó el programa ###########");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ninguna opcion seleccionada");

            }

        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("Elige una opción:");
        System.out.println("1.- Iniciar catalogo Peliculas"
                + "\n2.- Agregar pelicula"
                + " \n3.- Listar pelicula"
                + "\n4.- Buscar pelicula"
                + "\n0.- Salir");
    }

}
