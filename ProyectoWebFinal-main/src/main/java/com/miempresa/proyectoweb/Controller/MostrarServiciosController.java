package com.miempresa.proyectoweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MostrarServiciosController {

    @GetMapping("/servicios")

    private String mostrarServivios(){
        return "servicios";
    }
}
