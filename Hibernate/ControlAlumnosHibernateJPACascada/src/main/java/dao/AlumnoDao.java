/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Alumno;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class AlumnoDao extends GenericDao {

    public List<Alumno> listarAlumnos() {
        String hql = "SELECT a FROM Alumno a";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertarAlumno(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void actualizarAlumno(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
}
