package com.miempresa.proyectoweb.Validation;


import com.miempresa.proyectoweb.Repository.PersonaRepository;
import com.miempresa.proyectoweb.model.dto.PersonaDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, PersonaDTO> {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public boolean isValid(PersonaDTO dto, ConstraintValidatorContext context) { //falto agregar tu TDO que creaste ya que se trabajara con clase Persona DTO que crearon ustedes
        if (dto.getEmail() == null || dto.getEmail().isEmpty()){
            return true; // No validara nada si el email esta vacio
        }


        // Si está editando (tiene ID), excluye su propio registro
        if (dto.getId() !=null){
            return !personaRepository.existsByEmailAndIdNot(dto.getEmail(), dto.getId());
        }

        // Si es nuevo, valida que no exista el email
        return !personaRepository.existsByEmail(dto.getEmail());
    }
}