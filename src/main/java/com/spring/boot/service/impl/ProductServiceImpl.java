package com.spring.boot.service.impl;

import com.spring.boot.dto.ProductDto;
import com.spring.boot.mapper.ProductMapper;
import com.spring.boot.model.Product;
import com.spring.boot.repo.ProductRepo;
import com.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepo productRepo;

    private ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo , ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }


    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productRepo.save(productMapper.toEntity(productDto));
        return productMapper.toDTO(product);
    }
}
