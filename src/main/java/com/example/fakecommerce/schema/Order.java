package com.example.fakecommerce.schema;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
@SQLDelete(sql = "UPDATE orders SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class Order extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private OrderStatus status = OrderStatus.PENDING;
    private Integer quantity;
}


//    @ManyToMany(fetch = FetchType.LAZY)
//using join table it gets lil messy adding more tables
//    @JoinTable(name = "order_products",
//            joinColumns = @JoinColumn(name = "order_id"), //FK belonging to current table
//            inverseJoinColumns = @JoinColumn(name = "product_id")) //FK belonging to other table
//    private List<Product> products;