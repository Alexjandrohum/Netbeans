/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.List;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author alexjandrohum
 */
public interface UsuarioDAO {

    List<Usuario> findAllUsers();

    Usuario findUserById(Usuario user);

    Usuario findUserByUser(Usuario user);

    void insertUsuario(Usuario user);

    void updateUsuario(Usuario user);

    void deleteUsuario(Usuario user);
}
