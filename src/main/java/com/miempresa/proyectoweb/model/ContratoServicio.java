package com.miempresa.proyectoweb.model;

import jakarta.persistence.*;

@Entity
public class ContratoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ContactanosRegistro cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto = new Productos();

    private  String cont_mes;
    private double precio;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactanosRegistro getCliente() {
        return cliente;
    }

    public void setCliente(ContactanosRegistro cliente) {
        this.cliente = cliente;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public String getCont_mes() {
        return cont_mes;
    }

    public void setCont_mes(String cont_mes) {
        this.cont_mes = cont_mes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
