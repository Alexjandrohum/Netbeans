/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asociaciones;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class ClienteAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //Cerramos la conexion
        em.close();
        
        //Implimir el listado de personas
        for(Persona persona : personas){
            log.debug("Persona: "+persona);
            //Recuperamos los usuarios de cada persona
            for(Usuario usuario : persona.getUsuarioList()){
                log.debug("Usuario: "+usuario);
            }
        }
    }
    
}
