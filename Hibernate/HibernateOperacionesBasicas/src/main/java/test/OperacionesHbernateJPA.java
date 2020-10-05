/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.PersonaDao;
import domain.Persona;

/**
 *
 * @author alexjandrohum
 */
public class OperacionesHbernateJPA {
    
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();
        personaDao.listar();
        //personaDao.insertar(new Persona("Jose", "Martinez", "jo@sad.com","354474"));
        //Persona persona = new Persona();
        //persona = personaDao.buscarPersonaById(new Persona(1));
        //System.out.println("Persona encontrada: "+persona);
        //persona.setNombre("Alex!");
        //personaDao.actualizar(persona);
        //personaDao.eliminar(new Persona(2));
        personaDao.listar();
        
    }
}
