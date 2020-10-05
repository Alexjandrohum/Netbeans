/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import dao.AlumnoDao;
import domain.Alumno;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public class ServicioAlumno {

    private AlumnoDao alumnoDao = new AlumnoDao();

    public List<Alumno> listarAlumnos() {
        return alumnoDao.listarAlumnos();
    }

    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDao.insertarAlumno(alumno);
        } else{
            alumnoDao.actualizarAlumno(alumno);
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnoDao.eliminarAlumno(alumno);
    }

    public Alumno buscarAlumno(Alumno alumno) {
        return alumnoDao.buscarAlumno(alumno);
    }
}
