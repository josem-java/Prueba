package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @GetMapping
    public ResponseEntity<List<Order>> get(){
        List<Order> orderList = orderService.list();
        return ResponseEntity.ok().body(orderList);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order){
        Order orderSaved = orderService.save(order);
        return ResponseEntity.ok().body(orderSaved);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> put(@PathVariable("id") Long id, @RequestBody Order order){
        Order orderUpdate = orderService.put(order,id);
        return ResponseEntity.ok().body(orderUpdate);
    }
}
