package com.example.fakecommerce.controllers;


import com.example.fakecommerce.dtos.CreateProductDTO;
import com.example.fakecommerce.dtos.ResponseProductDto;
import com.example.fakecommerce.schema.Product;
import com.example.fakecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping()
    public List<ResponseProductDto> findAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findAllProducts(@PathVariable Long id){
        return this.productService.getProductById(id);
    }

    @PostMapping()
    public Product createProduct(@RequestBody CreateProductDTO product){
        return this.productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(name = "category") String category) {
        return this.productService.getProductsByCategory(category);
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return this.productService.findAllCategories();
    }

}
