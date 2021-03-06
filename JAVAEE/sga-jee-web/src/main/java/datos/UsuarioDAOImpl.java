/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author alexjandrohum
 */
@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

    @PersistenceContext(unitName = "PersonaPU")

    EntityManager em;

    @Override
    public List<Usuario> findAllUsers() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUserById(Usuario user) {
        return em.find(Usuario.class, user.getIdUsuario());
    }

    @Override
    public Usuario findUserByUser(Usuario user) {
        Query query = em.createQuery("from Usuario u where p.username =: username");
        query.setParameter("username", user.getUsername());

        return (Usuario) em.createNamedQuery("Usuario.findByUsername").getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario user) {
        em.persist(user);
    }

    @Override
    public void updateUsuario(Usuario user) {
        em.merge(user);
    }

    @Override
    public void deleteUsuario(Usuario user) {
        em.remove(em.merge(user));
    }

}
