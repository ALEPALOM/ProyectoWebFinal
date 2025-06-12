package com.miempresa.proyectoweb.Controller;

import com.miempresa.proyectoweb.model.Persona;

import com.miempresa.proyectoweb.model.dto.UsuarioDTO;

import com.miempresa.proyectoweb.Service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Listado de usuarios
    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        List<Persona> personas = usuarioService.listarPersonas();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("personas", personas);
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "usuarios";
    }

    // Guardar usuario (tanto nuevo como edición)
    @PostMapping("/guardarUsuario")
public String guardarUsuario(@ModelAttribute("usuarioDTO") UsuarioDTO usuarioDTO, Model model) {
    try {
        usuarioService.guardarUsuario(usuarioDTO);
        return "redirect:/usuarios";
    } catch (RuntimeException e) {
        // Error de validación: usuario duplicado
        model.addAttribute("error", e.getMessage());
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        model.addAttribute("personas", usuarioService.listarPersonas());
        return "usuarios";
    }
}

    // Editar usuario (cargar datos al formulario)
    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        UsuarioDTO usuarioDTO = usuarioService.buscarPorId(id);
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        List<Persona> personas = usuarioService.listarPersonas();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("personas", personas);
        model.addAttribute("usuarioDTO", usuarioDTO);
        return "usuarios";
    }

    // Eliminar usuario
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
}