/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.cliente;

import javax.naming.*;
import mx.com.sga.domain.Persona;
import mx.com.sga.service.PersonaServiceRemote;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PruebaManejoTransacciones {
    // java:global/sga-jee-web/PersonaDAOImpl

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            log.debug("Inicicando prueba manejo Transaccional PersonaService");
            
            //Buscamos una persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(1));
            
            log.debug("Persona recuperada: "+persona1);
            
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
}
