/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.apache.logging.log4j.*;

/**
 *
 * @author alexjandrohum
 */
public class HolaMundoAcction {
    
    Logger log = LogManager.getLogger(HolaMundoAcction.class);
    private String saludosAtr;
    
    public String execute(){
        log.info("Ejecutando metodo execute desde Struts2");
        this.saludosAtr = "Adios desde Struts2";
        return "exito";
    }

    public String getSaludosAtr() {
        return saludosAtr;
    }

    public void setSaludosAtr(String saludosAtr) {
        this.saludosAtr = saludosAtr;
    }
    
    
    
}
