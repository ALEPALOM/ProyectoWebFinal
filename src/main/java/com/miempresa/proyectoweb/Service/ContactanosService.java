package com.miempresa.proyectoweb.Service;

import com.miempresa.proyectoweb.Repository.ContactanosRegistroRepository;
import com.miempresa.proyectoweb.model.ContactanosRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactanosService {
    private final ContactanosRegistroRepository repository;

    @Autowired
    public ContactanosService(ContactanosRegistroRepository repository){
        this.repository = repository;
    }

    public void guardarContactos(ContactanosRegistro contacto){
        repository.save(contacto);
    }
    public List<ContactanosRegistro> listarContactos(){
        return repository.findAll();
    }
    public void eliminarContacto(Long id){
        repository.deleteById(id);
    }
}
