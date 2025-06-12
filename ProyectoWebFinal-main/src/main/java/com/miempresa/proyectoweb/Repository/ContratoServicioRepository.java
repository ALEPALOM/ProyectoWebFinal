package com.miempresa.proyectoweb.Repository;

import com.miempresa.proyectoweb.model.ContratoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoServicioRepository extends JpaRepository <ContratoServicio, Long >{
    boolean existsByClienteId(Long clienteId);
}
