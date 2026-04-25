package com.quickorder.inventory_service.model;

import jakarta.persistence.*;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producto;
    private int stock;

    public Inventario() {}

    public Long getId() { return id; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}