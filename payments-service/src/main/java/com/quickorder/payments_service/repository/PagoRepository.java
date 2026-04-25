package com.quickorder.payments_service.repository;

import com.quickorder.payments_service.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}