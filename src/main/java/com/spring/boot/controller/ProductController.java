package com.spring.boot.controller;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;
import com.spring.boot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/create")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/product/create")).body(productService.saveProduct(productDto));
    }


    @PostMapping("/createProducts")
    public ResponseEntity<List<ProductDto>> saveProducts(@RequestBody @Valid List<ProductDto> productDtos) throws URISyntaxException {
        return ResponseEntity.created(new URI("/product/createProducts")).body(productService.saveProducts(productDtos));
    }


    @PostMapping("/by-name/{product}/register/{category}")
    public ResponseEntity<Product> registerProductByName(@PathVariable String product , @PathVariable String category) {
        return ResponseEntity.ok(productService.registerProductToCategotyByName(product, category));
    }

    @PostMapping("/by-id/{productId}/register/{categoryId}")
    public ResponseEntity<Product> registerProductById( @PathVariable Long productId, @PathVariable Long categoryId ) {
        return ResponseEntity.ok(productService.registerProductToCategotyById(productId, categoryId));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateCategory(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @PutMapping("/updates")
    public ResponseEntity<List<ProductDto>> updateCategorys(@RequestBody List<ProductDto> productDtos){
        return ResponseEntity.ok(productService.updateProducts(productDtos));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProductById(@RequestParam Long id) {
         productService.deleteProduct(id);
         return  ResponseEntity.noContent().build();
    }


    @DeleteMapping("/deletes")
    public ResponseEntity<Void> deleteProductsByIds(@RequestParam List<Long> ids) {
         productService.deleteProducts(ids);
         return  ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

}
