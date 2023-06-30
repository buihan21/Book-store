package com.baitaplon.bookstore.controller.web;

import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import com.baitaplon.bookstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryApi {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryDTO> getAllCategory() {
        List<CategoryDTO> list = categoryService.getAll();
        return list;
    }

    @GetMapping("/category/name/{name}")
    public CategoryDTO getByName(@PathVariable String name) {
        CategoryDTO categoryDTO = categoryService.getByName(name);
        return categoryDTO;
    }
}
