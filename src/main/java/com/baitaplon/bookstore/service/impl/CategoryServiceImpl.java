package com.baitaplon.bookstore.service.impl;

import com.baitaplon.bookstore.exception.APIException;
import com.baitaplon.bookstore.exception.ResourceNotFoundException;
import com.baitaplon.bookstore.model.converter.CategoryConverter;
import com.baitaplon.bookstore.model.dto.CategoryDTO;
import com.baitaplon.bookstore.model.entity.CategoryEntity;
import com.baitaplon.bookstore.repository.BookRepository;
import com.baitaplon.bookstore.repository.CategoryRepository;
import com.baitaplon.bookstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryConverter converter;
    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        for (CategoryEntity category : categoryEntities) {
            if (category.getName().compareTo(categoryDTO.getName()) == 0) {
                throw new APIException(HttpStatus.BAD_REQUEST, "Category ko ton tai!");
            }
        }

        CategoryEntity categoryEntity;
        if (categoryDTO.getId() == null) {
            // create
            categoryEntity = converter.toEntity(categoryDTO);
        } else {
            //update
            CategoryEntity oldCategory = categoryRepository.findById(categoryDTO.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Category", "id", categoryDTO.getId()));
            categoryEntity = converter.toEntity(oldCategory, categoryDTO);
        }
        CategoryEntity newCategory = categoryRepository.save(categoryEntity);
        CategoryDTO responseCategory = converter.toDto(newCategory);

        return responseCategory;
    }

    @Override
    public CategoryDTO getByName(String name) {
        CategoryEntity entity = categoryRepository.findByName(name).get();
        return converter.toDto(entity);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> entityList = categoryRepository.findAll();
        List<CategoryDTO> response = new ArrayList<>();
        for (CategoryEntity entity : entityList) {
            response.add(converter.toDto(entity));
        }
        return response;
    }

    @Override
    public CategoryDTO findById(Integer id) {
        CategoryEntity response = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", id));

        return converter.toDto(response);
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public CategoryEntity getById(Integer id) {
        return categoryRepository.findById(id).get();
    }
}
