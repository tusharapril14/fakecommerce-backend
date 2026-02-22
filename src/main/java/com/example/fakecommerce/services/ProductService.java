package com.example.fakecommerce.services;

import com.example.fakecommerce.dtos.CreateProductDTO;
import com.example.fakecommerce.repositories.ProductRepository;
import com.example.fakecommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
 private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
     return this.productRepository.findAll();
    }

    public Product getProductById(Long id){
        return this.productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    public Product createProduct(CreateProductDTO reqDto){
        Product newProduct = Product.builder()
                            .title(reqDto.getTitle())
                            .price(reqDto.getPrice())
                            .rating(reqDto.getRating())
                            .imgUrl(reqDto.getImgUrl())
                            .category(reqDto.getCategory())
                            .description(reqDto.getDescription()).build();
        return this.productRepository.save(newProduct);
    }

    public List<Product> getProductsByCategory(String category){
        return this.productRepository.findProductByCategory(category);
    }

    public String deleteProduct(Long id) {
        this.productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }

    public List<String> findAllCategories() {
        return this.productRepository.findAllDistinctCategories();
    }
}
