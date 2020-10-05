/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciclovida;

import domain.Contacto;
import javax.persistence.*;

/**
 *
 * @author alexjandrohum
 */
public class Estado1Persistido {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        // 1. Estado transitivo
        Contacto contactoDto = new Contacto();
        contactoDto.setEmail("maria@hamicl.com");
        contactoDto.setTelefono("876869");
        
        // 2. Persistimos el objeto
        em.getTransaction().begin();
        em.persist(contactoDto);
        //em.flush(); Es para sincronizar la información pero aún no se han guardado los cambios en la bd
        em.getTransaction().commit();
        
        // 3. detached
        System.out.println("Contacto: "+contactoDto);
    }
    
}
