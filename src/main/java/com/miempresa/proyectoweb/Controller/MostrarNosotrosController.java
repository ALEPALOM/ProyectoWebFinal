package com.miempresa.proyectoweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MostrarNosotrosController {

    @GetMapping("/nosotros")
    private String mostrarNosotros(){
        return "nosotros";
    }
}
