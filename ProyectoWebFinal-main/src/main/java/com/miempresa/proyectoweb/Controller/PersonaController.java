package com.miempresa.proyectoweb.Controller;


import com.miempresa.proyectoweb.Service.PersonaService;
import com.miempresa.proyectoweb.model.Persona;
import com.miempresa.proyectoweb.model.dto.PersonaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }

    @GetMapping("/persona")
    public String verFormularioYTabla(Model model) {
        model.addAttribute("personaDTO", new PersonaDTO());
        model.addAttribute("personas", personaService.listarPersona());
        return "persona";
    }

    @PostMapping("/guardarPersona")
    public String guardarPersona(@Valid @ModelAttribute("personaDTO") PersonaDTO personaDTO, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("personas", personaService.listarPersona());
            return "persona";
        }

        Persona persona = new Persona();
        persona.setId(personaDTO.getId()); // pasar el ID
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(personaDTO.getDni());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEmail(personaDTO.getEmail());

        personaService.guardarPersona(persona);
        return "redirect:/persona";
    }

    @GetMapping("/eliminarPersona")
    public String eliminarPersona(@RequestParam Long id){
        personaService.eliminarPersona(id);
        return "redirect:/persona";
    }


    @GetMapping("/editarPersona")
    public String mostrarFormularioEditar(@RequestParam Long id, Model model) {
        Persona persona = personaService.obtenerPersonaId(id);
        if (persona == null) {
            return "redirect:/persona";// Redirige si no existe
        }

        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setDni(persona.getDni());
        dto.setTelefono(persona.getTelefono());
        dto.setEmail(persona.getEmail());

        model.addAttribute("personaDTO", dto); // Usa personaDTO
        model.addAttribute("personas", personaService.listarPersona()); // también carga la tabla
        return "persona";
    }
}
