package com.example.fakecommerce.repositories;

import com.example.fakecommerce.dtos.ProductsWithDetailsResponseDTO;
import com.example.fakecommerce.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByCategoryName(String category);

    @Query(nativeQuery = true, value= "SELECT DISTINCT category FROM products")
    List<String> findAllDistinctCategories();

    @Query("SELECT p FROM Product p JOIN FETCH p.category")
    List<Product> findProductsWithDetails();

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.id = :id")
    Product findProductWithDetails(Long id);
}

