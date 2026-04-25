package com.quickorder.notifications_service.service;

import com.quickorder.notifications_service.model.Notificacion;
import com.quickorder.notifications_service.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> listar() {
        return repository.findAll();
    }

    public Notificacion guardar(Notificacion n) {
        return repository.save(n);
    }
}