package com.spring.boot.mapper;


import com.spring.boot.dto.CategoryDto;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);

    List<Product> toEntityList(List<ProductDto> productDtos);
    ProductDto toDTO(Product product);

    List<ProductDto> toDTOList(List<Product> products);

}
