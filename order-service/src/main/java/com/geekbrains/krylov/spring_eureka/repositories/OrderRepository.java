package com.geekbrains.krylov.spring_eureka.repositories;

import com.geekbrains.krylov.spring_eureka.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
