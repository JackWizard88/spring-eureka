package com.geekbrains.krylov.spring_eureka.repositories;

import com.geekbrains.krylov.spring_eureka.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
