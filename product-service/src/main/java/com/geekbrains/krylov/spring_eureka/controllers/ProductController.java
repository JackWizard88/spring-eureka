package com.geekbrains.krylov.spring_eureka.controllers;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import com.geekbrains.krylov.spring_eureka.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProductList() {
        return productService.getProductList();
    }

    @GetMapping
    public ProductDTO getProductById(@RequestParam Long id) {

        return new ProductDTO(productService.getProductById(id).get());
    }

    private ProductDTO mapT

}
