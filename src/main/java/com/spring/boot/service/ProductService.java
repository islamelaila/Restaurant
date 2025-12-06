package com.spring.boot.service;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;
import com.spring.boot.vm.ProductResponseVm;

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


    ProductResponseVm getAllProducts(Integer pageNumber, Integer pageSize);


    ProductResponseVm getProductsByCategoryId(Long categoryId ,Integer pageNumber, Integer pageSize);

    ProductResponseVm searchProductByName(String productName,Integer pageNumber, Integer pageSize );


    List<ProductDto> getProductsByCategoryName(String categoryName);


    List<ProductDto> getProductsByIds(List<Long> ids);



}
