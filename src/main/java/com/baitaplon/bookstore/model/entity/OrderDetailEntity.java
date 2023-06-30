package com.baitaplon.bookstore.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    //@JsonBackReference
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "id_book")
    //@JsonBackReference
    private BookEntity book;

    @Column(name = "status")
    private int status;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity user;
}
