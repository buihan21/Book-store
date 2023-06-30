package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    public CategoryDTO toDto(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public CategoryEntity toEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        return entity;
    }

    public CategoryEntity toEntity(CategoryEntity entity, CategoryDTO dto) {
        entity.setName(dto.getName());
        return entity;
    }
}
