package com.geekbrains.krylov.spring_eureka.entities;

import com.geekbrains.krylov.spring_eureka.ProductDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private double pricePerProduct;

    @Column(name = "price")
    private double price;

    public OrderItem(ProductDTO p) {
        this.productId = p.getId();
        this.quantity = 1;
        this.pricePerProduct = p.getPrice();
        this.price = p.getPrice() * this.quantity;
    }

}
