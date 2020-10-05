/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import domain.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;
import servicio.PersonaServiceRemote;

/**
 *
 * @author alexjandrohum
 */
public class ClientePersonaService {

    public static void main(String[] args) {

        System.out.println("Inciando llamada al JB desde el cliente");

        String authFile = "login.conf";
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin programaticLogin = new ProgrammaticLogin();
        programaticLogin.login("admin", "admin".toCharArray());
        
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            for(Persona persona : personas){
                System.out.println("Persona: "+persona);
            }
            System.out.println("Fin de la llamada al JB desde el cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
