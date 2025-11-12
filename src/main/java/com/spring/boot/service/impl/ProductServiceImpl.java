package com.spring.boot.service.impl;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.mapper.CategoryMapper;
import com.spring.boot.mapper.ProductMapper;
import com.spring.boot.model.Category;
import com.spring.boot.model.Product;
import com.spring.boot.repo.ProductRepo;
import com.spring.boot.service.CategoryService;
import com.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepo productRepo;

    private ProductMapper productMapper;

    private CategoryService categoryService;

    private CategoryMapper categoryMapper;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo , ProductMapper productMapper , CategoryService categoryService , CategoryMapper categoryMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productRepo.save(productMapper.toEntity(productDto));
        return productMapper.toDTO(product);
    }



    @Override
    public List<ProductDto> saveProducts(List<ProductDto> productDtos) {
        if (productDtos == null || productDtos.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty for save");
        }

        List<Product> products = productMapper.toEntityList(productDtos);
        productRepo.saveAll(products);
        return productMapper.toDTOList(products);
    }

    @Override
    public Product registerProductToCategotyByName(String productName, String categoryName) {
        Product product = productRepo.findByNameIgnoreCase(productName);
        if (product == null) {
            throw new RuntimeException("Product not found with name: " + productName);
        }
        Category category = categoryService.findByName(categoryName);
        if (category == null) {
            throw new RuntimeException("Category not found with name: " + categoryName);
        }
         product.setCategory(category);
        category.getProducts().add(product);

        return productRepo.save(product);
    }

    @Override
    public Product registerProductToCategotyById(Long productId, Long categoryId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Category category = categoryService.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + categoryId));

        product.setCategory(category);

        return productRepo.save(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepo.findById(productDto.getId())
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productDto.getId()));

        productMapper.toEntity(productDto);
        productRepo.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDto> updateProducts(List<ProductDto> productDtos) {
        if (productDtos == null || productDtos.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty for update");
        }
        List<Product> products = productMapper.toEntityList(productDtos);
        productRepo.saveAll(products);
        return productMapper.toDTOList(products);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void deleteProducts(List<Long> ids) {
        productRepo.deleteAllById(ids);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        if (products.isEmpty()) {
            throw new RuntimeException("No.products.found");
        }
        return productMapper.toDTOList(products);
    }

}
