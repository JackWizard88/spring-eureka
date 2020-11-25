package com.geekbrains.krylov.spring_eureka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String title;
    private double price;

}