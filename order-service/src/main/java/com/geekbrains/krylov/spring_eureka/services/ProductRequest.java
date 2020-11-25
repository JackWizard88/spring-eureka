package com.geekbrains.krylov.spring_eureka.services;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("product-service")
public interface ProductRequest {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/products")
    List<ProductDTO> getProductByIds(@RequestParam Long[] ids);

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);
}