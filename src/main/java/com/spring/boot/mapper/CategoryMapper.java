package com.spring.boot.mapper;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {



    Category toEntity(CategoryDto categoryDTO);

    List<Category> toEntityList(List<CategoryDto> categoryDtos);

    @Mapping(target = "products", ignore = true)
    CategoryDto toDTO(Category category);

    List<CategoryDto> toDTOList(List<Category> categories);

}
