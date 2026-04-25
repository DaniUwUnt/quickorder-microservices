package com.quickorder.notifications_service.controller;

import com.quickorder.notifications_service.model.Notificacion;
import com.quickorder.notifications_service.service.NotificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacion> listar() {
        return service.listar();
    }

    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion n) {
        return service.guardar(n);
    }
}