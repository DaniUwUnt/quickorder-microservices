package com.quickorder.order_items_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickorder.order_items_service.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}