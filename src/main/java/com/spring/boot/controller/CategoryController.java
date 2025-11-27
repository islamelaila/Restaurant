package com.spring.boot.controller;
import com.spring.boot.dto.CategoryDto;
import com.spring.boot.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> saveCategory (@RequestBody @Valid CategoryDto categoryDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/categories/save/")).body(categoryService.saveCategory(categoryDto));
    }

    @PostMapping("/saves")
    public ResponseEntity<List<CategoryDto>> saveCategories (@RequestBody @Valid List<CategoryDto> categoryDtos) throws URISyntaxException {
        return ResponseEntity.created(new URI("/categories/saves/")).body(categoryService.saveCategories(categoryDtos));
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto));
    }

    @PutMapping("/updates")
    public ResponseEntity<List<CategoryDto>> updateCategories (@RequestBody List<CategoryDto> categoryDtos) {
        return ResponseEntity.ok(categoryService.updateCategories(categoryDtos));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteCategory (@RequestParam Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletes")
    public ResponseEntity<Void> deleteCategories (@RequestParam List<Long> ids) {
        categoryService.deleteCategories(ids);
        return ResponseEntity.noContent().build();
    }

}
