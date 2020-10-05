/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AlumnoDao;
import dao.AsignacionDao;
import dao.ContactoDao;
import dao.CursoDao;
import dao.DomicilioDao;
import domain.Alumno;
import domain.Asignacion;
import domain.Contacto;
import domain.Curso;
import domain.Domicilio;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class Test {

    public static void main(String[] args) {
        //testDomicilio();
        testContacto();
        //testCurso();
        //testAlumno();
        //testAsignacion();
    }

    public static void testDomicilio() {
        DomicilioDao domicilioDao = new DomicilioDao();
        List<Domicilio> domicilios;
        Domicilio domicilioDto;
        domicilioDao.insertarDomicilio(new Domicilio("Sur 45", 345, "Puebla"));
        //domicilioDto = domicilioDao.buscarDomicilio(new Domicilio(4));
        //System.out.println("Domicilio encontrado: "+domicilioDto);
        //domicilioDto.setPais("Mexico");
        //domicilioDao.actualizarDomicilio(domicilioDto);
        //domicilioDao.eliminarDomicilio(new Domicilio(3));
        listar(domicilioDao.listarDomicilio());
    }

    public static void testContacto() {
        ContactoDao contactoDao = new ContactoDao();
        List<Contacto> contactos;
        Contacto contactoDto;
        //contactoDao.insertarContacto(new Contacto("249375575", "juan@gmail.com"));
        //contactoDto = contactoDao.buscarContacto(new Contacto(4));
        //System.out.println("Contacto enconytrado: " + contactoDto);
        //contactoDto.setEmail("alexjandrohum@gmail.com");
        //contactoDao.actualizarContacto(contactoDto);
        //contactoDao.eliminarContacto(contactoDto);
        listar(contactoDao.listarContacto());
    }

    public static void testCurso() {
        CursoDao cursoDao = new CursoDao();
        List<Curso> cursos;
        Curso cursoDto;

        cursoDto = cursoDao.buscarCurso(new Curso(6));
        System.out.println("Curso encontrado: " + cursoDto);
        /*cursoDao.inserarCurso(new Curso("Redes",2900));
        cursoDao.inserarCurso(new Curso("Videojuegos",1300));
        cursoDao.inserarCurso(new Curso("Calculo",30000));*/
        //cursoDto.setPrecio(2800);
        //cursoDao.actualizartCurso(cursoDto);
        cursoDao.eliminarCurso(cursoDto);
        listar(cursoDao.listarCursos());
    }

    public static void testAlumno() {
        AlumnoDao alumnoDao = new AlumnoDao();
        DomicilioDao domicilioDao = new DomicilioDao();
        ContactoDao contactoDao = new ContactoDao();
        List<Alumno> alumnos = null;
        Alumno alumnoDto = null;
        Domicilio domicilioDto = null;
        Contacto contactoDto = null;

        /*domicilioDto = domicilioDao.buscarDomicilio(new Domicilio(1));
        System.out.println("Domicilio encontrado: "+domicilioDto);
        contactoDto = contactoDao.buscarContacto(new Contacto(1));
        System.out.println("Contacto encontrado: "+contactoDto);*/
        //alumnoDao.insertarAlumno(new Alumno("Citlali","Castro",domicilioDto, contactoDto));
        alumnoDto = alumnoDao.buscarAlumno(new Alumno(3));
        System.out.println("Alumno encontrado: " + alumnoDto);
        //alumnoDto.setApellido("Castro Aguilar");
        //alumnoDao.actualizarAlumno(alumnoDto);
        alumnoDao.eliminarAlumno(alumnoDto);

        alumnos = alumnoDao.listarAlumnos();
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno);
        }
    }

    public static void testAsignacion() {
        AsignacionDao asignacionDao = new AsignacionDao();
        AlumnoDao alumnoDao = new AlumnoDao();
        CursoDao cursoDao = new CursoDao();
        List<Asignacion> asignaciones = null;
        Asignacion asignacionDto = null;
        Alumno alumnoDto = null;
        Curso cursoDto = null;

        //alumnoDto = alumnoDao.buscarAlumno(new Alumno(4));
        //System.out.println("Alumno encontrado "+alumnoDto);
        //cursoDto = cursoDao.buscarCurso(new Curso(3));
        //System.out.println("Curso encontrado: "+cursoDto);
        //alumnoDto.setNombre("Cinthya");
        //alumnoDao.actualizarAlumno(alumnoDto);
        //asignacionDao.insertarAsignacion(new Asignacion("vespertino",alumnoDto, cursoDto));
        asignacionDto = asignacionDao.buscarAsignacion(new Asignacion(2));
        System.out.println("Asignacion encontrada: " + asignacionDto);
        //asignacionDto.setTurno("Matutino");
        //asignacionDto.setAlumno(alumnoDto);
        //asignacionDao.actualizarAsignacion(asignacionDto);
        asignacionDao.eliminarAsignacion(asignacionDto);

        asignaciones = asignacionDao.listarAsignaciones();
        for (Asignacion asignacion : asignaciones) {
            System.out.println("Asignacion: " + asignacion);
        }
    }
    
    public static void listar(List colecciones){
        for(Object o : colecciones){
            System.out.println(" Objeto: "+o);
        }
    }
}
