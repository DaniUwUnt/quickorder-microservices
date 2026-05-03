package com.quickorder.orders_service.service;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductClient {

    private final WebClient webClient;

    public ProductClient() {
        this.webClient = WebClient.create("http://localhost:8082");
    }

    public String obtenerProductos() {
        return webClient.get()
                .uri("/productos")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}