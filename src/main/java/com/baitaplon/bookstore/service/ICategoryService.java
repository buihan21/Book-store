package com.baitaplon.bookstore.service;

import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    CategoryDTO getByName(String name);
    List<CategoryDTO> getAll();
    CategoryDTO findById(Integer id);
    void deleteById(Integer id);

    CategoryEntity getById(Integer id);
}
