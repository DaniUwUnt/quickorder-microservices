package com.quickorder.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quickorder.inventory_service.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}