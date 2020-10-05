/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermen.SpringHello;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author alexjandrohum
 */
@Controller
@Slf4j
public class ControladorInicio {
    
    @Value("${index.saludo}")
    private String saludo;
    @GetMapping("/")
    public String Iinicio(Model model){
        String saludar = "Adios Mundo de Thymesealf";
        log.info("ejecutando el controlador MVC");
        Persona persona = new Persona();
        persona.setNombre("Alex");
        persona.setApellido("Hermen");
        persona.setEmail("alex@gamil.com");
        persona.setTelefono("2355");
        model.addAttribute("persona", persona);
        
        Persona persona2 = new Persona();
        persona2.setNombre("Maria");
        persona2.setApellido("MArtinez");
        persona2.setEmail("maria@gmail.com");
        persona2.setTelefono("249343256532");
        //List<Persona> personas = new ArrayList<>();
        List<Persona> personas = Arrays.asList(persona, persona2);
        
        //personas = null;
        model.addAttribute("saludar",saludar);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        return "index";
    }
}
