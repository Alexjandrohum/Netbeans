/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Domicilio;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class DomicilioDao extends GenericDao {

    public List<Domicilio> listarDomicilio() {
        String hql = "SELECT p FROM Domicilio p";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void actualizarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void eliminarDomicilio(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Domicilio buscarDomicilio(Domicilio domicilio) {
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
}
