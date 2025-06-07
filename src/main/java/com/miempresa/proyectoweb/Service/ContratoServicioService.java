package com.miempresa.proyectoweb.Service;

import com.miempresa.proyectoweb.Repository.ContratoServicioRepository;
import com.miempresa.proyectoweb.model.ContratoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoServicioService {
    private final ContratoServicioRepository repository;

    @Autowired
    public ContratoServicioService(ContratoServicioRepository repository) {
        this.repository = repository;
    }

    public void guardarContratoServicio(ContratoServicio contratoServicio){
        repository.save(contratoServicio);
    }

    public List<ContratoServicio> ListarContratosServicios(){
        return repository.findAll();
    }

    public void eliminarContratoServicio(Long id){
        repository.deleteById(id);
    }

    public ContratoServicio actualizarContratoServicio(long id, ContratoServicio datosActualizados){
        Optional<ContratoServicio> contratoServicioExistente = repository.findById(id);

        if (contratoServicioExistente.isPresent()){
            ContratoServicio contratoServicio = contratoServicioExistente.get();
            contratoServicio.setCliente(datosActualizados.getCliente());
            contratoServicio.setCont_mes(datosActualizados.getCont_mes());
            contratoServicio.setPrecio(datosActualizados.getPrecio());
            return repository.save(contratoServicio);
        } else {
            throw new RuntimeException("Contrato de servicio no encontrado" + id);
        }
    }
}
