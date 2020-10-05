/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Persona;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class HolaMundoHibernate {

    public static void main(String[] args) {
        String hql = "SELECT p FROM Persona p";
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateHola");
        EntityManager entityManager = fabrica.createEntityManager();

        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();

        for (Persona persona : personas) {
            System.out.println("Persona: " + persona);
        }

    }
}
