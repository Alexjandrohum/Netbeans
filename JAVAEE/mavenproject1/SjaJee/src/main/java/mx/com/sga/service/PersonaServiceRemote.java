/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.service;

import java.util.List;
import javax.ejb.Remote;
import mx.com.sga.domain.Persona;

/**
 *
 * @author alexjandrohum
 */
@Remote
public interface PersonaServiceRemote {
    public List<Persona> listarPersonas();
    public Persona encontrarPersonaPorId(Persona persona);
    public Persona encontrarPersonaPorEmail(Persona persona);
    public void registrarPErsona(Persona persona);
    public void modificarPersona(Persona persona);
     public void eliminarPersona(Persona persona);
}
