package com.quickorder.orders_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-service", url = "http://localhost:8082")
public interface ProductFeignClient {

    @GetMapping("/productos")
    String obtenerProductos();
}