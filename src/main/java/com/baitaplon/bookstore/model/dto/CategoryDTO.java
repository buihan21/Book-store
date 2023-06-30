package com.baitaplon.bookstore.model.dto;

import com.baitaplon.bookstore.model.entity.BookEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private List<BookDTO> bookDTOList = new ArrayList<>();

}
