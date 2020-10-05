/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Curso;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class CursoDao extends GenericDao {

    public CursoDao() {
        em = getEntityManager();
    }

    public List<Curso> listarCursos() {
        String hql = "SELECT c FROM Curso c";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void inserarCurso(Curso curso) {
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void actualizartCurso(Curso curso) {
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void eliminarCurso(Curso curso) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public Curso buscarCurso(Curso curso) {
        return em.find(Curso.class, curso.getIdCurso());
    }
}
