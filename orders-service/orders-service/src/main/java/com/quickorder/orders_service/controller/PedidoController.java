package com.quickorder.orders_service.controller;

import com.quickorder.orders_service.model.Pedido;
import com.quickorder.orders_service.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @PostMapping
    public Pedido guardar(@Valid @RequestBody Pedido pedido) {
        return pedidoService.guardar(pedido);
    }
}