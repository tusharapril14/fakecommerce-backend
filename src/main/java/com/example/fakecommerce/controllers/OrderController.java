package com.example.fakecommerce.controllers;


import com.example.fakecommerce.dtos.OrderCreateDTO;
import com.example.fakecommerce.dtos.OrderResponseDTO;
import com.example.fakecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping()
    public OrderResponseDTO createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        return this.orderService.createOrder(orderCreateDTO);
    }
    @GetMapping("/{id}")
    public List<OrderResponseDTO> getOrderProductsById(@PathVariable Long id){
        return this.orderService.getOrderProducts(id);
    }
}
