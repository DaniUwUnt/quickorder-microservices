package com.quickorder.auth_service.repository;

import com.quickorder.auth_service.model.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Long> {
}