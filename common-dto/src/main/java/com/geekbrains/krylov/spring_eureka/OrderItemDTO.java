package com.geekbrains.krylov.spring_eureka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDTO {

    private Long productId;
    private String productTitle;
    private int quantity;
    private double pricePerProduct;
    private double price;

}
