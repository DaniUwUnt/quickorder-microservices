package com.quickorder.orders_service.service;

import com.quickorder.orders_service.model.Pedido;
import com.quickorder.orders_service.repository.PedidoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    private Pedido pedido;

    @BeforeEach
    void configurarDatos() {
        pedido = new Pedido();
        pedido.setInformacion("Pedido de sushi");
        pedido.setEstado("pendiente");
        pedido.setMontoTotal(20000);
        pedido.setFechaPedido(LocalDate.of(2026, 5, 2));
        pedido.setTipoPedido("delivery");
    }

    @Test
    @DisplayName("Debe listar todos los pedidos")
    void debeListarTodosLosPedidos() {
        // Given
        Pedido pedido2 = new Pedido();
        pedido2.setInformacion("Pedido pizza");
        pedido2.setEstado("pendiente");
        pedido2.setMontoTotal(15000);
        pedido2.setFechaPedido(LocalDate.of(2026, 5, 2));
        pedido2.setTipoPedido("delivery");
            
        when(pedidoRepository.findAll()).thenReturn(List.of(pedido, pedido2));

        // When
        List<Pedido> resultado = pedidoService.listar();

        // Then
        assertEquals(2, resultado.size());
        assertEquals("Pedido de sushi", resultado.get(0).getInformacion());
        assertEquals("Pedido pizza", resultado.get(1).getInformacion());

        verify(pedidoRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Debe guardar un pedido válido")
    void debeGuardarPedidoValido() {
        // Given
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(pedido);

        // When
        Pedido resultado = pedidoService.guardar(pedido);

        // Then
        assertNotNull(resultado);
        assertEquals("Pedido de sushi", resultado.getInformacion());
        assertEquals(20000, resultado.getMontoTotal());

        verify(pedidoRepository, times(1)).save(pedido);
    }

    @Test
    @DisplayName("Debe buscar un pedido por ID existente")
    void debeBuscarPedidoPorIdExistente() {
        // Given
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));

        // When
        Optional<Pedido> resultado = pedidoService.buscarPorId(1L);

        // Then
        assertTrue(resultado.isPresent());
        assertEquals("Pedido de sushi", resultado.get().getInformacion());
        assertEquals("pendiente", resultado.get().getEstado());

        verify(pedidoRepository, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Debe retornar vacío cuando el pedido no existe")
    void debeRetornarVacioCuandoPedidoNoExiste() {
        // Given
        when(pedidoRepository.findById(99L)).thenReturn(Optional.empty());

        // When
        Optional<Pedido> resultado = pedidoService.buscarPorId(99L);

        // Then
        assertTrue(resultado.isEmpty());

        verify(pedidoRepository, times(1)).findById(99L);
    }

    @Test
    @DisplayName("Debe actualizar un pedido existente")
    void debeActualizarPedidoExistente() {
        // Given
        Pedido pedidoActualizado = new Pedido();
        pedidoActualizado.setInformacion("Pedido actualizado");
        pedidoActualizado.setEstado("completado");
        pedidoActualizado.setMontoTotal(25000);
        pedidoActualizado.setFechaPedido(LocalDate.of(2026, 5, 3));
        pedidoActualizado.setTipoPedido("retiro");

        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(pedido));
        when(pedidoRepository.save(any(Pedido.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Pedido resultado = pedidoService.actualizar(1L, pedidoActualizado);

        // Then
        assertNotNull(resultado);
        assertEquals("Pedido actualizado", resultado.getInformacion());
        assertEquals("completado", resultado.getEstado());
        assertEquals(25000, resultado.getMontoTotal());
        assertEquals("retiro", resultado.getTipoPedido());

        verify(pedidoRepository, times(1)).findById(1L);
        verify(pedidoRepository, times(1)).save(any(Pedido.class));
    }

    @Test
    @DisplayName("Debe retornar null al actualizar un pedido inexistente")
    void debeRetornarNullAlActualizarPedidoInexistente() {
        // Given
        Pedido pedidoActualizado = new Pedido();
        when(pedidoRepository.findById(99L)).thenReturn(Optional.empty());

        // When
        Pedido resultado = pedidoService.actualizar(99L, pedidoActualizado);

        // Then
        assertNull(resultado);
        verify(pedidoRepository, times(1)).findById(99L);
        verify(pedidoRepository, never()).save(any(Pedido.class));
    }

    @Test
    @DisplayName("Debe eliminar un pedido por ID")
    void debeEliminarPedidoPorId() {
        // Given
        doNothing().when(pedidoRepository).deleteById(1L);

        // When
        pedidoService.eliminar(1L);

        // Then
        verify(pedidoRepository, times(1)).deleteById(1L);
    }
}