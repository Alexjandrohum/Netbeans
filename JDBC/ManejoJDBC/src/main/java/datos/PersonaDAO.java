/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexjandrohum
 */
public interface PersonaDAO {

    int insert(PersonaDTO persona) throws SQLException;

    int update(PersonaDTO persona) throws SQLException;

    int delete(PersonaDTO persona) throws SQLException;

    List<PersonaDTO> select() throws SQLException;

}
