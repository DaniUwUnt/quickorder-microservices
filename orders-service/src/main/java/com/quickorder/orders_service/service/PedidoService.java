package com.quickorder.orders_service.service;

import com.quickorder.orders_service.model.Pedido;
import com.quickorder.orders_service.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizar(Long id, Pedido pedidoActualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setInformacion(pedidoActualizado.getInformacion());
                    pedido.setEstado(pedidoActualizado.getEstado());
                    pedido.setMontoTotal(pedidoActualizado.getMontoTotal());
                    pedido.setFechaPedido(pedidoActualizado.getFechaPedido());
                    pedido.setTipoPedido(pedidoActualizado.getTipoPedido());
                    return pedidoRepository.save(pedido);
                })
                .orElse(null);
    }

    public void eliminar(Long id) {
        pedidoRepository.deleteById(id);
    }
}