package com.quickorder.shipping_service.repository;

import com.quickorder.shipping_service.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}