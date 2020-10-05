/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Contacto;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class ContactoDao extends GenericDao {

    public ContactoDao() {
        em = getEntityManager();
    }

    public List<Contacto> listarContacto() {
        String hql = "SELECT c FROM Contacto c";
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertarContacto(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void actualizarContacto(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void eliminarContacto(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public Contacto buscarContacto(Contacto contacto) {
        return em.find(Contacto.class, contacto.getIdContacto());
    }
}
