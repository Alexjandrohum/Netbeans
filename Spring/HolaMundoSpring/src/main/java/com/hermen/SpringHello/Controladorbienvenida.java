/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hermen.SpringHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexjandrohum
 */
@RestController
public class Controladorbienvenida {

    @GetMapping("/")
    public String defaultPagina() {
        return "Default pagina de Spring";
    }
}
