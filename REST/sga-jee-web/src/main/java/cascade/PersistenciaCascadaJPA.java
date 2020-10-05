/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ex = em.getTransaction();
        ex.begin();
        
        //Paso 1. crear un objeto
        
        Persona persona1 = new Persona("Pedro", "Sanchez", "as@sad", "435");
        Usuario usuario1 = new Usuario("pedro", "pedro", persona1);
        
        //Persistencia 
        em.persist(usuario1);
        
        //Commit
        ex.commit();
        
        log.debug("Objeto persistido Persona: "+persona1);
        log.debug("Objeto persistido Usuario: "+usuario1);
        
        em.close();
        
    }
    
}
