package com.miempresa.proyectoweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MostrarIndexController {

    @GetMapping("/index")

    private String mostrarIndex(){
        return "index";
    }
}
