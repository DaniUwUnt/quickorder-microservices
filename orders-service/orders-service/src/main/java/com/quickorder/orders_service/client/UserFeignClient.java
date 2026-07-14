package com.quickorder.orders_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users-service")
public interface UserFeignClient {

    @GetMapping("/api/users")
    String obtenerUsuarios();
}