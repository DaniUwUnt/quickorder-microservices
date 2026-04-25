package com.quickorder.order_items_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quickorder.order_items_service.model.OrderItem;
import com.quickorder.order_items_service.service.OrderItemService;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService OrderItemService;

    @GetMapping
    public List<OrderItem> listar() {
        return OrderItemService.listar();
    }

    @PostMapping
    public OrderItem guardar(@RequestBody OrderItem OrderItem) {
        return OrderItemService.guardar(OrderItem);
    }
}