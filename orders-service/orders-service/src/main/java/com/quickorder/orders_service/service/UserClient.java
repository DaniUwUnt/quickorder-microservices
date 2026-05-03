package com.quickorder.orders_service.service;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class UserClient {

    private final WebClient webClient;

    public UserClient() {
        this.webClient = WebClient.create("http://localhost:8081");
    }

    public String obtenerUsuarios() {
        return webClient.get()
                .uri("/api/users")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}