/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author alexjandrohum
 */
public class LoginAction extends ActionSupport{
    private String user;
    private String pass;
    
    public String execute(){
        return SUCCESS;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public String getUsuario(){
        return getText("form.usuario");
    }
    public String getPassword(){
        return getText("form.password");
    }
    
    public String getBoton(){
        return getText("form.boton");
    }
    
    public String getTitulo(){
        return getText("form.titulo");
    }
    
    public String getValores(){
        return getText("form.valores");
    }
}
