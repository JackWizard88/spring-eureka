package com.geekbrains.krylov.spring_eureka.controllers;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import com.geekbrains.krylov.spring_eureka.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public List<ProductDTO> getProductList() {
        return productService.getProductList();
    }

    @GetMapping
    public List<ProductDTO> getProductByIds(@RequestParam Long... ids) {
        return productService.getProductByIds(ids);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id).get();
    }

}
