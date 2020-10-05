/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import model.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class PersonasAction extends ActionSupport {

    Logger log = LogManager.getLogger(PersonasAction.class);

    private Persona persona;

    @Override
    public String execute() {
        if (persona != null) {
            log.info("\n");
            log.info("Persona: " + persona);
        } else {
            log.info("Persona con valor null");
        }
        return SUCCESS;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
