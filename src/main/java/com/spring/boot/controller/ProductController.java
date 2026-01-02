package com.spring.boot.controller;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.helper.MessageResponse;
import com.spring.boot.model.Product;
import com.spring.boot.service.ProductService;
import com.spring.boot.vm.ProductResponseVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(
        name = "Product Controller",
        description = "APIs responsible for managing products"
)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @Operation(
            summary = "Create new product",
            description = "Create a single product"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product created successfully",
                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductDto> saveProduct(
            @RequestBody @Valid ProductDto productDto
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/product/create"))
                .body(productService.saveProduct(productDto));
    }

    @PostMapping("/createProducts")
    @Operation(
            summary = "Create multiple products",
            description = "Create a list of products in one request"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Products created successfully",
                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<List<ProductDto>> saveProducts(
            @RequestBody @Valid List<ProductDto> productDtos
    ) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/product/createProducts"))
                .body(productService.saveProducts(productDtos));
    }



    @PostMapping("/by-name/{product}/register/{category}")
    @Operation(
            summary = "Register product to category by name",
            description = "Assign product to category using product name and category name"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product registered successfully",
                    content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "Product or category not found")
    })
    public ResponseEntity<Product> registerProductByName(
            @PathVariable String product,
            @PathVariable String category
    ) {
        return ResponseEntity.ok(
                productService.registerProductToCategotyByName(product, category)
        );
    }

    @PostMapping("/by-id/{productId}/register/{categoryId}")
    @Operation(
            summary = "Register product to category by ID",
            description = "Assign product to category using product ID and category ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product registered successfully"),
            @ApiResponse(responseCode = "404", description = "Product or category not found")
    })
    public ResponseEntity<Product> registerProductById(
            @PathVariable Long productId,
            @PathVariable Long categoryId
    ) {
        return ResponseEntity.ok(
                productService.registerProductToCategotyById(productId, categoryId)
        );
    }



    @PutMapping("/update")
    @Operation(
            summary = "Update product",
            description = "Update a single product"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<ProductDto> updateProduct(
            @RequestBody ProductDto productDto
    ) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @PutMapping("/updates")
    @Operation(
            summary = "Update multiple products",
            description = "Update a list of products"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Products updated successfully")
    })
    public ResponseEntity<List<ProductDto>> updateProducts(
            @RequestBody List<ProductDto> productDtos
    ) {
        return ResponseEntity.ok(productService.updateProducts(productDtos));
    }



    @DeleteMapping("/delete")
    @Operation(
            summary = "Delete product by ID",
            description = "Delete a product using its ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    public ResponseEntity<Void> deleteProductById(@RequestParam Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletes")
    @Operation(
            summary = "Delete multiple products",
            description = "Delete multiple products using list of IDs"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Products deleted successfully")
    })
    public ResponseEntity<Void> deleteProductsByIds(@RequestParam List<Long> ids) {
        productService.deleteProducts(ids);
        return ResponseEntity.noContent().build();
    }



    @GetMapping("/all")
    @PreAuthorize("hasRole('USER')")
    @Operation(
            summary = "Get all products",
            description = "Retrieve paginated list of all products"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Products retrieved successfully",
                    content = @Content(schema = @Schema(implementation = ProductResponseVm.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No products found",
                    content = @Content(schema = @Schema(implementation = MessageResponse.class))
            )
    })
    public ResponseEntity<ProductResponseVm> getAllProducts(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return ResponseEntity.ok(productService.getAllProducts(pageNumber, pageSize));
    }

    @GetMapping("/getProductsByCategoryId")
    @Operation(
            summary = "Get products by category ID",
            description = "Retrieve products by category ID with pagination"
    )
    public ResponseEntity<ProductResponseVm> getProductsByCategoryId(
            @RequestParam Long categoryId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize
    ) {
        return ResponseEntity.ok(
                productService.getProductsByCategoryId(categoryId, pageNumber, pageSize)
        );
    }

    @GetMapping("/getProductsByCategoryName/{categoryName}")
    @Operation(
            summary = "Get products by category name",
            description = "Retrieve all products by category name"
    )
    public ResponseEntity<List<ProductDto>> getProductsByCategoryName(
            @PathVariable String categoryName
    ) {
        return ResponseEntity.ok(
                productService.getProductsByCategoryName(categoryName)
        );
    }

    @GetMapping("/SearchProductByName")
    @Operation(
            summary = "Search product by name",
            description = "Search products by name with pagination"
    )
    public ResponseEntity<ProductResponseVm> searchProductByName( @RequestParam String productName, @RequestParam Integer pageNumber, @RequestParam Integer pageSize ) {
        return ResponseEntity.ok(productService.searchProductByName(productName, pageNumber, pageSize)
        );
    }
}
