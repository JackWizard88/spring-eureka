package com.geekbrains.krylov.spring_eureka.services;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import com.geekbrains.krylov.spring_eureka.entities.Product;
import com.geekbrains.krylov.spring_eureka.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> getProductList() {
        return productRepository.findAll().stream().map(productDTOFunction).collect(Collectors.toList());
    }

    private Function<Product, ProductDTO> productDTOFunction = (product) -> {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());
        return productDto;
    };

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
}
