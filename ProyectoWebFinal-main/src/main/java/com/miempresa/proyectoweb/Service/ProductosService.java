package com.miempresa.proyectoweb.Service;

import com.miempresa.proyectoweb.Repository.ProductosRepository;
import com.miempresa.proyectoweb.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRepository repository;

    @Autowired
    public ProductosService(ProductosRepository repository) {
        this.repository = repository;
    }

    public void guardarProductos(Productos producto) {
        repository.save(producto);
    }

    public List<Productos> listarProductos() {
        return repository.findAll();
    }

    public void eliminarProducto(Long id) {
        repository.deleteById(id);
    }


}

