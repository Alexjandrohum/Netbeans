/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author alexjandrohum
 */
public interface UsuarioService {

    List<Usuario> listaUsuario();

    Usuario buscarUsarioPorId(Usuario usuario);

    Usuario buscarUsuarioPorEmail(Usuario usuario);

    void insertarUauario(Usuario usuario);

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(Usuario usuario);

}
