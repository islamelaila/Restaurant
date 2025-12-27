package com.spring.boot.controller;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Category Controller",
        description = "APIs responsible for managing categories"
)
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @GetMapping("/all")
    @Operation(
            summary = "Get all categories",
            description = "Retrieve all categories"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Categories retrieved successfully",
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No categories found"
            )
    })
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get category by ID",
            description = "Retrieve category details by category ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Category retrieved successfully",
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Category not found"
            )
    })
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }



    @PostMapping("/save")
    @Operation(
            summary = "Create new category",
            description = "Create a single category"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Category created successfully",
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<CategoryDto> saveCategory(
            @RequestBody @Valid CategoryDto categoryDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/categories/save"))
                .body(categoryService.saveCategory(categoryDto));
    }

    @PostMapping("/saves")
    @Operation(
            summary = "Create multiple categories",
            description = "Create a list of categories"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Categories created successfully",
                    content = @Content(schema = @Schema(implementation = CategoryDto.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<List<CategoryDto>> saveCategories(
            @RequestBody @Valid List<CategoryDto> categoryDtos
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/categories/saves"))
                .body(categoryService.saveCategories(categoryDtos));
    }



    @PutMapping("/update")
    @Operation(
            summary = "Update category",
            description = "Update a single category"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category updated successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public ResponseEntity<CategoryDto> updateCategory(
            @RequestBody CategoryDto categoryDto
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto));
    }

    @PutMapping("/updates")
    @Operation(
            summary = "Update multiple categories",
            description = "Update a list of categories"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categories updated successfully")
    })
    public ResponseEntity<List<CategoryDto>> updateCategories(
            @RequestBody List<CategoryDto> categoryDtos
    ) {
        return ResponseEntity.ok(categoryService.updateCategories(categoryDtos));
    }



    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete category by ID",
            description = "Delete a category using its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public ResponseEntity<Void> deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletes")
    @Operation(
            summary = "Delete multiple categories",
            description = "Delete multiple categories using list of IDs"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Categories deleted successfully")
    })
    public ResponseEntity<Void> deleteCategories(@RequestParam List<Long> ids) {
        categoryService.deleteCategories(ids);
        return ResponseEntity.noContent().build();
    }
}
