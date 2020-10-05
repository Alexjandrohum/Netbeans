/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PruebaApiCriteria {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;

        //Query utilizando la APi de criteria
        //1. consulta de todos los registros
        // 1. EL objeto entity manayer crea una instancia Criteria Builder
        cb = em.getCriteriaBuilder();

        //2. Se crea un objeto de criteria Query
        criteriaQuery = cb.createQuery(Persona.class);

        //3. Crear el objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);

        //4.- Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);

        //5. Creamos el query typeSafe
        query = em.createQuery(criteriaQuery);

        //5. Ejecucón de la consulta
        personas = query.getResultList();

        //mostrarPersonas(personas);
        //2a. Consulta d ela persona con id = 1
        log.debug("\n 2-a Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idpersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        //log.debug(persona);

        //2-b Consulta de la persona con id = 1
        log.debug("\n 2-b Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);

        //La clase Predicate permite agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        //Verificamos si tenemos criterios por agregar
        Integer idPersonaParam = 3;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idpersona");
        criterios.add(cb.equal(fromPersona.get("idpersona"), parameter));

        //Agregamos los criterios
        if (criterios.isEmpty()) {
            throw new RuntimeException("Sin criterios");
        } else if (criterios.size() == 1) {
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }

        query = em.createQuery(criteriaQuery);
        query.setParameter("idpersona", idPersonaParam);
        
        //Se ejecuta el query
        persona = query.getSingleResult();
        log.debug(persona);

    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
}
