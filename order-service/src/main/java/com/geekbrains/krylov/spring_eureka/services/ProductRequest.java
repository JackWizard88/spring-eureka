package com.geekbrains.krylov.spring_eureka.services;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
public interface ProductRequest {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/products")
    ProductDTO getProductById(@RequestParam Long id);
}