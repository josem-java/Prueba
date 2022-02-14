package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);
    Order put(Order order, Long id);
    Order get(Long id);
    List<Order> list();
}
