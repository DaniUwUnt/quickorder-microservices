package com.quickorder.order_items_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickorder.order_items_service.model.OrderItem;
import com.quickorder.order_items_service.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository OrderItemRepository;

    public List<OrderItem> listar() {
        return OrderItemRepository.findAll();
    }

    public OrderItem guardar(OrderItem OrderItem) {
        return OrderItemRepository.save(OrderItem);
    }
}