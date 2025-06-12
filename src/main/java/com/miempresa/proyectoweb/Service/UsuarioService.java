package com.miempresa.proyectoweb.Service;
import com.miempresa.proyectoweb.Service.UsuarioService;
import com.miempresa.proyectoweb.Repository.PersonaRepository;
import com.miempresa.proyectoweb.Repository.UsuarioRepository;
import com.miempresa.proyectoweb.model.Persona;
import com.miempresa.proyectoweb.model.Usuario;
import com.miempresa.proyectoweb.model.dto.UsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public UsuarioDTO buscarPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        return usuarioOpt.map(this::convertirADTO).orElse(null);
    }

    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        if (usuarioDTO.getId() != null) {
            usuario = usuarioRepository.findById(usuarioDTO.getId()).orElse(new Usuario());
        }

        if (usuarioDTO.getIdPersona() == null) {
            throw new IllegalArgumentException("Debe seleccionar una persona");
        }

        Persona persona = personaRepository.findById(usuarioDTO.getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        usuario.setPersona(persona);
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setContraseña(usuarioDTO.getContraseña());
        usuario.setRol(usuarioDTO.getRol());

        usuarioRepository.save(usuario);
        
        Usuario existente = usuarioRepository.findByUsername(usuarioDTO.getUsername());
        if (existente != null) {
            // Si estamos editando, permitimos el mismo username si es del mismo ID
            if (usuarioDTO.getId() == null || !existente.getId().equals(usuarioDTO.getId())) {
                throw new RuntimeException("Usuario creado correctamente");
            }
        }
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setIdPersona(usuario.getPersona().getId());
        dto.setNombrePersona(usuario.getPersona().getNombre() + " " + usuario.getPersona().getApellido());
        dto.setUsername(usuario.getUsername());
        dto.setContraseña(usuario.getContraseña());
        dto.setRol(usuario.getRol());
        return dto;
    }
}