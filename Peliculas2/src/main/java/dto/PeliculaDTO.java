/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author alexjandrohum
 */
public class PeliculaDTO {
    
    private String nombre;
    
    public PeliculaDTO(){
        
    }
    
    public PeliculaDTO(String name){
        this.nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PeliculaDTO{" + "nombre=" + nombre + '}';
    }
    
}
