package com.geekbrains.krylov.spring_eureka.services;

import com.geekbrains.krylov.spring_eureka.OrderDTO;
import com.geekbrains.krylov.spring_eureka.OrderItemDTO;
import com.geekbrains.krylov.spring_eureka.entities.Order;
import com.geekbrains.krylov.spring_eureka.entities.OrderItem;
import com.geekbrains.krylov.spring_eureka.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRequest productRequest;

    public List<OrderDTO> getOrderDTOList() {
        return orderRepository.findAll().stream().map(this::mapToOrderDTO).collect(Collectors.toList());
    }

    public void createOrder(Long firstId, Long[] ids) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        System.err.println(productRequest.getProductById(firstId));
        orderItems.add(new OrderItem(productRequest.getProductById(firstId)));

        if (ids != null) {
            for (Long id : ids) {
                orderItems.add(new OrderItem(productRequest.getProductById(id)));
            }
        }

        order.setItems(orderItems);

        double orderPrice = 0;
        for (OrderItem orderItem : orderItems) {
            orderPrice += orderItem.getPrice();
        }
        order.setPrice(orderPrice);

        orderRepository.save(order);
    }

    private OrderDTO mapToOrderDTO(Order o) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(o.getId());
        orderDTO.setPrice(o.getPrice());
        orderDTO.setOrderItems(o.getItems().stream().map(this::mapToOrderItemsDTO).collect(Collectors.toList()));
        return orderDTO;
    }

    private OrderItemDTO mapToOrderItemsDTO(OrderItem oi) {
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setProductId(oi.getProductId());
        orderItemDTO.setProductTitle(productRequest.getProductById(oi.getProductId()).getTitle());
        orderItemDTO.setPrice(oi.getPrice());
        orderItemDTO.setPricePerProduct(oi.getPricePerProduct());
        orderItemDTO.setQuantity(oi.getQuantity());

        return orderItemDTO;
    }
}
