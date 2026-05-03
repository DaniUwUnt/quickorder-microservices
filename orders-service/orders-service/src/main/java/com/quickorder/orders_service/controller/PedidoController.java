package com.quickorder.orders_service.controller;

import com.quickorder.orders_service.model.Pedido;
import com.quickorder.orders_service.service.PedidoService;
import com.quickorder.orders_service.service.UserClient;
import com.quickorder.orders_service.service.ProductClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @GetMapping
    public List<Pedido> listar() {
        logger.info("Solicitud recibida: listar todos los pedidos");
        return pedidoService.listar();
    }

    @PostMapping
    public Pedido guardar(@Valid @RequestBody Pedido pedido) {
        logger.info("Solicitud recibida: guardar pedido con información: {}", pedido.getInformacion());
        return pedidoService.guardar(pedido);
    }

    @GetMapping("/usuarios")
    public String obtenerUsuariosDesdeUsersService() {
        logger.info("Comunicación entre microservicios: orders-service llama a users-service");
        return userClient.obtenerUsuarios();
    }

    @GetMapping("/productos")
    public String obtenerProductosDesdeProductsService() {
        logger.info("Comunicación entre microservicios: orders-service llama a products-service");
        return productClient.obtenerProductos();
    }
}