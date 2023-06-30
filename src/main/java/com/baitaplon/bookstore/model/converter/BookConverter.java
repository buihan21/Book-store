package com.baitaplon.bookstore.model.converter;

import com.baitaplon.bookstore.model.dto.BookDTO;
import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.BookEntity;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class BookConverter {

    public static CategoryConverter categoryConverter;
    public static BookDTO toDto(BookEntity entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setStatus(entity.getStatus());
        dto.setTotal_page(entity.getTotal_page());
        dto.setRelease_date(entity.getRelease_date());
        dto.setAvailable(entity.getAvailable());
        //dto.setCategoryDTO(categoryConverter.toDto(entity.getCategory()));
        dto.setCategoryId(entity.getCategory().getId());
        dto.setCategoryName(entity.getCategory().getName());
        return dto;
    }

    public static BookEntity toEntity(BookDTO dto, CategoryEntity categoryEntity) {
        BookEntity entity = new BookEntity();
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setImage(dto.getImage());
        entity.setTotal_page(dto.getTotal_page());
        entity.setPrice(dto.getPrice());
        entity.setRelease_date(dto.getRelease_date());
        entity.setAvailable(dto.getAvailable());
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }


        entity.setCategory(categoryEntity);
        //entity.setCategory(categoryConverter.toEntity(dto.getCategoryDTO()));
        return entity;
    }

    public static BookEntity toEntity(BookDTO dto) {
        BookEntity entity = new BookEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        entity.setPrice(dto.getPrice());
        entity.setTotal_page(dto.getTotal_page());
        entity.setAvailable(dto.getAvailable());
        return entity;
    }

    public static BookEntity toEntity(BookEntity entity, BookDTO dto) {
        if (dto.getAuthor() != null) {
            entity.setAuthor(dto.getAuthor());
        }
        if (dto.getTitle() != null) {
            entity.setTitle(dto.getTitle());
        }
        if (dto.getTotal_page() != null) {
            entity.setTitle(dto.getTitle());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (!entity.getImage().equals(dto.getImage()) && !dto.getImage().equals("")) {
            entity.setImage(dto.getImage());
        }
        return entity;
    }
}
