package com.miempresa.proyectoweb.Controller;

import com.miempresa.proyectoweb.Service.ContactanosService;
import com.miempresa.proyectoweb.Service.ContratoServicioService;
import com.miempresa.proyectoweb.Service.ProductosService;

import com.miempresa.proyectoweb.model.ContratoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContratoServicioRegistroController {
    private final ContratoServicioService contratoServicioService;
    @Autowired
    private ContactanosService contactanosService;
    @Autowired
    private ProductosService productosService;
    @Autowired
    public ContratoServicioRegistroController(ContratoServicioService contratoServicioService) {
        this.contratoServicioService = contratoServicioService;
    }


    @GetMapping("/contratosservicios")
    public String verFormularioYTabla(Model model) {
        model.addAttribute("registrocontratoservicio", new ContratoServicio());
        model.addAttribute("registroscontrastosservicios", contratoServicioService.ListarContratosServicios());
        model.addAttribute("clientes", contactanosService.listarContactos());
        model.addAttribute("productos", productosService.listarProductos());
        return "contratosservicios";
    }
    @PostMapping("/guardarContratoServicio")
    public String guardarContratoServicio(@ModelAttribute ContratoServicio registrocontratoservicio){
        contratoServicioService.guardarContratoServicio(registrocontratoservicio);
        return "redirect:/contratosservicios";
    }

    @GetMapping("/eliminarContratoServicio")
    public String eliminarContratoServicio(@RequestParam Long id){
        contratoServicioService.eliminarContratoServicio(id);
        return "redirect:/contratosservicios";
    }

}
