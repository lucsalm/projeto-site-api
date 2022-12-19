package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private String orderId;

    @Column(name="order_user_id")
    private String userId;

    @Column(name = "product_id")
    private String productId;

    @Column(name="last_alter_date")
    private LocalDateTime lastAlterDate;

    @Column(name="active_order")
    private Boolean activeOrder;

    @Column(name="quantity")
    private Integer quantity;
}
