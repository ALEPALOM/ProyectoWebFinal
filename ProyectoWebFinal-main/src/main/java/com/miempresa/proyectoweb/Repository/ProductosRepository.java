package com.miempresa.proyectoweb.Repository;

import com.miempresa.proyectoweb.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository <Productos, Long>{
}
