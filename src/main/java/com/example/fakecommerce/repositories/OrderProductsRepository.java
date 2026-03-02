package com.example.fakecommerce.repositories;

import com.example.fakecommerce.schema.OrderProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts,Long> {
    List<OrderProducts> findByOrderId(Long orderId);
}
