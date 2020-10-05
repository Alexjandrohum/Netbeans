/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import contract.CatalogoPeliculasContract;
import java.util.Scanner;
import presenter.PeliculasPresenter;

/**
 *
 * @author alexjandrohum
 */
public class LaboratorioFinal {
    
    private static CatalogoPeliculasContract catalogo;
    private static Scanner sc;
    private static int opcion = 5;
    private static String rutaArchivo;
    private static String nombrePelicula;
    
    public static void main(String ...args){
        
        catalogo = new PeliculasPresenter();
        sc = new Scanner(System.in);
        rutaArchivo = "/Users/alexjandrohum/files/peliculas.txt";
        
        while(opcion != 0){
            getMenu();
            System.out.print("Ingresa una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarArchivo(rutaArchivo);
                    break;
                case 2:
                    System.out.print("Ingresa el nombre de una pelicula: ");
                    nombrePelicula = sc.nextLine();
                    catalogo.agregarPelicula(nombrePelicula, rutaArchivo);
                    break;
                case 3:
                    catalogo.listarPeliculas(rutaArchivo);
                    break;
                case 4: 
                    System.out.print("Ingresa el nombre de la pelicula a buscar: ");
                    nombrePelicula = sc.nextLine();
                    catalogo.buscarPelicula(rutaArchivo, nombrePelicula);
                    break;
                default:
                    System.out.println("Ingresa una opción válida");
            } 
        }
        
        System.out.println("Programa terminado!!!");
    }
    
    public static void getMenu(){
        System.out.println("1.- Inicia catálogo de peliculas "
                + "\n 2.- Agregar peliculas "
                + "\n 3.- Listar peliculas "
                + "\n 4.- Buscar pelicula "
                + "\n 0.- Salir");
    }
    
}
