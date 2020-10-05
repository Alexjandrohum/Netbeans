/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Asignacion;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class AsignacionDao extends GenericDao {

    public AsignacionDao() {
        em = getEntityManager();
    }

    public List<Asignacion> listarAsignaciones() {
        String hql = "SELECT a FROM Asignacion a";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertarAsignacion(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void actualizarAsignacion(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void eliminarAsignacion(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public Asignacion buscarAsignacion(Asignacion asignacion) {
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }
}
