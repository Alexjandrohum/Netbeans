/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermen.SpringHello.web;

import com.hermen.SpringHello.PersonaDao;
import com.hermen.domain.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
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
    
    @Autowired(required = true)
    //private PersonaDao personaDao;
    
    @GetMapping("/")
    public String Inicio(Model model){
        
        //Iterable<Persona> personas;
        //personas = personaDao.findAll();
        
        log.info("ejecutando el controlador MVC");
        //model.addAttribute("personas", personas);
        return "index";
    }
}
