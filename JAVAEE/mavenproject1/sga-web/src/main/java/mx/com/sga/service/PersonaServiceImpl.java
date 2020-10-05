/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.service;

import java.util.ArrayList;
import java.util.List;
import mx.com.sga.domain.Persoma;

/**
 *
 * @author alexjandrohum
 */
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

    @Override
    public List<Persoma> listarPersonas() {
        List<Persoma> personas = new ArrayList<>();
        personas.add(new Persoma(1,"Alex","Herrera","hgkg", "6576476"));
        personas.add(new Persoma(2,"Alexjandrohum","Herreraty","hgdfdgkg", "65776476"));
        return personas;
    }
    

    @Override
    public Persoma encontrarPersonaPorId(Persoma persona) {
        return null;
    }

    @Override
    public Persoma encontrarPersonaPorEmail(Persoma persona) {
        return null;
    }

    @Override
    public void registrarPErsona(Persoma persona) {
    }

    @Override
    public void modificarPersona(Persoma persona) {
    }

    @Override
    public void eliminarPersona(Persoma persona) {
    }
    
}
