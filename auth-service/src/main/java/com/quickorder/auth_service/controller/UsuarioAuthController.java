package com.quickorder.auth_service.controller;

import com.quickorder.auth_service.model.UsuarioAuth;
import com.quickorder.auth_service.service.UsuarioAuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UsuarioAuthController {

    private final UsuarioAuthService service;

    public UsuarioAuthController(UsuarioAuthService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioAuth> listar() {
        return service.listar();
    }

    @PostMapping("/register")
    public UsuarioAuth registrar(@RequestBody UsuarioAuth user) {
        return service.guardar(user);
    }
}