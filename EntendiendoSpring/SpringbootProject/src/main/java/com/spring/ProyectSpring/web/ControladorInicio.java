/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.ProyectSpring.web;

import lombok.extern.slf4j.Slf4j;
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
    
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ejecutando un controlador Spring MVC");
        String saludar = "Hola buenas tardes";
        model.addAttribute("saludo", saludar);
        return "index";
    }
    
    @GetMapping("enteros")
    public String valor(){
        return "numeros";
    }

}
