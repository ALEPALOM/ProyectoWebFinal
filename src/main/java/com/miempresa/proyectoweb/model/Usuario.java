package com.miempresa.proyectoweb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id" ,nullable = false)
    private Persona persona;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "rol")
    private String rol;

    public Usuario() {
    }

    public Usuario(Persona persona, String username, String contraseña) {
        this.persona = persona;
        this.username = username;
        this.contraseña = contraseña;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}