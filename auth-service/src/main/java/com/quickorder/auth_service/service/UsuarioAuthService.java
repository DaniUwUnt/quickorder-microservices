package com.quickorder.auth_service.service;

import com.quickorder.auth_service.model.UsuarioAuth;
import com.quickorder.auth_service.repository.UsuarioAuthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioAuthService {

    private final UsuarioAuthRepository repository;

    public UsuarioAuthService(UsuarioAuthRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioAuth> listar() {
        return repository.findAll();
    }

    public UsuarioAuth guardar(UsuarioAuth user) {
        return repository.save(user);
    }
}