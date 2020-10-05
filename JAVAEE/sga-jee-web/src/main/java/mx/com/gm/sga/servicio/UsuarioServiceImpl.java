/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import datos.UsuarioDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author alexjandrohum
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
    @Inject UsuarioDAO usuarioDao;

    @Override
    public List<Usuario> listaUsuario() {
        return usuarioDao.findAllUsers();
    }

    @Override
    public Usuario buscarUsarioPorId(Usuario usuario) {
        return usuarioDao.findUserById(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(Usuario usuario) {
        return usuarioDao.findUserByUser(usuario);
    }

    @Override
    public void insertarUauario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
