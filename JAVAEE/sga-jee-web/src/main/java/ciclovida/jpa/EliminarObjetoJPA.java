/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclovida.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alexjandrohum
 */
public class EliminarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transacción
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //PAso 2. Ejecutar SQl de tipo select
        //El id proporcionado debe de exixtir en la bd
        Persona persona1 = em.find(Persona.class, 2);
        

        //Paso 3. Termina la transaccion 1
        tx.commit();

        //Objeto Persona1 en estado de detached
        log.debug("Objeto persona1 Recuperado en estado detached: " + persona1);

        //Paso 5. Transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        //Paso 6. actualizar registro
        em.remove(em.merge(persona1));

        //Paso 7. Termina la transaccion 2
        tx2.commit();

        //Objeto persona1 pasa a detached
        log.debug("Objeto detached: " + persona1);

        //Cerramos el Entity Manager
        em.close();
    }

}
