package com.example.fakecommerce.schema;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at IS NULL")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private BigDecimal price;
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY) // this can be read as many products belong to one category
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @Column(nullable = false)
    private float rating;

    @Column(columnDefinition = "TEXT")
    private String description;
}
