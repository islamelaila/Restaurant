package com.spring.boot.service;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.model.Category;

import java.util.List;

public interface CategoryService {

   List<CategoryDto> getAllCategories();

   CategoryDto getCategoryById(Long id);

   CategoryDto saveCategory(CategoryDto categoryDto);

   List<CategoryDto> saveCategories(List<CategoryDto> categoryDtos);

   CategoryDto updateCategory(CategoryDto categoryDto);

   List<CategoryDto> updateCategories(List<CategoryDto> categoryDtos);


   void deleteCategory(Long id);

   void deleteCategories(List<Long> ids);


}
