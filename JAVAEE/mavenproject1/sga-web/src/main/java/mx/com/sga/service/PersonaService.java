/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.service;

import java.util.List;
import javax.ejb.Local;
import mx.com.sga.domain.Persoma;

/**
 *
 * @author alexjandrohum
 */
@Local
public interface PersonaService {

    public List<Persoma> listarPersonas();

    public Persoma encontrarPersonaPorId(Persoma persona);

    public Persoma encontrarPersonaPorEmail(Persoma persona);

    public void registrarPErsona(Persoma persona);

    public void modificarPersona(Persoma persona);

    public void eliminarPersona(Persoma persona);
}
