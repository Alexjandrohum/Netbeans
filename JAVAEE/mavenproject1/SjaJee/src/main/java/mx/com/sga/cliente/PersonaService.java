/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.sga.cliente;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;

/**
 *
 * @author alexjandrohum
 */
public class PersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al JB desde el cliente");
        try {
            Context jndi = new InitialContext();
        } catch (NamingException ex) {
            ex.printStackTrace(System.out );
        }
    }
}
