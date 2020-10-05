/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author alexjandrohum
 */
@Results({
    @Result(name="success", location="/WEB-INF/content/bienvenido.jsp"),
    @Result(name="input", location="/WEB-INF/content/login.jsp")
})
public class ValidarUsuarioAction extends ActionSupport {

    private String user;
    private String pass;

    @Action("validarUsuario")
    public String execute() {
        if ("admin".equals(this.user)) {
            addActionMessage(getText("usuario.valido"));
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
    
    @Override
    public void validate(){
        if(this.user.equals("") || this.user == null){
            addFieldError("user", getText("val.usuario"));
        }else if(!usuarioValido()){
            addActionError(getText("usuario.invalido"));
        }
        
        if(this.pass.equals("") || this.pass == null){
            addFieldError("pass", getText("val.pass"));
        }else if(this.pass.length() < 3){
            addFieldError("pass", getText("val.pass.min.length"));
        }
    }
    
    private boolean usuarioValido(){
        return "admin".equals(this.user);
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
}
