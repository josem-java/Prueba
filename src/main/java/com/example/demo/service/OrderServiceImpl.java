package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {this.orderRepository = orderRepository;}

    @Override
    public Order save(Order order) {return orderRepository.save(order);}

    @Override
    public Order put(Order order, Long id) {
        Order orderUpdate = this.get(id);
        orderUpdate.setState(order.getState());
        return this.save(orderUpdate);
    }

    @Override
    public Order get(Long id) {
        assert id != null;
        Optional<Order> order =  orderRepository.findById(id);
        return order.orElse(null);
    }

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }
}
