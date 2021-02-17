package be.unit.demo.controller;

import be.unit.demo.entity.Order;
import be.unit.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

}
