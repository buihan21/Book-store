package com.baitaplon.bookstore.model.entity;

import com.baitaplon.bookstore.model.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    //@JsonBackReference
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    //@JsonManagedReference
    private List<OrderDetailEntity> orderDetailList = new ArrayList<>();

    @Column(name = "is_confirmed")
    private int isConfirmed;

    @Column(name = "date")
    private Date date;
}
