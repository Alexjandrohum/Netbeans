/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.PersonaDao;
import domain.Persona;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class ServicioPersonas {
    private PersonaDao personaDao;
    
    public ServicioPersonas(){
        this.personaDao = new PersonaDao();
    }
    
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }
}
