package com.miempresa.proyectoweb.Service;

import com.miempresa.proyectoweb.Repository.ContactanosRegistroRepository;
import com.miempresa.proyectoweb.Repository.ContratoServicioRepository;
import com.miempresa.proyectoweb.model.ContactanosRegistro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactanosService {
    private final ContactanosRegistroRepository repository;
    private final ContratoServicioRepository contratoServicioRepository;

    @Autowired
    public ContactanosService(ContactanosRegistroRepository repository,ContratoServicioRepository contratoServicioRepository){
        this.repository = repository;
        this.contratoServicioRepository = contratoServicioRepository;
    }

    public void guardarContactos(ContactanosRegistro contacto){
        repository.save(contacto);
    }
    public List<ContactanosRegistro> listarContactos(){
        return repository.findAll();
    }

    @Transactional
    public void eliminarContacto(Long id){
        boolean tieneContratos = contratoServicioRepository.existsByClienteId(id);
        if(tieneContratos){
            throw new RuntimeException("No se puede eliminar el contacto porque tiene contratos asociados");
        }
        repository.deleteById(id);
    }
}
