/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclovida.jpa;

import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PersistirObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transacción
        
        
        //Paso 1. Crea nuevo objeto 
        //Objeto en estado transitivo
        
        Persona persona1 = new Persona("Alexjandrohum", "Hermen", "alex@gmail.com", "2492561035");
        
        // Paso 2. Inicializar la transacción
        tx.begin();
        
        //Paso 3. Ejecutamos el SQL
        em.persist(persona1);
        log.debug("Objetos persistido - aún sin commit "+persona1);
        
        //Paso 4. Commit / rollback
        tx.commit();
        
        //Objeto en estado detached
        log.debug("Objetos persistido - estado ditached "+persona1);
        
        //Cerramos el Entity Manager
        em.close();
    }
    
}
