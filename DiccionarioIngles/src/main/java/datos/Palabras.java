/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author alexjandrohum
 */
public class Palabras {
    
    int idPalabras;
    String nombre;
    String significado;
    boolean leido;
    
    public Palabras(){
        
    }
    
    public Palabras(int id, String nombre, String significado, boolean leido){
        this.idPalabras = id;
        this.nombre = nombre;
        this.significado = significado;
        this.leido = leido;
    }

    @Override
    public String toString() {
        return "Palabras{" + "idPalabras=" + idPalabras + ", nombre=" + nombre + ", significado=" + significado + ", leido=" + leido + '}';
    }
    
    
}

    
