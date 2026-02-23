package com.example.fakecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductDTO {
    private String title;
    private BigDecimal price;
    private String imgUrl;
    private float rating;
    private String description;
    private Long categoryId;

}
