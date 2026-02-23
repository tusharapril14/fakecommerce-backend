package com.example.fakecommerce.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
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

    @ManyToOne // this can be read as many products belong to one category
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
    private float rating;

    @Column(columnDefinition = "TEXT")
    private String description;
}
