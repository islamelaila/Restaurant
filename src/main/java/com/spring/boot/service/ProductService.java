package com.spring.boot.service;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;

import java.util.List;

public interface ProductService {
    ProductDto saveProduct(ProductDto productDto);

    List<ProductDto> saveProducts(List<ProductDto> productDtos);

    Product registerProductToCategotyByName (String productName , String categoryName);

    Product registerProductToCategotyById (Long productId , Long categoryId);

    ProductDto updateProduct(ProductDto productDto);

    List<ProductDto> updateProducts(List<ProductDto> productDtos);

    void deleteProduct(Long id);

    void deleteProducts(List<Long> ids);


}
