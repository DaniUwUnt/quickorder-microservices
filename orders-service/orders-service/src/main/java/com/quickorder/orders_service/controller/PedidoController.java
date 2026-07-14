package com.quickorder.orders_service.controller;

import com.quickorder.orders_service.client.ProductFeignClient;
import com.quickorder.orders_service.client.UserFeignClient;
import com.quickorder.orders_service.model.Pedido;
import com.quickorder.orders_service.service.PedidoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        logger.info("Solicitud recibida: listar todos los pedidos");
        return ResponseEntity.ok(pedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        logger.info("Solicitud recibida: buscar pedido por ID {}", id);

        return pedidoService.buscarPorId(id)
                .map(pedido -> {
                    EntityModel<Pedido> recurso = EntityModel.of(pedido);

                    recurso.add(
                            linkTo(methodOn(PedidoController.class).buscarPorId(id))
                                    .withSelfRel()
                    );

                    recurso.add(
                            linkTo(methodOn(PedidoController.class).listar())
                                    .withRel("pedidos")
                    );

                    return ResponseEntity.ok(recurso);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> guardar(@Valid @RequestBody Pedido pedido) {
        logger.info("Solicitud recibida: guardar nuevo pedido");
        Pedido pedidoGuardado = pedidoService.guardar(pedido);
        return ResponseEntity.status(201).body(pedidoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id,
                                             @Valid @RequestBody Pedido pedido) {

        logger.info("Solicitud recibida: actualizar pedido {}", id);

        Pedido actualizado = pedidoService.actualizar(id, pedido);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        logger.info("Solicitud recibida: eliminar pedido {}", id);

        if (pedidoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        pedidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuarios")
    public String obtenerUsuariosDesdeUsersService() {
        logger.info("Orders Service consulta Users Service mediante Feign y Eureka");
        return userFeignClient.obtenerUsuarios();
    }

    @GetMapping("/productos")
    public String obtenerProductosDesdeProductsService() {
        logger.info("Orders Service consulta Products Service mediante Feign y Eureka");
        return productFeignClient.obtenerProductos();
    }

}