package com.miempresa.proyectoweb.Controller;

import com.miempresa.proyectoweb.Service.ContactanosService;
import com.miempresa.proyectoweb.model.ContactanosRegistro;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ContactanosRegistroController {
   //List<ContactanosRegistro> registros = new ArrayList<>();
    private final ContactanosService contactanosService;

    @Autowired
    public ContactanosRegistroController(ContactanosService contactanosService){
        this.contactanosService = contactanosService;
    }

    @GetMapping("/contactanos")
    public String verFormularioYTabla(Model model) {
        model.addAttribute("registro", new ContactanosRegistro());
        model.addAttribute("registros", contactanosService.listarContactos());
        return "contactanos";
    }

    @PostMapping("/guardarContactos")
    public String guardarContactos(@ModelAttribute ContactanosRegistro registro){
        contactanosService.guardarContactos(registro);
        return "redirect:/contactanos";
    }

   /* @GetMapping("/listaContactanos")
    public String mostrarTabla(Model model){
        model.addAttribute("registros", contactanosService.listarContactos());
        return "contactanos";
    }*/

    @GetMapping("/eliminar")
    public String eliminarContacto(@RequestParam Long id, Model model){
        try {
            contactanosService.eliminarContacto(id);
            return "redirect:/contactanos";
        } catch (RuntimeException e) {
            model.addAttribute("errorMensaje", e.getMessage());
            model.addAttribute("registro", new ContactanosRegistro());
            model.addAttribute("registros", contactanosService.listarContactos());
            return "contactanos";
        }


    }
}
