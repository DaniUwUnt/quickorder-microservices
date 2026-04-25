package com.quickorder.shipping_service.service;

import com.quickorder.shipping_service.model.Envio;
import com.quickorder.shipping_service.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> listar() {
        return envioRepository.findAll();
    }

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }
}