/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public abstract class GenericDao {

    protected static EntityManagerFactory emf = null;
    protected static EntityManager em = null;
    protected static final String hql = "HibernateJpaPU";

    protected GenericDao() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(hql);
        }
    }

    protected static EntityManager getEntityManager() {
        if (em == null) {
            em = emf.createEntityManager();
        }

        return em;
    }
}
