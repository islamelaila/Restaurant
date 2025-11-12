package com.spring.boot.service.impl;
import com.spring.boot.dto.CategoryDto;
import com.spring.boot.mapper.CategoryMapper;
import com.spring.boot.model.Category;
import com.spring.boot.repo.CategoryRepo;
import com.spring.boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepo categoryRepo;

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo , CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(category -> categoryMapper.toDTO(category)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category with id " + id + " not found"));
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        Category savedCategory = categoryRepo.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDto> saveCategories(List<CategoryDto> categoryDtos) {
        if (categoryDtos == null || categoryDtos.isEmpty()) {
            throw new IllegalArgumentException("Category list cannot be null or empty");
        }
        try {
            List<Category> categories = categoryMapper.toEntityList(categoryDtos);
            List<Category> savedCategories = categoryRepo.saveAll(categories);
            return categoryMapper.toDTOList(savedCategories);

        } catch (Exception e) {
            throw new RuntimeException("Error while saving categories: " + e.getMessage(), e);
        }
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (Objects.isNull(categoryDto.getId())) {
            throw new IllegalArgumentException("Category ID cannot be null for update");
        }

        Category existing = categoryRepo.findById(categoryDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Category with id " + categoryDto.getId() + " not found"));
        Category category = categoryRepo.save(categoryMapper.toEntity(categoryDto));
        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDto> updateCategories(List<CategoryDto> categoryDtos) {
        if (categoryDtos == null || categoryDtos.isEmpty()) {
            throw new IllegalArgumentException("Category list cannot be empty for update");
        }

        List<Category> categories = categoryRepo.saveAll(categoryMapper.toEntityList(categoryDtos));
        return categoryMapper.toDTOList(categories);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepo.findByName(name).get();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            throw new IllegalArgumentException("Category with id " + id + " not found");
        }
        categoryRepo.deleteById(id);
    }

    @Override
    public void deleteCategories(List<Long> ids) {
        if (ids == null || ids.isEmpty()) {
            throw new IllegalArgumentException("IDs list cannot be empty");
        }

        categoryRepo.deleteAllById(ids);
    }

}
