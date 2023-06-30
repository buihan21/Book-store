package com.baitaplon.bookstore.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class BookDTO {
    private Integer id;
    private String name;

    private String title;
    private String author;
    private Date release_date;
    private Integer total_page;
    private String image;
    private Integer price;
    private Integer status;
    private String description;
    private int available;

    private Integer categoryId;
    private String categoryName;
    //private CategoryDTO categoryDTO;
    private List<ReviewDTO> reviewDTOList = new ArrayList<>();
}
