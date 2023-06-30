package com.baitaplon.bookstore.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private int id;
    private int idUser;
    private Date date;
    private int isConfirmed;
    private List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
}
