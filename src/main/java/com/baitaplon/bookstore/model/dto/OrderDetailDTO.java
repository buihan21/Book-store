package com.baitaplon.bookstore.model.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private Integer id;
    private OrderDTO order;

    private Integer idBook;
    private int status;
    private int quantity;

    private Integer idUser;
}
