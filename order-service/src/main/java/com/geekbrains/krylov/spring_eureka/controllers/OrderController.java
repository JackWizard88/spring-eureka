package com.geekbrains.krylov.spring_eureka.controllers;

import com.geekbrains.krylov.spring_eureka.OrderDTO;
import com.geekbrains.krylov.spring_eureka.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> getOrderList() {
        return orderService.getOrderDTOList();
    }

    @PutMapping
    public void createOrder(@RequestParam Long id,
                            @RequestParam(required = false) Long... ids) {
        orderService.createOrder(id, ids);
    }

}
