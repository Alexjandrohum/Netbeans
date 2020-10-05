/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermen.SpringHello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexjandrohum
 */
@RestController
@Slf4j
public class ControladorInicio {

    @GetMapping("/hello")
    public String Iinicio() {
        log.info("ejecutando el controlador rest");
        return "Hola mundo con Spring 3";
    }
}
