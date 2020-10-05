/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PruebaJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query query = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();

        // 1.- Consultar todos los objetos de tipo persona
        log.debug("\n1. Consulta de todas las personas");
        jpql = "select p from Persona p";
        //personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        //2. Consutlta de la persona por id
        log.debug("\n2. Consulta de la persona id = 1");
        jpql = "select p from Persona p where p.idpersona = 1";

        //persona = (Persona) em.createQuery(jpql).getSingleResult();
        //log.debug(persona);
        //3. Consulta de l apersona filtrando por nombre
        log.debug("\n3. Consulta de persona filtrando por nombre");
        jpql = "select p from Persona p where p.nombre = 'Alexjandrohum'";
        //personas = em.createQuery(jpql).getResultList();
        //log.debug(personas);

        //4. Consulta de tuplas
        //son consultas individuales de tipo tupla 
        log.debug("\n4. Consulta con tuplas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //log.debug(nombre + " "+apellido + " " +email);
        }

        //5. Obtiene el objeto de el id
        log.debug("\n 5. Obtiene el objeto por id");
        jpql = "select p, p.idpersona from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            //log.debug("Objeto poersona: "+persona );
            //log.debug("Id persona: "+idPersona);
        }

        log.debug("\n Consulta no. 6 para obtener un parametro id solamente de Persona");
        jpql = "select new mx.com.gm.sga.domain.Persona(p.idpersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);

        log.debug("\n7.Regres Regresa el valor minimo y maximo de idPersona");
        jpql = "select min(p.idpersona) as Minimos, max(p.idpersona) as Maximos, count(p.idpersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while (iter.hasNext()) {
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long contador = (Long) tupla[2];
            //log.debug("IdMin: "+idMin+ " IdMax: "+idMax+ " Contador: "+contador);

        }
        log.debug("\n 8. Cuenta los nombres de las personas que son distinto");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //log.debug("No. de personas con nombre distinto: "+contador);

        log.debug("\n 9. Concatena y convierte mayusculas el nombre y apellido");
        jpql = "select CONCAT(p.nombre, ' ',p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for (String nombreCompleto : nombres) {
            // log.debug(nombreCompleto);
        }

        log.debug("\n 10. Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 3;
        jpql = "select p from Persona p where p.idpersona = :id";
        query = em.createQuery(jpql);
        query.setParameter("id", idPersona);

        persona = (Persona) query.getSingleResult();
        //log.debug("Persona por id: "+persona);

        log.debug("\n11. Contiene las personas que contengas una letra sin importar si es Mayuscula o minuscula");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%o%";//es el caracter que utilizamos para la sentencia like
        query = em.createQuery(jpql);
        query.setParameter("parametro", parametro);
        personas = query.getResultList();
        //mostrarPersonas(personas);

        log.debug("\n12. Uso de Between");

        jpql = "select p from Persona p where p.idpersona between 1 and 3";
        personas = em.createQuery(jpql).getResultList();
        //log.debug("Listado de personas entre un rango: "+personas);

        log.debug("\n 13. Uso del ordenamiento");
        jpql = "select p from Persona p where p.idpersona >1 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        //log.debug("Uso de ordenamiento: " + personas);
        
        log.debug("\n 14. Uso de subqueries");
        jpql = "select p from Persona p where p.idpersona in (select min (p1.idpersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        log.debug("\n 15. Uso de Join con lazy loading");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        log.debug("\n 16. Uso de left join con eager loading");
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            log.debug(persona);
        }
    }
    
    private static void mostrarUsuarios(List<Usuario> usuarios){
        for(Usuario usuario : usuarios){
            log.debug(usuario);
        }
    }

}