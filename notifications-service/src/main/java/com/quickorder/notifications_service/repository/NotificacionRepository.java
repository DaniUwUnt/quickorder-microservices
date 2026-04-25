package com.quickorder.notifications_service.repository;

import com.quickorder.notifications_service.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}