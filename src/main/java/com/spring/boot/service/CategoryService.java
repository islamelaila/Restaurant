package com.spring.boot.service;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

   List<CategoryDto> getAllCategories();

   CategoryDto getCategoryById(Long id);

   CategoryDto saveCategory(CategoryDto categoryDto);

   List<CategoryDto> saveCategories(List<CategoryDto> categoryDtos);

   CategoryDto updateCategory(CategoryDto categoryDto);

   List<CategoryDto> updateCategories(List<CategoryDto> categoryDtos);

   Category findByName(String name);

   Optional<Category> findById(Long id);


   void deleteCategory(Long id);

   void deleteCategories(List<Long> ids);


}
