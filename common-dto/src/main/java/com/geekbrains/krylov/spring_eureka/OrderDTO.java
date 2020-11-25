package com.geekbrains.krylov.spring_eureka;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private double price;
    private List<OrderItemDTO> orderItems;

}
