package com.quickorder.products_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quickorder.products_service.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}