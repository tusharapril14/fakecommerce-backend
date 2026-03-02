package com.example.fakecommerce.services;


import com.example.fakecommerce.dtos.OrderCreateDTO;
import com.example.fakecommerce.dtos.OrderResponseDTO;
import com.example.fakecommerce.dtos.ResponseProductDto;
import com.example.fakecommerce.repositories.OrderProductsRepository;

import com.example.fakecommerce.repositories.OrderRepository;
import com.example.fakecommerce.repositories.ProductRepository;
import com.example.fakecommerce.schema.Order;
import com.example.fakecommerce.schema.OrderProducts;
import com.example.fakecommerce.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderProductsRepository orderProductsRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderResponseDTO createOrder(OrderCreateDTO reqDto){
        Order order = Order.builder()
                .quantity(reqDto.getQuantity())
                .build();
        this.orderRepository.save(order);
        Product product = this.productRepository.findById(reqDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        OrderProducts orderProducts = OrderProducts.builder()
                .order(order)
                .product(product)
                .quantity(reqDto.getQuantity())
                .build();
        this.orderProductsRepository.save(orderProducts);

        return OrderResponseDTO.builder()
                .id(order.getId())
                .quantity(order.getQuantity())
                .status(order.getStatus())
                .product(ResponseProductDto.builder()
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .imgUrl(product.getImgUrl())
                        .rating(product.getRating())
                        .description(product.getDescription())
                        .build())
                .build();
    }

    public List<OrderResponseDTO> getOrderProducts(Long orderId){
        List<OrderProducts> orderProducts = this.orderProductsRepository.findByOrderId(orderId);
        return orderProducts.stream().map(op -> {
            Order order = op.getOrder();
            Product product = op.getProduct();
            return OrderResponseDTO.builder()
                    .id(order.getId())
                    .quantity(order.getQuantity())
                    .status(order.getStatus())
                    .product(ResponseProductDto.builder()
                            .title(product.getTitle())
                            .price(product.getPrice())
                            .imgUrl(product.getImgUrl())
                            .rating(product.getRating())
                            .description(product.getDescription())
                            .build())
                    .build();
        }).toList();
    }

}
