package mx.com.gm.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        List<Persona> personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String addPerson(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String savePerson(@Valid Persona persona, Errors errores) {
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editPerson(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String deletePerson(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}