package com.miempresa.proyectoweb.Repository;

import com.miempresa.proyectoweb.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface    PersonaRepository extends JpaRepository <Persona,Long >{
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id); //Les falto pasar el id
    Persona findByEmail(String email);
}
