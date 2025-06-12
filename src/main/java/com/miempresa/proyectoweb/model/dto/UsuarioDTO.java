package com.miempresa.proyectoweb.model.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    private Long id;
    private Long idPersona;
    private String nombrePersona;
    

    @NotBlank(message = "El nombre de usuario es obligatorio.")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria.")
    private String contraseña;

    @NotBlank(message = "El rol es obligatorio.")
    private String rol;
    public UsuarioDTO() {
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}