package com.example.fakecommerce.schema;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY) // this can be read as many products belong to one category
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    private float rating;

    @Column(columnDefinition = "TEXT")
    private String description;
}
