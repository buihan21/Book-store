package com.baitaplon.bookstore.model.dto;

import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.UserEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class ReviewDTO {
    private Integer id;
    //private BookEntity book;
    private Integer idBook;
    //private UserEntity user;
    private Integer idUser;
    private int rate;
    private String comment;
    private Date createdDate;
}
