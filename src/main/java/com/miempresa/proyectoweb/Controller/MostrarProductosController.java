package com.miempresa.proyectoweb.Controller;

import com.miempresa.proyectoweb.Service.ProductosService;
import com.miempresa.proyectoweb.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MostrarProductosController {
    private final ProductosService productosService;
    @Autowired
    public MostrarProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/productos")
    private String verFormularioYTable(Model model){
        /*List<Productos> listaProductos = Arrays.asList(
        );*/
        model.addAttribute("producto", new Productos());
        model.addAttribute("Productos", productosService.listarProductos());
        //model.addAttribute("productos", listaProductos);
        return "productos";
    }
    @PostMapping("/guardarProductos")
    public String guardarProductos(@ModelAttribute Productos producto){
        productosService.guardarProductos(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminarProducto")
    public String eliminarProducto(@RequestParam Long id){
        productosService.eliminarProducto(id);
        return "redirect:/productos";
    }

}
