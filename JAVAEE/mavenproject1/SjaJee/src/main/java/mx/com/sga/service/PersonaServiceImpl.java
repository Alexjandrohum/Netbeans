/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.service;

import java.util.ArrayList;
import java.util.List;
import mx.com.sga.domain.Persona;

/**
 *
 * @author alexjandrohum
 */
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Alex","Herrera","hgkg", "6576476"));
        personas.add(new Persona(2,"Alexjandrohum","Herreraty","hgdfdgkg", "65776476"));
        return personas;
    }
    

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona Persona) {
        return null;
    }

    @Override
    public void registrarPErsona(Persona persona) {
    }

    @Override
    public void modificarPersona(Persona persona) {
    }

    @Override
    public void eliminarPersona(Persona persona) {
    }
    
}
