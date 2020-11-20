package com.geekbrains.krylov.spring_eureka.controllers;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import com.geekbrains.krylov.spring_eureka.entities.Product;
import com.geekbrains.krylov.spring_eureka.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

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
    public ProductDTO getProductById(@RequestParam Long id) {
        return productService.getProductById(id).map(productProductDTOFunction).get();
    }

    private final Function<Product, ProductDTO> productProductDTOFunction = (p) -> {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        return productDto;
    };

}
