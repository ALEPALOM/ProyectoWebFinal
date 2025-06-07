package com.miempresa.proyectoweb.Repository;

import com.miempresa.proyectoweb.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository <Persona,Long >{
    Persona findByEmail(String email);
}
