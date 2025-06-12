package com.miempresa.proyectoweb.Service;

import com.miempresa.proyectoweb.Repository.PersonaRepository;
import com.miempresa.proyectoweb.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository repository;

    @Autowired
    public PersonaService(PersonaRepository repository){this.repository = repository;}

    public void guardarPersona(Persona persona){
        repository.save(persona);
    }
    public List<Persona> listarPersona(){
        return repository.findAll();
    }
    public void eliminarPersona(Long id){
        repository.deleteById(id);
    }
    public Persona obtenerPersonaId(Long id) {
        return repository.findById(id).orElse(null);
    }

}
