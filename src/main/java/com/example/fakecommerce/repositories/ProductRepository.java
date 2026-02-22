package com.example.fakecommerce.repositories;

import com.example.fakecommerce.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products extends JpaRepository<Product,Long> {
}
