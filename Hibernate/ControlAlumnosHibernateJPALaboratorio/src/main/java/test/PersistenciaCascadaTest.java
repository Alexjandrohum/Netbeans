/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AlumnoDao;
import domain.Alumno;
import domain.Contacto;
import domain.Domicilio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexjandrohum
 */
public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        AlumnoDao alumnoDao = new AlumnoDao();
        Domicilio domicilio = new Domicilio("Nirte 23", 23, "Puebla");
        Contacto contacto = new Contacto("5345", "3fdsfs");
        Alumno alumno = new Alumno("Marcos", "Mendoza", domicilio, contacto);
        alumnoDao.insertarAlumno(alumno);
        alumnoDao.insertarAlumno(new Alumno("","",domicilio, contacto));
    }
}
