package com.example.fakecommerce.services;

import com.example.fakecommerce.repositories.ProductRepository;
import com.example.fakecommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeCommerceService {
 private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
     return this.productRepository.findAll();
    }

    public Product getProductById(Long id){
        return this.productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
    }


}
