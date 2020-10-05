/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.backing;

import beans.helper.ColoniaHelper;
import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author alexjandrohum
 */
@Named
@RequestScoped
public class VacanteForm {

    public VacanteForm() {
        log.info("Creando objeto VacanteForm");
    }

    @Inject
    private Candidato candidato;

    @Inject
    private ColoniaHelper coloniaHerlper;

    private boolean comentarioEnviado;
    Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String enviar() {
        if (this.candidato.getNombre().equals("Alex")) {
            if (candidato.getApellido().equals("Herrera")) {
                String msg = "Gracias, pero Alex Herrera ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }

    public void codigoPostalListener(ValueChangeEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        int nuevoCodigoPostal = ((Long) event.getNewValue()).intValue();
        UIInput coloniaInoutText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
        int coloniaId = this.coloniaHerlper.getColoniaByZipPostal(nuevoCodigoPostal);
        coloniaInoutText.setValue(coloniaId);
        coloniaInoutText.setSubmittedValue(coloniaId);

        UIInput ciudadUiInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String ciudad = "Mexico";
        ciudadUiInputText.setValue(ciudad);
        ciudadUiInputText.setSubmittedValue(ciudad);

        facesContext.renderResponse();
    }

    public void ocultarComentario(ActionEvent event) {
        this.comentarioEnviado = !this.comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public ColoniaHelper getColoniaHerlper() {
        return coloniaHerlper;
    }

    public void setColoniaHerlper(ColoniaHelper coloniaHerlper) {
        this.coloniaHerlper = coloniaHerlper;
    }

}
