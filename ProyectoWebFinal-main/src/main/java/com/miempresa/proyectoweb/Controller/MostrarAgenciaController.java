package com.miempresa.proyectoweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MostrarAgenciaController {

    @GetMapping("/agencia")

    private String mostrarAgencia(){
        return "agencia";

    }
}
